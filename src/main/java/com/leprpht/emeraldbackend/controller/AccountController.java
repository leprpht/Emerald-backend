package com.leprpht.emeraldbackend.controller;

import com.leprpht.emeraldbackend.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/balance")
    public ResponseEntity<Double> getBalance() {
        Double balance = accountService.getBalance().join();
        return ResponseEntity.ok(balance);
    }

    @PutMapping("/balance")
    public ResponseEntity<Void> changeBalance(@RequestParam Double value) {
        accountService.changeBalance(value);
        return ResponseEntity.ok().build();
    }
}
