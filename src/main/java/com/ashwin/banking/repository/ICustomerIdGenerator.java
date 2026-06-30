package com.ashwin.banking.repository;

import org.springframework.stereotype.Repository;

public interface ICustomerIdGenerator {

    String generateCustomerId();
}
