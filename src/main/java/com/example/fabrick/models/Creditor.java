package com.example.fabrick.models;

public class Creditor {

    private String name;
    private CreditorAccount account;
    private CreditorAddress address;

    public static class CreditorAccount {

        private String accountCode;
        private String bicCode;

        public CreditorAccount(String accountCode, String bicCode) {
            this.accountCode = accountCode;
            this.bicCode = bicCode;
        }

        public String getAccountCode() {
            return accountCode;
        }

        public void setAccountCode(String accountCode) {
            this.accountCode = accountCode;
        }

        public String getBicCode() {
            return bicCode;
        }

        public void setBicCode(String bicCode) {
            this.bicCode = bicCode;
        }
    }

    public static class CreditorAddress {

        private String address;
        private String city;
        private String countryCode;

        public CreditorAddress(String address, String city, String countryCode) {
            this.address = address;
            this.city = city;
            this.countryCode = countryCode;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreditorAccount getAccount() {
        return account;
    }

    public void setAccount(CreditorAccount account) {
        this.account = account;
    }

    public CreditorAddress getAddress() {
        return address;
    }

    public void setAddress(CreditorAddress address) {
        this.address = address;
    }

    public Creditor(String name, CreditorAccount account, CreditorAddress address) {
        this.name = name;
        this.account = account;
        this.address = address;
    }

}
