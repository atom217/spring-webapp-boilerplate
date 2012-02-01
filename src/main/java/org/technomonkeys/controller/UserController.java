package org.technomonkeys.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.technomonkeys.manager.UserManager;
import org.technomonkeys.model.User;
import org.technomonkeys.util.ResponseWrapper;

import com.google.gson.Gson;

@Controller
public class UserController {
	private Logger log = Logger.getLogger(UserController.class);
	private UserManager userManager;
	
	@RequestMapping(value="/users.html", method=RequestMethod.GET)
	public @ResponseBody String userList(HttpServletRequest request, HttpServletResponse response){
		log.debug("Reuqest received for URL: users.html");
		Set<User> userList = null;
		ResponseWrapper resWrapper = new ResponseWrapper();
		Gson gson = new Gson();
		try {
			userList = userManager.getAllUsers();
			resWrapper.createSuccessResponse(userList);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch(Exception e) {
			log.error("Error executing query: userManager.getAllUsers()", e);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			resWrapper.createErrorResponse();
		}
		return gson.toJson(resWrapper);
	}
	
	@RequestMapping(value="/user.html", method=RequestMethod.GET)
	public @ResponseBody String getUser(String userId, HttpServletRequest request, HttpServletResponse response){
		log.debug("Reuqest received for URL: user.html - Params: userId=" +userId);
		User user = null;
		ResponseWrapper resWrapper = new ResponseWrapper();
		Gson gson = new Gson();
		try {
			int user_id = Integer.parseInt(userId); 
			user = userManager.getUserById(user_id);
			if(user != null) {
				resWrapper.createSuccessResponse(user);
			} else {
				resWrapper.createSuccessResponse("User with id: " + userId + " not found", user);
			}
			response.setStatus(HttpServletResponse.SC_OK);
		} catch(Exception e) {
			log.error("Error executing query: userManager.getUserById()", e);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			resWrapper.createErrorResponse();
		}
		return gson.toJson(resWrapper);
	}

	/**
	 * Getters and Setters
	 */
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
}
