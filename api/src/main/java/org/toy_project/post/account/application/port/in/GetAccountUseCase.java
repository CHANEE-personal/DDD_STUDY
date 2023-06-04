package org.toy_project.post.account.application.port.in;

import org.toy_project.post.account.adapter.out.persistence.Account;

public interface GetAccountUseCase {

    Account getAccount(Long id);
}
