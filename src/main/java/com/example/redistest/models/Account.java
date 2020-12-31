package com.example.redistest.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.index.Indexed;

@Getter @Setter
public class Account {

    @Indexed
    private Long id;
    private String number;
    private int balance;

    public Account(Long id, String number, int balance) {
        this.id = id;
        this.number = number;
        this.balance = balance;
    }
}
