package com.bilyoner.balance.service;

import com.bilyoner.balance.entities.UserBalance;
import com.bilyoner.balance.entities.UserBalanceHistory;
import com.bilyoner.balance.repo.UserBalanceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class UserBalanceService {

    @Autowired
    private UserBalanceRepository userBalanceRepository;

    @Autowired
    private UserBalanceHistoryService userBalanceHistoryService;


    public UserBalance create(UserBalance userBalance) {
        return userBalanceRepository.save(userBalance);
    }

    public UserBalance delete(Long id) {
        UserBalance userBalance = findById(id);
        if (Objects.nonNull(userBalance)) {
            userBalanceRepository.delete(userBalance);
        }
        return userBalance;
    }

    public List<UserBalance> findAll() {
        return userBalanceRepository.findAll();
    }

    public List<UserBalance> findAll(Pageable pageable) {
        return null;
    }

    public UserBalance findById(Long id) {
        return userBalanceRepository.findById(id);
    }

    public UserBalance findByUserId(int id) {
        return userBalanceRepository.findByUserId(id);
    }

    public synchronized UserBalance update(UserBalance userBalance) {
        UserBalance event_check = findById(userBalance.getId());
        if (Objects.nonNull(event_check)) {
            userBalanceRepository.save(userBalance);
        }
        return userBalance;
    }

    public UserBalance checkBalance(long userId) {
        return userBalanceRepository.findById(userId);
    }

    public synchronized void buyCoupon(long userId, int amount) throws Exception {
        UserBalance userBalance = checkBalance(userId);

        if (userBalance.getBalance() > amount) {

            // UserBalanceHistory create
            UserBalanceHistory ubh = new UserBalanceHistory();
            ubh.setUserId(userId);
            ubh.setBalanceMovement(-amount);
            ubh.setBalance(userBalance.getBalance() - amount);
            ubh.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            userBalanceHistoryService.create(ubh);

            // UserBalance update
            userBalance.setBalance(userBalance.getBalance() - amount);
            update(userBalance);
        } else {
            throw new Exception("User's balance is not enough !");
        }
    }

    public synchronized void cancelCoupon(long userId, int amount) throws Exception {
        UserBalance userBalance = checkBalance(userId);

        // UserBalanceHistory create
        UserBalanceHistory ubh = new UserBalanceHistory();
        ubh.setUserId(userId);
        ubh.setBalanceMovement(amount);
        ubh.setBalance(userBalance.getBalance() + amount);
        ubh.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        userBalanceHistoryService.create(ubh);

        // UserBalance update
        userBalance.setBalance(userBalance.getBalance() + amount);
        update(userBalance);
    }
}
