package com.account.api.controller;

import com.account.api.model.Account;
import com.account.api.model.CreateAccountRequest;
import com.account.api.model.DTO.AccountDTO;
import com.account.api.service.AccountService;
import com.account.api.util.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    private ConverterUtil converterUtil;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@Validated @RequestBody CreateAccountRequest request) {
        Account accountCreated = accountService.createAccount(request);
        AccountDTO accountConvertedToDTO = converterUtil.convertToDTO(accountCreated);
        return ResponseEntity.ok(accountConvertedToDTO);
        //return ResponseEntity.ok(accountService.createAccount(request));
    }
}
