package com.example.fabrick.services;

import com.example.fabrick.constants.FabrickApi;
import com.example.fabrick.models.BalanceResponse;
import com.example.fabrick.models.MoneyTransferRequest;
import com.example.fabrick.models.MoneyTransferResponse;
import com.example.fabrick.models.TransactionResponse;
import com.example.fabrick.services.interfaces.DemoService;
import com.google.gson.Gson;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class DemoServiceImpl implements DemoService {

    Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Value("${fabrick.default.account.id}")
    private String defaultAccountId;

    @Value("${fabrick.api.key}")
    private String apiKey;

    @Value("${fabrick.auth.schema}")
    private String authSchema;

    private HttpClient client = HttpClient.newHttpClient();

    @Override
    public BalanceResponse getBalance() throws IOException, InterruptedException {

        // create a request
        HttpRequest request = HttpRequest.newBuilder(
                        URI.create(FabrickApi.BASE_URL + FabrickApi.BALANCE.replace("{accountId}", defaultAccountId)))
                .header("accept", "application/json")
                .header("apiKey", apiKey)
                .header("Auth-Schema", authSchema)
                .GET()
                .build();

        // send the request and get the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // map json to response object
        Gson gson = new Gson();
        return gson.fromJson(response.body(), BalanceResponse.class);

    }

    @Override
    public MoneyTransferResponse moneyTransfer(MoneyTransferRequest moneyTransferRequest) throws IOException, InterruptedException {

    logger.info(new Gson().toJson(moneyTransferRequest));
        HttpRequest request = HttpRequest.newBuilder(
                        URI.create(FabrickApi.BASE_URL + FabrickApi.MONEY_TRANSFER.replace("{accountId}", defaultAccountId)))
                .header("accept", "application/json")
                .header("apiKey", apiKey)
                .header("Auth-Schema", authSchema)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(new Gson().toJson(moneyTransferRequest)))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        return gson.fromJson(response.body(), MoneyTransferResponse.class);
    }

    @Override
    public TransactionResponse getTransactions(String fromAccountingDate, String toAccountingDate) throws IOException, InterruptedException, URISyntaxException {

        URI uri = new URIBuilder(FabrickApi.BASE_URL + FabrickApi.TRANSACTIONS.replace("{accountId}", defaultAccountId))
                .addParameter("fromAccountingDate", fromAccountingDate)
                .addParameter("toAccountingDate", toAccountingDate)
                .build();
        HttpRequest request = HttpRequest.newBuilder(uri)
                .header("accept", "application/json")
                .header("apiKey", apiKey)
                .header("Auth-Schema", authSchema)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        return gson.fromJson(response.body(), TransactionResponse.class);
    }
}
