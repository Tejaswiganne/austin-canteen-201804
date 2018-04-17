package com.visa.ncg.canteen;

public class Account {

  private int balance;

  public int balance() {
    return balance;
  }

  public void deposit(int amount) {
    if (amount <= 0) {
      throw new InvalidAmountException("Amount of " + amount + " is not valid, must be greater than zero.");
    }
    balance += amount;
  }

  public void withdraw(int amount) {
    if (amount <= 0 ) {
      throw new InvalidAmountException("Amount of " + amount + " is not valid, must be greater than zero.");
    }
    if (balance < amount) {
      throw new InsufficientBalanceException("Can't withdraw " + amount + " as balance is currently " + balance);
    }

    balance = balance - amount;
  }
}
