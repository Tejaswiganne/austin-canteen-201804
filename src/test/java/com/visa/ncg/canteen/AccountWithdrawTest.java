package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountWithdrawTest {
  @Test
  public void withdraw3DollarsFromAccountHaving7DollarsResultsIn4DollarBalance() throws Exception {
    Account account = new Account();
    account.deposit(7);

    account.withdraw(3);

    assertThat(account.balance())
        .isEqualTo(4);

  }

  @Test
  public void withdraw5Then3ResultsIn12DollarBalance() throws Exception {
    Account account = new Account();
    account.deposit(20);

    account.withdraw(5);
    account.withdraw(3);

    assertThat(account.balance())
        .isEqualTo(12);
  }

  @Test
  public void negativeWithdrawalThrowsInvalidAmountException() throws Exception {
    Account account = new Account();

    assertThatThrownBy(() -> {
      account.withdraw(-1);
    })
    .isInstanceOf(InvalidAmountException.class);
  }

  @Test
  public void overdrawingAccountThrowsInsufficientBalanceException() throws Exception {

    Account account = new Account();

    assertThatThrownBy(() ->
                           account.withdraw(5)
    ).isInstanceOf(InsufficientBalanceException.class);
  }
}