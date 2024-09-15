package in.expleo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.expleo.dao.RoleDao;
import in.expleo.entity.Role;

@Service
public class RoleService {
	
	@Autowired
	private RoleDao dao;
	
	public Role crateNewRole(Role role) {
		return dao.save(role);
	}
}
