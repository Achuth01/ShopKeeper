package com.product.org.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "customer_details_product")
//@Table(name = "customer_details")
public class CustomerDetails  {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "customer_id", columnDefinition = "VARCHAR(255)")
    private String id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name =  "purchase_date")
    private String purchasedDate;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @OneToMany(
            mappedBy = "customerDetails",
            cascade = CascadeType.PERSIST,
            orphanRemoval = true)
    private Set<ProductsPurchased> productsPurchasedList;

    public Set<ProductsPurchased> getProductsPurchasedList() {
        return productsPurchasedList;
    }

    public void setProductsPurchasedList(Set<ProductsPurchased> productsPurchasedList) {
        this.productsPurchasedList = productsPurchasedList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(String purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
}
