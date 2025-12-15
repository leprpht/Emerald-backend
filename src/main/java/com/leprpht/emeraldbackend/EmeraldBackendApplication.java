package com.leprpht.emeraldbackend;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.leprpht.emeraldbackend.model.Account;
import com.leprpht.emeraldbackend.model.Campaign;
import com.leprpht.emeraldbackend.repository.AccountRepository;
import com.leprpht.emeraldbackend.repository.CampaignRepository;

@SpringBootApplication
public class EmeraldBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmeraldBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(CampaignRepository campaignRepository, AccountRepository accountRepository) {
        return args -> {
            campaignRepository.save(Campaign.builder()
                    .campaignName("Example Campaign 1")
                    .keywords(List.of("used", "sell", "delivery"))
                    .bidAmount(1.5)
                    .campaignFund(100.0)
                    .status(true)
                    .town("Kraków")
                    .radius(10)
                    .build());

            campaignRepository.save(Campaign.builder()
                    .campaignName("Example Campaign 2")
                    .keywords(List.of("local", "available"))
                    .bidAmount(2.0)
                    .campaignFund(200.0)
                    .status(false)
                    .town("Wrocław")
                    .radius(20)
                    .build());
            
            accountRepository.save(Account.builder()
                    .balance(1000.0)
                    .build());
        };
    }
}