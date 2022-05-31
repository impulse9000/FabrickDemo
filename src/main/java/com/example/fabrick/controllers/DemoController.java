package com.example.fabrick.controllers;

import com.example.fabrick.constants.ErrorMap;
import com.example.fabrick.models.*;
import com.example.fabrick.services.interfaces.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

@RestController
public class DemoController {

    Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    DemoService demoService;

    @Value("${fabrick.default.account.id}")
    private String defaultAccountId;

    @GetMapping("/balance")
    public ResponseEntity<?> getBalanceByAccountId() throws IOException, InterruptedException {
        try {
            BalanceResponse balanceResp = demoService.getBalance();
            if (Objects.equals(balanceResp.getStatus(),"OK")){
                return ResponseEntity.ok(balanceResp.getPayload().getBalance() + " " + balanceResp.getPayload().getCurrency());
            }
            else if (balanceResp.getErrors().length > 0){
                return ResponseEntity.internalServerError().body(new ErrorResponse(balanceResp.getErrors()[0].getCode(),balanceResp.getErrors()[0].getDescription()));
            }
            return ResponseEntity.internalServerError().body(new ErrorResponse(ErrorMap.INTERNAL_SERVER_ERROR_CODE,ErrorMap.INTERNAL_SERVER_ERROR_DESCRIPTION));
        }
        catch(Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.internalServerError().body(new ErrorResponse(ErrorMap.INTERNAL_SERVER_ERROR_CODE,ErrorMap.INTERNAL_SERVER_ERROR_DESCRIPTION));
        }
    }

    @PostMapping("/moneyTransfer")
    public ResponseEntity<?> moneyTransfer(@RequestBody MoneyTransferRequest moneyTransferRequest) throws IOException, InterruptedException {
        try {
            MoneyTransferResponse moneyTransferResp = demoService.moneyTransfer(moneyTransferRequest);
            if (Objects.equals(moneyTransferResp.getStatus(), "OK")) {
                return ResponseEntity.ok(moneyTransferResp.getPayload().getStatus());
            }
            else{
                if (Arrays.stream(moneyTransferResp.getErrors()).anyMatch(el -> Objects.equals(el.getCode(), ErrorMap.DAILY_LIMIT_EXCEEDING_FABRICK_CODE))){
                    return ResponseEntity.badRequest().body(new ErrorResponse(ErrorMap.DAILY_LIMIT_EXCEEDING_INTERNAL_CODE, ErrorMap.DAILY_LIMIT_EXCEEDING_INTERNAL_DESCRIPTION.replace("{accountId}", defaultAccountId)));
                }
                else if (moneyTransferResp.getErrors().length > 0) {
                    return ResponseEntity.badRequest().body(new ErrorResponse(moneyTransferResp.getErrors()[0].getCode(), moneyTransferResp.getErrors()[0].getDescription()));
                }
            }
            return ResponseEntity.internalServerError().body(new ErrorResponse(ErrorMap.INTERNAL_SERVER_ERROR_CODE,ErrorMap.INTERNAL_SERVER_ERROR_DESCRIPTION));
        }
        catch(Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.internalServerError().body(new ErrorResponse(ErrorMap.INTERNAL_SERVER_ERROR_CODE,ErrorMap.INTERNAL_SERVER_ERROR_DESCRIPTION));
        }
    }

    @GetMapping("/transactions")
    public ResponseEntity<?> getTransactions(
            @RequestParam(name = "fromAccountingDate") String fromAccountingDate,
            @RequestParam(name = "toAccountingDate") String toAccountingDate) throws IOException, InterruptedException {
        try {
            TransactionResponse transactionResp = demoService.getTransactions(fromAccountingDate, toAccountingDate);
            if (Objects.equals(transactionResp.getStatus(),"OK")){
                return ResponseEntity.ok(transactionResp.getPayload().getList());
            }
            else if (transactionResp.getErrors().length > 0){
                return ResponseEntity.internalServerError().body(new ErrorResponse(transactionResp.getErrors()[0].getCode(),transactionResp.getErrors()[0].getDescription()));
            }
            return ResponseEntity.internalServerError().body(new ErrorResponse(ErrorMap.INTERNAL_SERVER_ERROR_CODE,ErrorMap.INTERNAL_SERVER_ERROR_DESCRIPTION));
        }
        catch(Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.internalServerError().body(new ErrorResponse(ErrorMap.INTERNAL_SERVER_ERROR_CODE,ErrorMap.INTERNAL_SERVER_ERROR_DESCRIPTION));
        }
    }
}
