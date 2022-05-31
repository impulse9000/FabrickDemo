package com.example.fabrick.models;

public class TransactionResponse extends BaseResponse{

    private Payload payload;

    public TransactionResponse(String status, FabrickError[] error, Payload payload) {
        super(status, error);
        this.payload = payload;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public static class Payload {
        private Transaction[] list;

        public Payload(Transaction[] list) {
            this.list = list;
        }

        public Transaction[] getList() {
            return list;
        }

        public void setList(Transaction[] list) {
            this.list = list;
        }
    }

}
