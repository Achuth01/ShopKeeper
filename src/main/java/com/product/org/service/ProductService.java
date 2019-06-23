package com.product.org.service;

import com.product.org.model.Product;

import java.util.List;

public interface ProductService {

   boolean add(Product product);
   Product get(int id);
   boolean doProductExist(String number);
   Product getProductByNumber(String productSerialNumber);
   List<Product> getAllProducts();
}
