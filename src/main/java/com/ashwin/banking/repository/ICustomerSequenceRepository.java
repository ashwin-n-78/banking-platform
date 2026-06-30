package com.ashwin.banking.repository;

import org.springframework.stereotype.Repository;

public interface ICustomerSequenceRepository {

    Long getNextCustomerSequence();
}
