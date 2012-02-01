package org.technomonkeys.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.technomonkeys.dao.UserDAO;
import org.technomonkeys.model.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByUsername(String username) throws UsernameNotFoundException {
		List<User> users = getHibernateTemplate().findByNamedQueryAndNamedParam("User.getUserByUsername", "username", username);
		if(users.size() > 0) {
			return users.get(0);
		} else {
			throw new UsernameNotFoundException("User with username ["+username+"] not found.");
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Set<User> getAll() {
		return new HashSet(getHibernateTemplate().loadAll(User.class));
	}

	@Override
	public Integer save(User user) {
		return (Integer) getHibernateTemplate().save(user);
	}

	@Override
	public void update(User user) {
		getHibernateTemplate().update(user);
	}

	@Override
	public void delete(User user) {
		getHibernateTemplate().delete(user);
	}

	@Override
	public User getById(Integer id) {
		return getHibernateTemplate().get(User.class, id);
	}

	public void saveOrUpdate(User user) {
		getHibernateTemplate().saveOrUpdate(user);
	}

}