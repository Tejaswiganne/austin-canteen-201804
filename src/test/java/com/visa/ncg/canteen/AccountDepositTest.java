package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountDepositTest {

  @Test
  public void deposit10DollarsResultsInBalanceOf10Dollars() throws Exception {
    Account account = new Account();

    account.deposit(10);

    assertThat(
      account.balance()
    ).isEqualTo(10);
  }

  @Test
  public void deposit5DollarsAndThen10DollarsResultsIn15DollarBalance() throws Exception {
    Account account = new Account();

    account.deposit(5);
    account.deposit(10);

    assertThat(account.balance())
        .isEqualTo(15);
  }

  @Test
  public void negativeDepositThrowsInvalidAmountException() throws Exception {
    Account account = new Account();

    assertThatThrownBy(() -> {
      account.deposit(-10);
    }).isInstanceOf(InvalidAmountException.class);
  }

  @Test
  public void zeroDepositThrowsInvalidAmountException() throws Exception {
    Account account = new Account();

    assertThatThrownBy(() -> {
      account.deposit(0);
    }).isInstanceOf(InvalidAmountException.class);
  }

}
