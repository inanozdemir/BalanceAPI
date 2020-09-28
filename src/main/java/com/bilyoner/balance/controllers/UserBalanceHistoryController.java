package com.bilyoner.balance.controllers;

import com.bilyoner.balance.service.UserBalanceHistoryService;
import com.bilyoner.balance.service.UserBalanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping({"/api/ubh"})
public class UserBalanceHistoryController {

    @Autowired
    private UserBalanceService userBalanceService;

    @Autowired
    private UserBalanceHistoryService userBalanceHistoryService;

    /*@RequestMapping(value = "/add", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addUserBalanceHistory(@RequestParam int userId, @RequestParam int amount) {
        try {
            UserBalance userBalance = userBalanceService.findByUserId(userId);

            UserBalanceHistory ubh = new UserBalanceHistory();
            ubh.setUserId(userId);
            ubh.setBalanceMovement(amount);
            ubh.setBalance(userBalance.getBalance() + amount);

            userBalanceHistoryService.create(ubh);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(HttpStatus.OK);
    }*/

}
