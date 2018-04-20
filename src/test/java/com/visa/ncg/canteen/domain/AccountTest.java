package com.visa.ncg.canteen.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

  @Test
  public void newAccountHasZeroBalance() throws Exception {
    assertThat(new Account().balance())
        .isZero();
  }

}
