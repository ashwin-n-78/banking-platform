package com.ashwin.banking.service;

import com.ashwin.banking.dto.*;

public interface ICustomerService {

    CustomerCreateResponse createCustomer(CustomerCreateRequest customerCreateRequest);

    CustomerResponse fetchCustomer(String customerId);

    CustomerUpdateResponse updateCustomer(String customerId,CustomerUpdateRequest customerUpdateRequest);
}
