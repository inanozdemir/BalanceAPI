package com.bilyoner.balance.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_balance_history")
@Getter
@Setter
@EqualsAndHashCode
public class UserBalanceHistory {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Basic
    @Column(name = "user_id", nullable = false)
    private long userId;

    @Basic
    @Column(name = "balance_movement", nullable = false)
    private double balanceMovement;

    @Basic
    @Column(name = "balance", nullable = false)
    private double balance;

    @Basic
    @Column(name = "create_date", nullable = false)
    private Timestamp createdDate;

}
