package com.visa.ncg.canteen.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.Matchers.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountViewWebIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getReturnsViewWithAccountResponseInModel() throws Exception {
    mockMvc.perform(get("/account/1"))
           .andExpect(status().isOk())
           .andExpect(model().attributeExists("account"))
           .andExpect(model().attribute("account", instanceOf(AccountView.class)))
           .andExpect(view().name("account-view"));
  }

  @Test
  public void getOfNonExistentAccountReturns404() throws Exception {
    mockMvc.perform(get("/account/9999"))
           .andExpect(status().isNotFound());
  }

  @Test
  public void allAccountsShouldReturnListOfAccountResponse() throws Exception {
    mockMvc.perform(get("/account"))
           .andExpect(status().isOk())
           .andExpect(model().attributeExists("accounts"))
           .andExpect(model().attribute("accounts", instanceOf(ArrayList.class)))
           .andExpect(view().name("all-accounts"));
  }

}