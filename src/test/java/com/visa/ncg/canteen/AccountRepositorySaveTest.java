package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountRepositorySaveTest {

  @Test
  public void saveAccountWithoutIdReturnsAccountWithId() throws Exception {
    AccountRepository accountRepository = new AccountRepository();
    Account account = new Account();

    Account savedAccount = accountRepository.save(account);

    assertThat(savedAccount.getId())
        .describedAs("Account should get an ID assigned upon saving, but is still null.")
        .isNotNull();

    assertThat(accountRepository.findOne(savedAccount.getId()))
        .describedAs("Account saved must be found by the ID it was assigned: " + savedAccount.getId())
        .isNotNull();
  }
}
