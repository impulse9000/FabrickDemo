package com.example.fabrick.models;

// more info: https://docs.fabrick.com/platform/apis/gbs-banking-payments-moneyTransfers-v4.0

public class MoneyTransferRequest {
  private Creditor creditor;
  private String executionDate;
  private String uri;
  private String description;
  private String amount;
  private String currency;
  private TaxRelief taxRelief;

  public MoneyTransferRequest(Creditor creditor, String executionDate, String uri, String description, String amount, String currency, TaxRelief taxRelief) {
    this.creditor = creditor;
    this.executionDate = executionDate;
    this.uri = uri;
    this.description = description;
    this.amount = amount;
    this.currency = currency;
    this.taxRelief = taxRelief;
  }

  public Creditor getCreditor() {
    return creditor;
  }

  public void setCreditor(Creditor creditor) {
    this.creditor = creditor;
  }

  public String getExecutionDate() {
    return executionDate;
  }

  public void setExecutionDate(String executionDate) {
    this.executionDate = executionDate;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public TaxRelief getTaxRelief() {
    return taxRelief;
  }

  public void setTaxRelief(TaxRelief taxRelief) {
    this.taxRelief = taxRelief;
  }
}
