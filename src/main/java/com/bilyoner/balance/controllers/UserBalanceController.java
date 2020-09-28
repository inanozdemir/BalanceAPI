package com.bilyoner.balance.controllers;

import com.bilyoner.balance.service.UserBalanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping({"/api/userbalance"})
public class UserBalanceController {

    @Autowired
    private UserBalanceService userBalanceService;


    @RequestMapping(value = "/buycoupon", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity buyCoupon(@RequestParam("userId") long userId, @RequestParam("amount") int amount) {
        try {
            userBalanceService.buyCoupon(userId, amount);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/getbalance", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserBalance(@RequestParam int userId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userBalanceService.findByUserId(userId).getBalance());
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/cancelcoupon", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity cancelCoupon(@RequestParam("userId") long userId, @RequestParam("amount") int amount) {
        try {
            userBalanceService.cancelCoupon(userId, amount);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
