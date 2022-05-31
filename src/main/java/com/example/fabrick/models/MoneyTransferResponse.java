package com.example.fabrick.models;

public class MoneyTransferResponse extends BaseResponse{

    private Payload payload;

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public MoneyTransferResponse(String status, FabrickError[] error, Payload payload) {
        super(status, error);
        this.payload = payload;
    }

    public static class Payload {
        private String moneyTransferId;
        private String status;
        private Creditor creditor;

        public Payload(String moneyTransferId, String status, Creditor creditor) {
            this.moneyTransferId = moneyTransferId;
            this.status = status;
            this.creditor = creditor;
        }

        public String getMoneyTransferId() {
            return moneyTransferId;
        }

        public void setMoneyTransferId(String moneyTransferId) {
            this.moneyTransferId = moneyTransferId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Creditor getCreditor() {
            return creditor;
        }

        public void setCreditor(Creditor creditor) {
            this.creditor = creditor;
        }
    }

}
