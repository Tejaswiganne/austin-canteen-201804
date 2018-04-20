package com.visa.ncg.canteen.domain;

public class InsufficientBalanceException extends RuntimeException {
  public InsufficientBalanceException() {
    super();
  }

  public InsufficientBalanceException(String message) {
    super(message);
  }
}
