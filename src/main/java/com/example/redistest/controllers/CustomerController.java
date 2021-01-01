package com.example.redistest.controllers;

import com.example.redistest.models.Customer;
import com.example.redistest.repos.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerDao;

    @GetMapping("/{id}/get")
    @ResponseBody
    public Optional<Customer> getCustomer(@PathVariable long id) {
        return customerDao.findById(id);
    }

}
