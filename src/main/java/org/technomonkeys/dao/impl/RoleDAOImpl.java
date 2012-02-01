package org.technomonkeys.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.technomonkeys.dao.RoleDAO;
import org.technomonkeys.model.Role;

public class RoleDAOImpl extends HibernateDaoSupport implements RoleDAO {
	
	public enum RoleTypes{
		ROLE_ADMIN(),
		ROLE_USER();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Set<Role> getAll() {
		return new HashSet(getHibernateTemplate().loadAll(Role.class));
	}

	@Override
	public Integer save(Role role) {
		return (Integer) getHibernateTemplate().save(role);
	}

	@Override
	public void update(Role role) {
		getHibernateTemplate().update(role);
	}

	@Override
	public void delete(Role role) {
		getHibernateTemplate().delete(role);
	}

	@Override
	public Role getById(Integer id) {
		return getHibernateTemplate().get(Role.class, id);
	}
	
	@Override
	public Role getByType(RoleTypes type) {
		switch(type) {
		case ROLE_ADMIN:
			return getHibernateTemplate().get(Role.class, 1);
		case ROLE_USER:
			return getHibernateTemplate().get(Role.class, 2);
		default:
			return null;
		}
	}

	public void saveOrUpdate(Role role) {
		getHibernateTemplate().saveOrUpdate(role);
	}

}
