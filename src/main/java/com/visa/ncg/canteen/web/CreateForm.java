package com.visa.ncg.canteen.web;

public class CreateForm {
  private String accountName;
  private int initialDeposit;
  private int overdraftLimit;

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public int getInitialDeposit() {
    return initialDeposit;
  }

  public void setInitialDeposit(int initialDeposit) {
    this.initialDeposit = initialDeposit;
  }

  public int getOverdraftLimit() {
    return overdraftLimit;
  }

  public void setOverdraftLimit(int overdraftLimit) {
    this.overdraftLimit = overdraftLimit;
  }
}
