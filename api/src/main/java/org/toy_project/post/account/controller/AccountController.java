package org.toy_project.post.account.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.toy_project.post.account.dto.AccountResponse;
import org.toy_project.post.account.service.AccountService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{accountId}")
    public AccountResponse getAccount(@PathVariable Long accountId) {
        return accountService.getAccount(accountId);
    }
}
