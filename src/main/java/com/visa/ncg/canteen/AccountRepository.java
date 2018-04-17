package com.visa.ncg.canteen;

import java.util.Collections;
import java.util.List;

public class AccountRepository {
  private final List<Account> myAccounts;

  public AccountRepository() {
    myAccounts = Collections.emptyList();
  }

  public AccountRepository(List<Account> accounts) {
    myAccounts = accounts;
  }

  public List<Account> findAll() {
    return myAccounts;
  }

}
