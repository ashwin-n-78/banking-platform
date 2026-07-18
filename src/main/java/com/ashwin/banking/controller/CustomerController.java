package com.ashwin.banking.controller;

import com.ashwin.banking.dto.*;
import com.ashwin.banking.service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> fetchCustomer(@PathVariable("customerId") String customerId) {

        CustomerResponse customerResponse =
                customerService.fetchCustomer(customerId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerResponse);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerUpdateResponse> updateCustomer(@PathVariable("customerId") String customerId, @Valid @RequestBody CustomerUpdateRequest customerUpdateRequest) {

        CustomerUpdateResponse customerUpdateResponse =
                customerService.updateCustomer(customerId,customerUpdateRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerUpdateResponse);
    }
}
