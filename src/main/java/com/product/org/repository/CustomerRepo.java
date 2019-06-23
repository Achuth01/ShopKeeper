package com.product.org.repository;

import com.product.org.model.CustomerDetails;

public interface CustomerRepo {
    CustomerDetails add(CustomerDetails customerDetails);
    CustomerDetails getByInvoice(String invoiceNumber);
}
