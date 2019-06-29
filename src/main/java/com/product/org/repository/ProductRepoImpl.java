package com.product.org.repository;

import com.product.org.model.Product;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
//@Transactional
public class ProductRepoImpl extends SimpleJpaRepository<Product,Integer> implements ProductRepo {

    private EntityManager entityManager;

    public ProductRepoImpl(EntityManager em) {
        super(Product.class, em);
        this.entityManager = em;
    }

    @Override
    public Product add(Product product) {
        return this.saveAndFlush(product);
    }

    @Override
    public Product update(Product product) {
        return this.saveAndFlush(product);
    }

    @Override
    public Product get(int id) {
        return this.findOne(id);
    }

    @Override
    public List<Product> getAll() {
        return  this.getAll();
    }

    @Override
    public boolean doProductExist(String number) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Product> root = cq.from(Product.class);
        cq.select(root);
        cq.where(cb.equal(root.get("productSerialNumber"), number));
        try {
            entityManager.createQuery(cq).getSingleResult();
            return true;
        }catch (NoResultException e){
            return false;
        }catch (Exception e){
            throw new RuntimeException("There is some error.Please try again after some time");
        }
    }

    @Override
    public Product getByNumber(String number,String userId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Product> root = cq.from(Product.class);
        cq.select(root);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(root.get("productSerialNumber"), number));
        predicates.add(cb.equal(root.get("createdBy"), userId));
        try {
            return (Product) entityManager.createQuery(cq).getSingleResult();
        } catch(NoResultException e){
            throw new RuntimeException("No results found");
        } catch (Exception e){
            throw new RuntimeException("There is some error.Please try again after some time");
        }
    }
}
