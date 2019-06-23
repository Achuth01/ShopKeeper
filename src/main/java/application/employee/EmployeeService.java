package application.employee;

import java.util.List;

public interface EmployeeService {
    public Employee getEmployeeById(int id);
    public List<Employee> getByCriteria(Employee criteria);
    public Employee addEmployee(Employee employee);
    public void delete(int id);

     List<Employee> getAllEmployeeBys();
}
