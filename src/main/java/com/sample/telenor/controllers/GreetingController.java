package com.sample.telenor.controllers;

import com.sample.telenor.services.AccountService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Api("Greeting API")
@RestController
@Validated
public class GreetingController {

    @Autowired
    private AccountService accountService;

    private static final String PERSONAL_ACCOUNT = "personal";
    private static final String BUSINESS_ACCOUNT = "business";
    public static final String TYPE_BIG = "big";
    private static final String TYPE_SMALL = "small";

    private static final String ACCOUNT_REGEX = "^" + PERSONAL_ACCOUNT + "|" + BUSINESS_ACCOUNT + "$";
    private static final String TYPE_REGEX = "^" + TYPE_BIG + "|" + TYPE_SMALL + "$";

    @GetMapping("/greeting")
    @ResponseBody
    public String greeting(
            @RequestParam(value = "account") @Pattern(regexp = ACCOUNT_REGEX) String account,
            @RequestParam(value = "type", required = false) @Pattern(regexp = TYPE_REGEX) String type,
            @RequestParam(value = "id", required = false) @Min(0) Integer id) {
        if (PERSONAL_ACCOUNT.equals(account)) {
            return accountService.greetingPersonalAccount(id);
        } else {
            return accountService.greetingBusinessAccount(type);
        }
    }
}
