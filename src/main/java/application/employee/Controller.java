package application.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/get/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(value = "/get/all")
    public List<Employee> getAllEmployees(){ return employeeService.getAllEmployeeBys(); }

    @RequestMapping(value ="/add",method = RequestMethod.POST)
    public Employee addEmployees(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PostMapping(value = "/getByCriteria")
    public List<Employee> getByCriteria(@RequestBody Employee criteria){
        return employeeService.getByCriteria(criteria);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.delete(id);
    }
}
