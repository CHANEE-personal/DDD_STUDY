package org.toy_project.post.account.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.toy_project.post.account.model.Account;
import org.toy_project.post.account.repository.AccountRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional(readOnly = true)
    public Account getAccount(Long id) {
        return accountRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
