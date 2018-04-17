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
    if (amount < 0 ) {
      throw new InvalidAmountException("Amount of " + amount + " is not valid, must be greater than zero.");
    }
    balance = balance - amount;
  }
}
