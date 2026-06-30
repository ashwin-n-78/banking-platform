package com.ashwin.banking.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerIdGeneratorImpl implements ICustomerIdGenerator {

    private final ICustomerSequenceRepository customerSequenceRepository;

    public CustomerIdGeneratorImpl(ICustomerSequenceRepository customerSequenceRepository){
        this.customerSequenceRepository = customerSequenceRepository;
    }

    @Override
    public String generateCustomerId() {

        Long sequence = customerSequenceRepository.getNextCustomerSequence();

        return "CUST"+sequence;
    }
}
