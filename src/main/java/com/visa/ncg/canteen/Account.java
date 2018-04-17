package com.visa.ncg.canteen;

public class Account {

  private int balance;

  public int balance() {
    return balance;
  }

  public void deposit(int amount) {
    validateAmount(amount);
    balance += amount;
  }

  public void withdraw(int amount) {
    validateAmount(amount);
    validateSufficientBalance(amount);
    balance = balance - amount;
  }

  private void validateSufficientBalance(int amount) {
    if (balance < amount) {
      throw new InsufficientBalanceException(
          "Can't withdraw " + amount
              + " as balance is currently " + balance);
    }
  }

  private void validateAmount(int amount) {
    if (amount <= 0) {
      throw new InvalidAmountException(
          "Amount of " + amount
              + " is not valid, must be greater than zero.");
    }
  }
}
