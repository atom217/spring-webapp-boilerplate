package org.technomonkeys.dao;

import java.util.Set;

import org.technomonkeys.dao.impl.RoleDAOImpl.RoleTypes;
import org.technomonkeys.model.Role;

public interface RoleDAO {
	
	Set<Role> getAll();
	
	Role getById(Integer id);
	
	Integer save(Role role);
	
	void update(Role role);
	
	void delete(Role role);

	void saveOrUpdate(Role role);

	Role getByType(RoleTypes type);

}
