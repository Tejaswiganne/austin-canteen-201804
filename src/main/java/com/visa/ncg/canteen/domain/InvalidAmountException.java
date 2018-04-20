package com.visa.ncg.canteen.domain;

public class InvalidAmountException extends RuntimeException {
  public InvalidAmountException() {
    super();
  }

  public InvalidAmountException(String message) {
    super(message);
  }
}
