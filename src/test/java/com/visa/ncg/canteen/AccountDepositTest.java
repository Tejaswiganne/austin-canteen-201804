package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountDepositTest {

  @Test
  public void deposit10DollarsResultsInBalanceOf10Dollars() throws Exception {
    Account account = new Account();

    account.deposit(10);

    assertThat(
      account.balance()
    ).isEqualTo(10);
  }

  // need test to check initial balance of new account

  @Test
  public void deposit5DollarsAndThen10DollarsResultsIn15DollarBalance() throws Exception {
    Account account = new Account();

    account.deposit(5);
    account.deposit(10);

    assertThat(account.balance())
        .isEqualTo(15);
  }

}
