package org.toy_project.post.account.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.toy_project.post.account.adapter.out.persistence.Account;
import org.toy_project.post.account.adapter.out.persistence.AccountImage;
import org.toy_project.post.account.application.port.in.GetAccountUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final GetAccountUseCase getAccountUseCase;


    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccount(@PathVariable Long accountId) {
        Account account = getAccountUseCase.getAccount(accountId);
        account.setAccountImage(
                AccountImage.builder().id(account.getAccountImage().getId()).type(account.getAccountImage().getType())
                        .imageUrl(account.getAccountImage().getImageUrl()).build());

        return ResponseEntity.ok(account);
    }
}
