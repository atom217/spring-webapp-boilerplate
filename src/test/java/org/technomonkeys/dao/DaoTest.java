package org.technomonkeys.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.technomonkeys.dao.impl.RoleDAOImpl.RoleTypes;
import org.technomonkeys.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/application-context.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
public class DaoTest {
	
	@Resource
	private UserDAO userDAO;
	@Resource
	private RoleDAO roleDAO;
	
	@Test
	public void testUserManagementDAO () {
		assertNotNull(userDAO);
		assertNotNull(roleDAO);

		User vbarrila = userDAO.getUserByUsername("user");
		assertNotNull(vbarrila);

		User jdoe = new User("jdoe", "jdoe", roleDAO.getByType(RoleTypes.ROLE_USER));
		userDAO.saveOrUpdate(jdoe);

		assertEquals(3, userDAO.getAll().size());
		
		jdoe = userDAO.getUserByUsername("jdoe");
		userDAO.delete(jdoe);
		
		assertEquals(2, userDAO.getAll().size());
		
	}
}
