package com.sample.telenor.services.impl;

import com.sample.telenor.controllers.GreetingController;
import com.sample.telenor.services.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public String greetingBusinessAccount(String type) {
        if (GreetingController.TYPE_BIG.equals(type)) {
            return "Welcome, business user!";
        } else {
            throw new UnsupportedOperationException("The path is not yet implemented!");
        }
    }

    @Override
    public String greetingPersonalAccount(Integer id) {
        return String.format("Hi, userId %d", id);
    }
}
