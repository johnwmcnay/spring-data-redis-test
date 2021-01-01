package com.example.redistest.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;


@Getter @Setter
@RedisHash("account")
public class Account {

    @Indexed
    private String number;

    private int balance;

    public Account(String number, int balance) {
        this.number = number;
        this.balance = balance;
    }
}
