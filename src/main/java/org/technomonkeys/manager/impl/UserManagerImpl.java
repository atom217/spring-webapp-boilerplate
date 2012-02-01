package org.technomonkeys.manager.impl;

import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.technomonkeys.dao.UserDAO;
import org.technomonkeys.manager.UserManager;
import org.technomonkeys.model.User;

public class UserManagerImpl implements UserManager, UserDetailsService {
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		return userDAO.getUserByUsername(username);
	}
	
	@Override
	public Set<User> getAllUsers() {
		return userDAO.getAll();
	}

	@Override
	public User getUserById(Integer id) {
		return userDAO.getById(id);
	}

	@Override
	public void saveUser(User user) {
		userDAO.save(user);
	}

	@Override
	public void updateUser(User user) {
		userDAO.update(user);
	}

	@Override
	public void saveOrUpdate(User user) {
		userDAO.saveOrUpdate(user);
	}

}