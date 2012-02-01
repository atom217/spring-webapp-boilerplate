package org.technomonkeys.dao;

import java.util.Set;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.technomonkeys.model.User;

public interface UserDAO {

	User getUserByUsername(String username) throws UsernameNotFoundException;

	Set<User> getAll();

	User getById(Integer id);

	Integer save(User user);

	void update(User user);

	void delete(User user);

	void saveOrUpdate(User user);

}