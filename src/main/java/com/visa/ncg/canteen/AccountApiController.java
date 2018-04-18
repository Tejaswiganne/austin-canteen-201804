package com.visa.ncg.canteen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountApiController {

    @GetMapping("/api/accounts/{accountId}")
    public AccountResponse accountInfo(@PathVariable("accountId") String idString) {
      long id = Long.parseLong(idString);
      Account account = new Account();
      account.setId(id);
      account.deposit(10);

      AccountResponse accountResponse = new AccountResponse();
      accountResponse.setId(account.getId());
      accountResponse.setBalance(account.balance());
      return accountResponse;
    }

}
