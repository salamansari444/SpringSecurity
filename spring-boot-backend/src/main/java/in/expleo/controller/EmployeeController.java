package in.expleo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.expleo.model.Employee;
import in.expleo.service.EmployeeServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl service;
	
	//Get All Employee :: http://localhost:9999/api/v1/employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return service.findAllEmployee();
	}
	
	//Create Employee :: http://localhost:9999/api/v1/employees
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}
	
	//Get  Employee  by Id :: http://localhost:9999/api/v1/employees/{employeeId}
	@GetMapping("/employees/{employeeId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer employeeId){
		Employee employee = service.findEmployeeById(employeeId);
		return ResponseEntity.ok(employee);
		
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id,@RequestBody Employee employee){
		Employee findEmployeeById = service.findEmployeeById(id);
		findEmployeeById.setFirstName(employee.getFirstName());
		findEmployeeById.setLastName(employee.getLastName());
		findEmployeeById.setEmailId(employee.getEmailId());
		Employee updatedEmployee = service.saveEmployee(findEmployeeById);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer id){
		service.deleteEmployeeById(id);
		HashMap<String, Boolean > response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}	
