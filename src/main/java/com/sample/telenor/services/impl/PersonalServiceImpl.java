package com.sample.telenor.services.impl;

import com.sample.telenor.services.PersonalService;
import org.springframework.stereotype.Service;

@Service
public class PersonalServiceImpl implements PersonalService {
    @Override
    public String handle(Integer id) {
        return String.format("Hi, userId %d", id);
    }
}
