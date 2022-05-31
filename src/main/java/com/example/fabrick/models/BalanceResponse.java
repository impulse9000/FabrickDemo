package com.example.fabrick.models;

public class BalanceResponse extends BaseResponse{

    private Payload payload;

    public static class Payload {
        private float balance;
        private float availableBalance;
        private String currency;

        public Payload(float balance, float availableBalance, String currency) {
            this.balance = balance;
            this.availableBalance = availableBalance;
            this.currency = currency;
        }

        public float getBalance() {
            return balance;
        }

        public void setBalance(float balance) {
            this.balance = balance;
        }

        public float getAvailableBalance() {
            return availableBalance;
        }

        public void setAvailableBalance(float availableBalance) {
            this.availableBalance = availableBalance;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public BalanceResponse(String status, FabrickError[] error, Payload payload) {
        super(status, error);
        this.payload = payload;
    }
}
