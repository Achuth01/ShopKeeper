package com.product.org.service;

import com.product.org.model.JwtAuthenticationToken;
import com.product.org.model.Product;
import com.product.org.security.JwtAuthenticationProvider;
import com.product.org.security.JwtValidator;
import org.springframework.beans.factory.annotation.Autowired;
import com.product.org.repository.ProductRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Transactional
    @Override
    public boolean add(Product product) {
        if(doProductExist(product.getProductSerialNumber())) {
            throw new RuntimeException("Product Already Exists");
        }
        try {
            product.setCreatedBy(JwtValidator.validate(JwtAuthenticationToken.getToken()).getUserId());
            productRepo.add(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Product get(int id) {
        return productRepo.get(id);
    }

    @Override
    public boolean doProductExist(String number) {
        return productRepo.doProductExist(number);
    }

    @Override
    public Product getProductByNumber(String productSerialNumber) {
        return productRepo.getByNumber(productSerialNumber, JwtValidator.validate(JwtAuthenticationToken.getToken()).getUserId());
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.getAll();
    }
}
