package com.ashwin.banking.repository;

import com.ashwin.banking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findByCustomerId(String customerId);

}
