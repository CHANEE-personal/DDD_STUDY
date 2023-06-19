package org.toy_project.account.application.port.out;

import org.springframework.stereotype.Component;
import org.toy_project.account.adapter.out.persistence.Account;
import reactor.core.publisher.Mono;

@Component
public interface LoadAccountPort {

    Mono<Account> loadAccount(Long id);
}
