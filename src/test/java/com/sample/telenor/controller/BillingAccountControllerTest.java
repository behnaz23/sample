package com.sample.telenor.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.telenor.controllers.GreetingController;
import com.sample.telenor.services.AccountService;
import com.sample.telenor.services.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GreetingController.class)
public class BillingAccountControllerTest {

  @Autowired
  private MockMvc client;
  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private AccountServiceImpl accountService;

  @Test
  public void greetingBusinessAccount_OKResponse() throws Exception {

    when(accountService.greetingBusinessAccount(123)
      .thenReturn(TestUtil.createBillingAccountById(stringId));

    // THEN
    client.perform(get(BASE_PATH + id)
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.id", is(stringId)));
  }
}
