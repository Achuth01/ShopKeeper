package com.product.org.service;

import com.product.org.model.CustomerDetails;

public interface CustomerService {
    CustomerDetails add(CustomerDetails customerDetails);
    CustomerDetails getByInvoice(String invoiceNumber);
}
