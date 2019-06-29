package com.product.org.service;

import com.product.org.model.CustomerDetails;
import com.product.org.model.JwtAuthenticationToken;
import com.product.org.model.Product;
import com.product.org.model.ProductsPurchased;
import com.product.org.repository.CustomerRepo;
import com.product.org.repository.ProductRepo;
import com.product.org.security.JwtAuthenticationProvider;
import com.product.org.security.JwtValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ProductRepo productRepo;

    @Transactional
    @Override
    public CustomerDetails add(CustomerDetails customerDetails) throws Exception {
        for(ProductsPurchased productsPurchased:customerDetails.getProductsPurchasedList()){
            productsPurchased.setId(null);
            productsPurchased.setItemPrice(productsPurchased.getPrice()*productsPurchased.getQuantitiesSold());
            productsPurchased.setCustomerDetails(customerDetails);
            Product product=productRepo.getByNumber(productsPurchased.getProductSerialNumber(), JwtValidator.validate(JwtAuthenticationToken.getToken()).getUserId());
            if(product.getQuantity()<productsPurchased.getQuantitiesSold())
                throw new Exception("Maximum of " + product.getQuantity() + " " + product.getProductName() + " available");
            product.setQuantity(product.getQuantity()-productsPurchased.getQuantitiesSold());
            productRepo.update(product);
        }
        customerDetails.setInvoiceNumber("INV-"+System.currentTimeMillis());
        customerDetails.setPurchasedDate(dateFormatter(customerDetails.getPurchasedDate()));
        customerDetails.getProductsPurchasedList().stream().forEach(productsPurchased -> productsPurchased.setCustomerDetails(customerDetails));

        return customerRepo.add(customerDetails);
    }

    @Override
    public CustomerDetails getByInvoice(String invoiceNumber) {
        return customerRepo.getByInvoice(invoiceNumber);
    }

    private String dateFormatter(String dateStr){
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
        try {
            Date date = dateFormat.parse(dateStr);
            return String.valueOf(date.getTime());
        } catch (Exception e) {
            return String.valueOf(System.currentTimeMillis());
        }

    }
}
