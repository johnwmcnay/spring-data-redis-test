package com.example.redistest;

import com.example.redistest.models.Account;
import com.example.redistest.models.Customer;
import com.example.redistest.repos.CustomerRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataRedisTest
public class RedisCustomerRepositoryTest {

    @Autowired
    CustomerRepository repository;

    @Before
    public void setup() {
        Customer customer = new Customer("80010121098", "John Smith");
        customer.addAccount(new Account("1234567890", 2000));
        customer.addAccount(new Account("1234567891", 4000));
        customer.addAccount(new Account("1234567892", 6000));
        repository.save(customer);
    }

    @After
    public void after() {
        repository.delete(repository.findByExternalId("80010121098"));
        Assert.assertNull(repository.findByExternalId("80010121098"));
    }

    @Test
    public void testAdd() {
        Assert.assertNotNull(repository.findByExternalId("80010121098"));
    }

    @Test
    public void testFindByExternal() {
        Customer customer = repository.findByExternalId("80010121098");
        Assert.assertNotNull(customer);
        Assert.assertEquals("80010121098", customer.getExternalId());
    }

}