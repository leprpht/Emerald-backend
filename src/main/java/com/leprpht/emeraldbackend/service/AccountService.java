package com.leprpht.emeraldbackend.service;

import com.leprpht.emeraldbackend.model.Account;
import com.leprpht.emeraldbackend.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public CompletableFuture<Double> getBalance() {
        return CompletableFuture.completedFuture(accountRepository.findById(1L)
                .orElseThrow()
                .getBalance());
    }

    @Transactional
    public void changeBalance(Double value) {
        Account account = accountRepository.findById(1L).orElseThrow();
        account.setBalance(account.getBalance() + value);
        accountRepository.save(account);
    }
}
