package in.expleo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.expleo.dao.IEmployeeRepository;
import in.expleo.exception.EmployeeNotFoundException;
import in.expleo.model.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeRepository repo;

	@Override
	public List<Employee> findAllEmployee() {
		return (List<Employee>)repo.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}

	@Override
	public Employee findEmployeeById(Integer employeeId) {
		Employee employee = repo.findById(employeeId).orElseThrow( 
				() ->  new EmployeeNotFoundException("Record not Exist with the id :: "+employeeId));
		return employee;
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		Employee employee = repo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Record not Exist with the id :: "+id));
		repo.delete(employee);
		
	}

	



	


}
