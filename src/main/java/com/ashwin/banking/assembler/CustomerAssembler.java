package com.ashwin.banking.assembler;

import com.ashwin.banking.dto.*;
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

    public CustomerResponse toCustomerResponse(Customer customer){

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCustomerId(customer.getCustomerId());
        customerResponse.setFirstName(customer.getFirstName());
        customerResponse.setLastName(customer.getLastName());
        customerResponse.setEmail(customer.getEmail());
        customerResponse.setDateOfBirth(customer.getDateOfBirth());
        customerResponse.setMobileNumber(customer.getMobileNumber());
        customerResponse.setAddress(customer.getAddress());
        customerResponse.setPanNumber(customer.getPanNumber());
        customerResponse.setAadhaarNumber(customer.getAadhaarNumber());
        customerResponse.setStatus(customer.getStatus());

        return customerResponse;
    }

    public Customer updateCustomerFromRequest(CustomerUpdateRequest customerUpdateRequest, Customer customer){

        customer.setFirstName(customerUpdateRequest.getFirstName());
        customer.setLastName(customerUpdateRequest.getLastName());
        customer.setEmail(customerUpdateRequest.getEmail());
        customer.setMobileNumber(customerUpdateRequest.getMobileNumber());
        customer.setAddress(customerUpdateRequest.getAddress());

        return customer;
    }
}
