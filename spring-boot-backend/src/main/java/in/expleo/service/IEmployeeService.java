package in.expleo.service;

import java.util.List;
import java.util.Optional;

import in.expleo.model.Employee;

public interface IEmployeeService {
	public List<Employee> findAllEmployee();
	
	public Employee saveEmployee(Employee employee);
	
	public Employee findEmployeeById(Integer employeeId);
	
	//public Employee updateEmployee(Employee employee);
	
	public void deleteEmployeeById(Integer id);
}
