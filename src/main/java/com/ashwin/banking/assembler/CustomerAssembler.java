package com.ashwin.banking.assembler;

import com.ashwin.banking.dto.CustomerCreateRequest;
import com.ashwin.banking.dto.CustomerCreateResponse;
import com.ashwin.banking.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerAssembler {

    public Customer toCustomerObject(CustomerCreateRequest customerCreateRequest){
        Customer customer = new Customer();
        customer.setFirstName(customerCreateRequest.getFirstName());
        customer.setLastName(customerCreateRequest.getLastName());
        customer.setEmail(customerCreateRequest.getEmail());
        customer.setMobileNumber(customerCreateRequest.getMobileNumber());
        customer.setDateOfBirth(customerCreateRequest.getDateOfBirth());
        customer.setAddress(customerCreateRequest.getAddress());
        customer.setPanNumber(customerCreateRequest.getPanNumber());
        customer.setAadhaarNumber(customerCreateRequest.getAadhaarNumber());

        return customer;
    }

    public CustomerCreateResponse toCustomerCreateResponseObject(Customer customer,String message){
        CustomerCreateResponse customerCreateResponse = new CustomerCreateResponse();
        customerCreateResponse.setCustomerId(customer.getCustomerId());
        customerCreateResponse.setMessage(message);
        return customerCreateResponse;
    }
}
