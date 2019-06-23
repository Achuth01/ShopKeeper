package application.employee;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl extends SimpleJpaRepository<Employee,Integer> implements EmployeeRepository {

    private EntityManager entityManager;

    public EmployeeRepositoryImpl(EntityManager entityManager) {
        super(Employee.class, entityManager);
        this.entityManager=entityManager;
    }

    @Override
    public Employee getEmployeeById(int id) { return this.findOne(id); }

    @Override
    public Employee addEmployee(Employee employee) {
        return this.saveAndFlush(employee);
    }

    @Override
    public void deleteEmployee(int id) { this.delete(id); }

    @Override
    public List<Employee> getAllEmployees() { return this.findAll(); }

    @Override
    public List<Employee> getByCriteria(Employee criteria) {

        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query=criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root=query.from(Employee.class);
        List<Predicate> predicates=new ArrayList<Predicate>();

        if(!org.springframework.util.StringUtils.isEmpty(criteria.getEmployeeId()))
        predicates.add(criteriaBuilder.equal(root.get("employeeId"),criteria.getEmployeeId()));

        if(!org.springframework.util.StringUtils.isEmpty(criteria.getEmployeeName()))
        predicates.add(criteriaBuilder.equal(root.get("employeeName"),criteria.getEmployeeName()));

        if(!org.springframework.util.StringUtils.isEmpty(criteria.getArea()))
        predicates.add(criteriaBuilder.equal(root.get("area"),criteria.getArea()));

        if(!org.springframework.util.StringUtils.isEmpty(criteria.getAsset()))
        predicates.add(criteriaBuilder.equal(root.get("asset"),criteria.getAsset()));

        if(predicates.size()==0) throw new RuntimeException("no criteria found");

        else if(predicates.size()==1) query.where(predicates.get(0));

        else query.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));

        TypedQuery<Employee> employees=entityManager.createQuery(query);

        return employees.getResultList();
    }


}
