package in.expleo.dao;

import org.springframework.data.repository.CrudRepository;

import in.expleo.model.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Integer> {

}
