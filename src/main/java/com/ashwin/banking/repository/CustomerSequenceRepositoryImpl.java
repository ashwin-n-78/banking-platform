package com.ashwin.banking.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class CustomerSequenceRepositoryImpl implements ICustomerSequenceRepository {

    private EntityManager entityManager;

    public CustomerSequenceRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Long getNextCustomerSequence() {

       return ((Number) entityManager.createNativeQuery("select nextval('customer_sequence')")
                .getSingleResult()).longValue();

    }
}
