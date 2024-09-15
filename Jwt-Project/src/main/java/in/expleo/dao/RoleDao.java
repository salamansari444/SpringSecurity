package in.expleo.dao;

import org.springframework.data.repository.CrudRepository;

import in.expleo.entity.Role;

public interface RoleDao extends CrudRepository<Role, String> {

}
