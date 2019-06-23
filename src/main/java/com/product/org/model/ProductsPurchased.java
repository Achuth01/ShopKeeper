package com.product.org.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "products_purchased_product")
//@Table(name = "products_purchased")
public class ProductsPurchased  {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "products_purchased_id", columnDefinition = "VARCHAR(255)")
    private String id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_serial_number")
    private String productSerialNumber;

    @Column(name = "price")
    private Integer price;

    @Column(name = "quantities_sold")
    private Integer quantitiesSold;

    @Column(name = "item_price")
    private Integer itemPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "customer_id")
    private CustomerDetails customerDetails;

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSerialNumber() {
        return productSerialNumber;
    }

    public void setProductSerialNumber(String productSerialNumber) {
        this.productSerialNumber = productSerialNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantitiesSold() {
        return quantitiesSold;
    }

    public void setQuantitiesSold(Integer quantitiesSold) {
        this.quantitiesSold = quantitiesSold;
    }

    public Integer getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }


}
