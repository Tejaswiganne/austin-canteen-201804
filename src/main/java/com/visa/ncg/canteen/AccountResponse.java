package com.visa.ncg.canteen;

public class AccountResponse {

  private long id;
  private int balance;
  private String name;

  public static AccountResponse fromAccount(Account account) {
    AccountResponse accountResponse = new AccountResponse();
    accountResponse.setId(account.getId());
    accountResponse.setBalance(account.balance());
    accountResponse.setName(account.name());
    return accountResponse;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
