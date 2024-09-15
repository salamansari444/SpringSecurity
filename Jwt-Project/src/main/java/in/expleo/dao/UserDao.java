package in.expleo.dao;

import org.springframework.data.repository.CrudRepository;

import in.expleo.entity.User;

public interface UserDao extends CrudRepository<User, String> {
	
}
