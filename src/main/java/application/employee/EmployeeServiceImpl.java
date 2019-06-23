package application.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public List<Employee> getByCriteria(Employee criteria) {
        return employeeRepository.getByCriteria(criteria);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteEmployee(id);
    }

    @Override
    public List<Employee> getAllEmployeeBys() {
        return employeeRepository.getAllEmployees();
    }
}
