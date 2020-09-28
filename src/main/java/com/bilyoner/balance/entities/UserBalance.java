package com.bilyoner.balance.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_balance")
@Getter
@Setter
@EqualsAndHashCode
public class UserBalance {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Basic
    @Column(name = "user_id", nullable = false)
    private int userId;

    @Basic
    @Column(name = "balance", nullable = false)
    private int balance;

    @Basic
    @Column(name = "update_date")
    private Timestamp updateDate;

}
