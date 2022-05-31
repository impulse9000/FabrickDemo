package com.example.fabrick.services.interfaces;

import com.example.fabrick.models.BalanceResponse;
import com.example.fabrick.models.MoneyTransferRequest;
import com.example.fabrick.models.MoneyTransferResponse;
import com.example.fabrick.models.TransactionResponse;

import java.io.IOException;
import java.net.URISyntaxException;

public interface DemoService {
    BalanceResponse getBalance () throws IOException, InterruptedException;
    MoneyTransferResponse moneyTransfer (MoneyTransferRequest moneyTransferRequest) throws IOException, InterruptedException;
    TransactionResponse getTransactions (String fromAccountingDate, String toAccountingDate) throws IOException, InterruptedException, URISyntaxException;
}
