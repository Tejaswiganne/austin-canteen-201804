package com.visa.ncg.canteen.web;

import com.visa.ncg.canteen.domain.Account;

public class AccountView {

  private long id;
  private int balance;
  private String name;
  private int gbpBalance;

  public static AccountView fromAccount(Account account) {
    AccountView accountResponse = new AccountView();
    accountResponse.setId(account.getId());
    accountResponse.setBalance(account.balance());
    accountResponse.setName(account.name());
    return accountResponse;
  }

  public int getGbpBalance() {
    return gbpBalance;
  }

  public void setGbpBalance(int gbpBalance) {
    this.gbpBalance = gbpBalance;
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
