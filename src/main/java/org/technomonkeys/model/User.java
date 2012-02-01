package org.technomonkeys.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class User implements UserDetails {
	private Integer id;
	@NotEmpty
	@Length(max=45)
	private String username;
	@NotEmpty
	@Length(max=80)
	private String password;
	private boolean accountEnabled;
	private boolean accountExpired;
	private boolean accountLocked;
	private boolean credentialsExpired;
	@NotEmpty
	private Set<Role> roles = new HashSet<Role>();
	
	public User() {
		this.accountEnabled = true;
		this.accountExpired = false;
		this.accountLocked = false;
		this.credentialsExpired = false;
	}
	
	public User(String username, String password) {
		this.accountEnabled = true;
		this.accountExpired = false;
		this.accountLocked = false;
		this.credentialsExpired = false;
		this.username = username;
		this.password = password;
	}
	
	public User(String username, String password, Set<Role> roles) {
		this.accountEnabled = true;
		this.accountExpired = false;
		this.accountLocked = false;
		this.credentialsExpired = false;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	
	public User(String username, String password, Role role) {
		this.accountEnabled = true;
		this.accountExpired = false;
		this.accountLocked = false;
		this.credentialsExpired = false;
		this.username = username;
		this.password = password;
		this.roles.add(role);
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAccountExpired() {
		return accountExpired;
	}

	public void setAccountExpired(boolean accountExpired) {
		this.accountExpired = accountExpired;
	}

	public boolean isAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public boolean isCredentialsExpired() {
		return credentialsExpired;
	}

	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role role : roles) {
			authorities.add(new GrantedAuthorityImpl(role.getName()));
		}
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return !isAccountExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return !isAccountLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !isCredentialsExpired();
	}

	@Override
	public boolean isEnabled() {
		return isAccountEnabled();
	}

	public boolean isAccountEnabled() {
		return accountEnabled;
	}

	public void setAccountEnabled(boolean accountEnabled) {
		this.accountEnabled = accountEnabled;
	}
	
}
