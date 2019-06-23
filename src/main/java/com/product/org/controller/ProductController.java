package com.product.org.controller;


import com.product.org.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.product.org.service.ProductService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/product/add")
    private boolean add(@RequestBody Product product) {
        return productService.add(product);
    }

    @GetMapping(value = "/product/{number}")
    private Product get(@PathVariable String number){
        return productService.getProductByNumber(number);
    }


}
