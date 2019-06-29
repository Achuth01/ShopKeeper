package com.product.org.service;

import com.product.org.model.CustomerDetails;

public interface CustomerService {
    CustomerDetails add(CustomerDetails customerDetails) throws Exception;
    CustomerDetails getByInvoice(String invoiceNumber);
}
