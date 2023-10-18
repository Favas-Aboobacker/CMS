package com.project.sample.service;

import com.project.sample.Exception.CustomerNotFoundException;
import com.project.sample.dao.CustomerDAO;
import com.project.sample.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;
    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<> ();

    public Customer addCustomer(Customer customer) {
//        customer.setCustomerID(customerIdCount);
//        customerList.add(customer);
//        customerIdCount++;

        return customerDAO.save(customer);
//        return customer;
    }

    public List<Customer> getCustomerList() {

       return customerDAO.findAll();
//        return customerList;
    }



    public Customer getCustomer(int customerId) {
        Optional<Customer>optionalCustomer = customerDAO.findById(customerId);

        if(!optionalCustomer.isPresent()) {
            throw new CustomerNotFoundException("Customer Record is not available");
        }
//        return customerList
//                .stream()
//                .filter(c -> c.getCustomerID() == customerId)
//                .findFirst()
//                .get();
//        return customerDAO.findById(customerId).get();
            return optionalCustomer.get();
    }

    public Customer updateCustomer(int customerId, Customer customer) {

        customer.setCustomerID((customerId));
//        customerList
//                .stream()
//                .forEach(c -> {
//                    if (c.getCustomerID() == customerId) {
//                        c.setCustomerFirstName(customer.getCustomerFirstName());
//                        c.setCustomerLastName(customer.getCustomerLastName());
//                        c.setCustomerEmail(customer.getCustomerEmail());
//                    }
//                });
//
//        return customerList
//                .stream()
//                .filter(c -> c.getCustomerID() == customerId)
//                .findFirst()
//                .get();

        return customerDAO.save(customer);
    }

    public void deleteCustomer(int customerId) {

//        customerList
//                .stream()
//                .forEach(c -> {
//                    if (c.getCustomerID() == customerId) {
//                        customerList.remove(c);
//                    }
//                });
        customerDAO.deleteById(customerId);
    }
}
