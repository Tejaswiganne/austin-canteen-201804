package com.visa.ncg.canteen.rest;

import com.visa.ncg.canteen.domain.Account;
import com.visa.ncg.canteen.domain.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountApiController {

  private final AccountRepository accountRepository;

  @Autowired
  public AccountApiController(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @GetMapping("/api/accounts/{accountId}")
  public AccountResponse accountInfo(@PathVariable("accountId") String idString) {
    long id = Long.parseLong(idString);
    Account account = accountRepository.findOne(id);

    AccountResponse accountResponse = new AccountResponse();
    accountResponse.setId(account.getId());
    accountResponse.setBalance(account.balance());
    return accountResponse;
  }

}
