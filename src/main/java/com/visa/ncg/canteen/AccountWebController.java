package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

  @GetMapping("/create-account")
  public String createAccountForm(Model model) {
    model.addAttribute("accountName", "default");
    return "create-account";
  }

  @PostMapping("/create-account")
  public String createAccount(@ModelAttribute("accountName") String name, Model model) {
    Account account = new Account();
    account.changeNameTo(name);
    account = accountRepository.save(account);
    return "redirect:/account/" + account.getId();
  }
}
