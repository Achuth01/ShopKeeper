package com.product.org.controller;

import com.product.org.model.CustomerDetails;
import com.product.org.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/getCustomerDetails/{invoice}")
    private CustomerDetails getByInvoice(@PathVariable String invoice){
        return customerService.getByInvoice(invoice);
    }

    @PostMapping(value = "/customerDetails/add")
    private CustomerDetails addCustomerDetails(@RequestBody  CustomerDetails customerDetails){
        return customerService.add(customerDetails);
    }
}
