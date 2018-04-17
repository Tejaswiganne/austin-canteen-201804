package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountRepositoryFindTest {

  @Test
  public void findAllForEmptyRepositoryReturnsEmptyList() throws Exception {
    AccountRepository accountRepository = new AccountRepository();

    assertThat(accountRepository.findAll())
        .isEmpty();
  }

}