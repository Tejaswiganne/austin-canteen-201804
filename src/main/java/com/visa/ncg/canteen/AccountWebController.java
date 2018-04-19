package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

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

    AccountResponse accountResponse = AccountResponse.fromAccount(account);
    model.addAttribute("account", accountResponse);
    return "account-view";
  }

  @GetMapping("/account")
  public String allAccounts(Model model) {
    List<Account> accounts = accountRepository.findAll();

    List<AccountResponse> responses = accounts.stream()
                                              .map(AccountResponse::fromAccount)
                                              .collect(Collectors.toList());

    model.addAttribute("accounts", responses);
    return "all-accounts";
  }

}
