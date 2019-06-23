package com.product.org.repository;

import com.product.org.model.Product;

import java.util.List;

public interface ProductRepo{
    Product add(Product product);
    Product update(Product product);
    boolean doProductExist(String number);
    Product getByNumber(String number);
    Product get(int id);

    List<Product> getAll();
}
