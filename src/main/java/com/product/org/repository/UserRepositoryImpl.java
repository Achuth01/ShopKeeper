package com.product.org.repository;

import com.product.org.model.User;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl extends SimpleJpaRepository<User,String> implements UserRepository {

    private EntityManager entityManager;
    public UserRepositoryImpl(EntityManager em) {
        super(User.class, em);
        this.entityManager = em;
    }

    @Override
    @Transactional
    public User addUser(User user) {
        return this.saveAndFlush(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.findAll();
    }

    @Override
    public User userAuthentication(String userName, String password) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<User> root = cq.from(User.class);
        cq.select(root);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(root.get("userName"),userName));
        predicates.add(cb.equal(root.get("password"),password));
        cq.where(predicates.toArray(new Predicate[0]));
        try {
            return (User) entityManager.createQuery(cq).getSingleResult();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean doUserNameExist(String userName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<User> root = cq.from(User.class);
        cq.select(root);
        cq.where(cb.equal(root.get("userName"), userName));

        try {
            entityManager.createQuery(cq).getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    @Override
    public boolean doEmailExist(String email) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<User> root = cq.from(User.class);
        cq.select(root);
        cq.where(cb.equal(root.get("email"),email));
        try {
            entityManager.createQuery(cq).getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }
}
