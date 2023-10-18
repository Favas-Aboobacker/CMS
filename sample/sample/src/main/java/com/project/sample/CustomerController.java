package com.project.sample;

import com.project.sample.model.Customer;
import com.project.sample.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
   private CustomerService customerService;


    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomerList();
    }

    @GetMapping(value = "/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int customerId){
        return customerService.getCustomer(customerId);
    }

   /* @GetMapping
    public Customer getCustomer(@PathVariable("customerLastName") String customerLastName){
        return customerService.getCustomer(customerLastName);
    }*/

    @PutMapping(value = "/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int customerId,@RequestBody Customer customer){
       return customerService.updateCustomer(customerId,customer);
    }

    @DeleteMapping(value = "/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customerId){
        customerService.deleteCustomer(customerId);
    }


}
