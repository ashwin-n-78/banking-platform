package com.ashwin.banking.controller;

import com.ashwin.banking.dto.CustomerCreateRequest;
import com.ashwin.banking.dto.CustomerCreateResponse;
import com.ashwin.banking.service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerCreateResponse> createCustomer(
            @Valid @RequestBody CustomerCreateRequest customerCreateRequest) {

        CustomerCreateResponse customerCreateResponse =
                customerService.createCustomer(customerCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerCreateResponse);
    }
}
