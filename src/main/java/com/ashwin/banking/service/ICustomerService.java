package com.ashwin.banking.service;

import com.ashwin.banking.dto.CustomerCreateRequest;
import com.ashwin.banking.dto.CustomerCreateResponse;

public interface ICustomerService {

    CustomerCreateResponse createCustomer(CustomerCreateRequest customerCreateRequest);
}
