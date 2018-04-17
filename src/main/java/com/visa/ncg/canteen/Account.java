package com.visa.ncg.canteen;

public class Account {

  private int balance;

  public int balance() {
    return balance;
  }

  public void deposit(int amount) {
    balance += amount;
  }

  public void withdraw(int amount) {
    balance = balance - amount;
  }
}
