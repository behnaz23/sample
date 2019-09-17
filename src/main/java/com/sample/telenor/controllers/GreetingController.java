package com.sample.telenor.controllers;

import com.sample.telenor.services.BusinessService;
import com.sample.telenor.services.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@RestController
@Validated
public class GreetingController {
    private static final String PERSONAL_ACCOUNT = "personal";
    private static final String BUSINESS_ACCOUNT = "business";
    private static final String CONSTRAINT_ACCOUNT_REGEX = "^" + PERSONAL_ACCOUNT + "|" + BUSINESS_ACCOUNT + "$";

    public static final String TYPE_BIG = "big";
    private static final String TYPE_SMALL = "small";
    private static final String CONSTRAINT_TYPE_REGEX = "^" + TYPE_BIG + "|" + TYPE_SMALL + "$";

    @Autowired
    private PersonalService personalService;
    @Autowired
    private BusinessService businessService;

    @GetMapping("/greeting")
    @ResponseBody
    public String greeting(
            @RequestParam(value = "account") @Pattern(regexp = CONSTRAINT_ACCOUNT_REGEX) String account,
            @RequestParam(value = "type", required = false) @Pattern(regexp = CONSTRAINT_TYPE_REGEX) String type,
            @RequestParam(value = "id", required = false) @Min(0) Integer id) {
        String response;
        if (PERSONAL_ACCOUNT.equals(account)) {
            response = personalService.handle(id);
        } else {
            response = businessService.handle(type);
        }
        return response;
    }
}
