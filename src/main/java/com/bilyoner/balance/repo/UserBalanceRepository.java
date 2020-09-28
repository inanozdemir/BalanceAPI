package com.bilyoner.balance.repo;

import com.bilyoner.balance.entities.UserBalance;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface UserBalanceRepository extends Repository<UserBalance, Long> {

    void delete(UserBalance userBalance);

    List<UserBalance> findAll();

    UserBalance findById(Long id);

    UserBalance findByUserId(int id);

    UserBalance save(UserBalance userBalance);
}
