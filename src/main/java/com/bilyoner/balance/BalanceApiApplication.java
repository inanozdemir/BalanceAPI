package com.bilyoner.balance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.bilyoner.balance.entities"})
@EnableJpaRepositories(basePackages = {"com.bilyoner.balance.repo"})
@ComponentScan("com.bilyoner.balance")
public class BalanceApiApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BalanceApiApplication.class, args);
    }

}