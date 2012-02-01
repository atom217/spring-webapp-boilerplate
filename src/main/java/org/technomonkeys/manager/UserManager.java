package org.technomonkeys.manager;

import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.technomonkeys.model.User;

public interface UserManager {

	UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException;

	Set<User> getAllUsers();

	User getUserById(Integer id);

	void saveUser(User user);

	void updateUser(User user);

	void saveOrUpdate(User user);

}