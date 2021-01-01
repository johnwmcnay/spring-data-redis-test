package com.example.redistest.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RedisHash("customer")
public class Customer {

    @Id
    private String id;

    @Indexed
    private String externalId;

    private String name;
    private List<Account> accounts = new ArrayList<>();

    public Customer(String externalId, String name) {
        this.externalId = externalId;
        this.name = name;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

}