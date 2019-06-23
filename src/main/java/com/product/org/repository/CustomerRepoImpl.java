package com.product.org.repository;

import com.product.org.model.CustomerDetails;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@Repository
//@Transactional
public class CustomerRepoImpl extends SimpleJpaRepository<CustomerDetails,Integer> implements CustomerRepo {

    private EntityManager entityManager;

    public CustomerRepoImpl(EntityManager em) {
        super(CustomerDetails.class, em);
        this.entityManager=em;
    }

    @Override
    public CustomerDetails add(CustomerDetails customerDetails) {
        return this.saveAndFlush(customerDetails);
    }

    @Override
    public CustomerDetails getByInvoice(String invoiceNumber) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<CustomerDetails> root = criteriaQuery.from(CustomerDetails.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("invoiceNumber"),invoiceNumber));
        try{
            return (CustomerDetails) entityManager.createQuery(criteriaQuery).getSingleResult();
        }catch (Exception e){
            System.out.println("e = " + e);
            return null;
        }
    }
}
