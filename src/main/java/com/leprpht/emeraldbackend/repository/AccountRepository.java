package com.leprpht.emeraldbackend.repository;

import com.leprpht.emeraldbackend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> { }
