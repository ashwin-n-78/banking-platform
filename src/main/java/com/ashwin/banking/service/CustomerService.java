package com.ashwin.banking.service;

import com.ashwin.banking.CustomerStatus;
import com.ashwin.banking.assembler.CustomerAssembler;
import com.ashwin.banking.dto.CustomerCreateRequest;
import com.ashwin.banking.dto.CustomerCreateResponse;
import com.ashwin.banking.entity.Customer;
import com.ashwin.banking.repository.ICustomerIdGenerator;
import com.ashwin.banking.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService{

    private final CustomerAssembler customerAssembler;
    private final ICustomerRepository customerRepository;
    private final ICustomerIdGenerator customerIdGenerator;

    public CustomerService(CustomerAssembler customerAssembler,
                           ICustomerRepository customerRepository,
                           ICustomerIdGenerator customerIdGenerator){
        this.customerAssembler= customerAssembler;
        this.customerRepository = customerRepository;
        this.customerIdGenerator = customerIdGenerator;
    }

    @Override
    public CustomerCreateResponse createCustomer(CustomerCreateRequest customerCreateRequest) {

        Customer customer = customerAssembler.toCustomerObject(customerCreateRequest);
        customer.setStatus(CustomerStatus.PENDING_KYC);

        String customerId = customerIdGenerator.generateCustomerId();
        customer.setCustomerId(customerId);

        Customer savedCustomer = customerRepository.save(customer);
        CustomerCreateResponse customerCreateResponse = customerAssembler
                                                        .toCustomerCreateResponseObject(savedCustomer,"Customer created Successfully");


        return customerCreateResponse;
    }
}
