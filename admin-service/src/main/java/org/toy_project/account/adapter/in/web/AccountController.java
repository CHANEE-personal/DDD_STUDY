package org.toy_project.account.adapter.in.web;

import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.toy_project.account.adapter.out.persistence.Account;
import org.toy_project.account.application.port.in.GetAccountUseCase;
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
}
