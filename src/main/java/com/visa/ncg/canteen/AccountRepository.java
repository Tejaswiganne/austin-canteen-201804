package com.visa.ncg.canteen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepository {
  private final Map<Long, Account> accountsMap = new HashMap<>();



  public AccountRepository() {
  }

  public AccountRepository(List<Account> accounts) {
    for (Account account : accounts) {
      accountsMap.put(account.getId(), account);
    }
  }

  public List<Account> findAll() {
    return new ArrayList<>(accountsMap.values());
  }

  public Account findOne(Long id) {
    return accountsMap.get(id);
  }

  public Account save(Account account) {
    if (account.getId() == null) {
      account.setId(1L);
    }
    accountsMap.put(account.getId(), account);
    return account;
  }
}
