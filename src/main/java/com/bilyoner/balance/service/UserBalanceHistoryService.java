package com.bilyoner.balance.service;

import com.bilyoner.balance.entities.UserBalanceHistory;
import com.bilyoner.balance.repo.UserBalanceHistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class UserBalanceHistoryService implements BaseService<UserBalanceHistory> {

    @Autowired
    private UserBalanceHistoryRepository repository;

    @Override
    public UserBalanceHistory create(UserBalanceHistory userBalanceHistory) {
        log.info("User : " + userBalanceHistory.getUserId() + ", balance movement : " + userBalanceHistory.getBalanceMovement());
        return repository.save(userBalanceHistory);
    }

    @Override
    public UserBalanceHistory delete(Long id) {
        UserBalanceHistory userBalance = findById(id);
        if (Objects.nonNull(userBalance)) {
            repository.delete(userBalance);
        }
        return userBalance;
    }

    @Override
    public List<UserBalanceHistory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<UserBalanceHistory> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public UserBalanceHistory findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public UserBalanceHistory update(UserBalanceHistory userBalanceHistory) {
        UserBalanceHistory userBalanceHistory_check = findById(userBalanceHistory.getId());
        if (Objects.nonNull(userBalanceHistory_check)) {
            repository.save(userBalanceHistory);
        }
        return userBalanceHistory;
    }

}
