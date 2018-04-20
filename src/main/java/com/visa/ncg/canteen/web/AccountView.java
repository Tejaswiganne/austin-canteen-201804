package com.visa.ncg.canteen.web;

import com.visa.ncg.canteen.domain.Account;

public class AccountView {

  private long id;
  private int balance;
  private String name;
  private int gbpBalance;
  private boolean isOverdrawn;

  public static AccountView fromAccount(Account account) {
    AccountView accountView = new AccountView();
    accountView.setId(account.getId());
    accountView.setBalance(account.balance());
    accountView.setName(account.name());
    accountView.setOverdrawn(account.isOverdrawn());
    return accountView;
  }

  public boolean isOverdrawn() {
    return isOverdrawn;
  }

  public void setOverdrawn(boolean overdrawn) {
    isOverdrawn = overdrawn;
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
