package com.bilyoner.balance.repo;

import com.bilyoner.balance.entities.UserBalanceHistory;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface UserBalanceHistoryRepository extends Repository<UserBalanceHistory, Long> {

    void delete(UserBalanceHistory userBalanceHistory);

    List<UserBalanceHistory> findAll();

    UserBalanceHistory findById(Long id);

    UserBalanceHistory save(UserBalanceHistory userBalanceHistory);
}
