package org.toy_project.account.adapter.in.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.toy_project.account.adapter.out.persistence.Account;
import org.toy_project.account.application.port.in.GetAccountUseCase;
import org.toy_project.follow.adapter.out.persistence.Follow;
import org.toy_project.follow.adapter.out.persistence.Follower;
import org.toy_project.response.ApiResponse;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final GetAccountUseCase getAccountUseCase;


    @GetMapping("/{accountId}")
    public ApiResponse<Map<String, Object>> getAccount(@PathVariable Long accountId) {
        Map<String, Object> resultMap = new HashMap<>();
        Account account = getAccountUseCase.getAccount(accountId);

        resultMap.put("account", account);
        return ApiResponse.ok(resultMap);
    }


    @GetMapping("/{accountId}/follow")
    public ApiResponse<List<Follow>> getFollows(@PathVariable Long accountId) {
        List<Follow> followList = getAccountUseCase.getFollowList(accountId);
        return ApiResponse.ok(followList);
    }


    @GetMapping("/{accountId}/follower")
    public ApiResponse<List<Follower>> getFollowers(@PathVariable Long accountId) {
        List<Follower> followerList = getAccountUseCase.getFollowerList(accountId);
        return ApiResponse.ok(followerList);
    }
}
