package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AccountWebController {

  private AccountRepository accountRepository;

  @Autowired
  public AccountWebController(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @GetMapping("/account/{id}")
  public String accountView(@PathVariable("id") String id, Model model) {
    Long accountId = Long.parseLong(id);
    Account account = accountRepository.findOne(accountId);
    if (account == null) {
      throw new NoSuchAccountException();
    }

    AccountResponse accountResponse = new AccountResponse();
    accountResponse.setId(account.getId());
    accountResponse.setName(account.name());
    accountResponse.setBalance(account.balance());
    model.addAttribute("account", accountResponse);
    return "account-view";
  }

}
