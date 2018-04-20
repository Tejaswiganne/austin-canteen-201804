package com.visa.ncg.canteen.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class AccountRepository {
  private final Map<Long, Account> accountsMap = new HashMap<>();

  private final AtomicLong idGenerator = new AtomicLong(1L);

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
      account.setId(idGenerator.getAndIncrement());
    }
    accountsMap.put(account.getId(), account);
    return account;
  }
}
