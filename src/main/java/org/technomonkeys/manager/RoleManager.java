package org.technomonkeys.manager;

import java.util.Set;

import org.technomonkeys.model.Role;

public interface RoleManager {
	
	Set<Role> getAllRoles();
	
	Role getRoleById(Integer id);
	
	void saveRole(Role role);
	
	void updateRole(Role role);
	
	void saveOrUpdate(Role role);
	
}
