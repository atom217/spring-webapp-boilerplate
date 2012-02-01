package org.technomonkeys.manager.impl;

import java.util.Set;

import org.technomonkeys.dao.RoleDAO;
import org.technomonkeys.manager.RoleManager;
import org.technomonkeys.model.Role;

public class RoleManagerImpl implements RoleManager {
	private RoleDAO roleDAO;

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	@Override
	public Set<Role> getAllRoles() {
		return roleDAO.getAll();
	}
	
	@Override
	public Role getRoleById(Integer id) {
		return roleDAO.getById(id);
	}

	@Override
	public void saveRole(Role role) {
		roleDAO.save(role);
	}

	@Override
	public void updateRole(Role role) {
		roleDAO.update(role);
	}

	@Override
	public void saveOrUpdate(Role role) {
		roleDAO.saveOrUpdate(role);
	}

}