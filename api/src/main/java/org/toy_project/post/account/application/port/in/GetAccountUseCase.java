package org.toy_project.post.account.application.port.in;

import org.springframework.stereotype.Component;
import org.toy_project.post.account.adapter.out.persistence.Account;

@Component
public interface GetAccountUseCase {

    Account getAccount(Long id);
}
