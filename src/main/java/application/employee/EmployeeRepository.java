package application.employee;

import java.util.List;

public interface EmployeeRepository {
    public Employee getEmployeeById(int id);
    public List<Employee> getByCriteria(Employee criteria);
    public Employee addEmployee(Employee employee);
    public void deleteEmployee(int id);
    List<Employee> getAllEmployees();
}
