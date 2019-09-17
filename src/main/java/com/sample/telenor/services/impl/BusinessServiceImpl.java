package com.sample.telenor.services.impl;

import com.sample.telenor.controllers.GreetingController;
import com.sample.telenor.services.BusinessService;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {
    @Override
    public String handle(String type) {
        if (GreetingController.TYPE_BIG.equals(type)) {
            return "Welcome, business user!";
        } else {
            throw new UnsupportedOperationException("The path is not yet implemented");
        }
    }
}
