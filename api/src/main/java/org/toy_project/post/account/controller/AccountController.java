package org.toy_project.post.account.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.toy_project.post.account.dto.AccountResponse;
import org.toy_project.post.account.model.Account;
import org.toy_project.post.account.service.AccountService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable Long accountId) {
        Account account = accountService.getAccount(accountId);
        AccountResponse.AccountImage accountImage = AccountResponse.AccountImage.builder()
                .id(account.getAccountImage().getId())
                .type(account.getAccountImage().getType())
                .imageUrl(account.getAccountImage().getImageUrl())
                .build();

        return ResponseEntity.ok(AccountResponse.builder()
                .id(account.getId())
                .accountName(account.getAccountName())
                .accountImage(accountImage)
                .hashTag(account.getHashTag())
                .youtubeUrl(account.getYoutubeUrl())
                .postCount(account.getPostCount())
                .followCount(account.getFollowCount())
                .followerCount(account.getFollowerCount())
                .build());
    }
}
