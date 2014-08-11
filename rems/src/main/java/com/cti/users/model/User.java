package com.cti.users.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cti.common.REMS;
import com.cti.group.model.UserRole;

@Entity
@Table(name = "rems_user", catalog = "rems_db")
public class User implements REMS {

	// Variables for corresponding to DB Table
	@Id
	@Column(name = "username", nullable = false, unique = true, length = 16)
	private String username;

	@Column(name = "password", nullable = false, length = 16)
	private String password;

	@Column(name = "priority", nullable = false)
	private int priority;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	@Column(name = "accountNonExpired", nullable = false)
	private boolean accountNonExpired;

	@Column(name = "accountNonLocked", nullable = false)
	private boolean accountNonLocked;

	@Column(name = "credentialsNonExpired", nullable = false)
	private boolean credentialsNonExpired;

	@Column(name = "createdtime", nullable = false)
	private Date createdtime;

	@Column(name = "modifiedtime", nullable = false)
	private Date modifiedtime;

	private Set<UserRole> userRole;

	private UserDetail userDetail;

	// Constructors

	/**
	 * 
	 */
	public User() {
	}

	/**
	 * @param username
	 * @param password
	 * @param priority
	 * @param enabled
	 * @param accountNonExpired
	 * @param accountNonLocked
	 * @param credentialsNonExpired
	 * @param createdtime
	 * @param modifiedtime
	 */
	public User(String username, String password, int priority,
			boolean enabled, boolean accountNonExpired,
			boolean accountNonLocked, boolean credentialsNonExpired,
			Date createdtime, Date modifiedtime) {

		this.username = username;

		this.password = password;

		this.priority = priority;

		this.enabled = enabled;

		this.accountNonExpired = accountNonExpired;

		this.accountNonLocked = accountNonLocked;

		this.credentialsNonExpired = credentialsNonExpired;

		this.createdtime = createdtime;

		this.modifiedtime = modifiedtime;
	}

	// Getter Methods

	/**
	 * @return the username
	 */

	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */

	public String getPassword() {
		return password;
	}

	/**
	 * @return the priority
	 */

	public int getPriority() {
		return priority;
	}

	/**
	 * @return the enabled
	 */

	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @return the accountNonExpired
	 */

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	/**
	 * @return the accountNonLocked
	 */

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	/**
	 * @return the credentialsNonExpired
	 */

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	/**
	 * @return the createdtime
	 */

	public Date getCreatedtime() {
		return createdtime;
	}

	/**
	 * @return the modifiedtime
	 */

	public Date getModifiedtime() {
		return modifiedtime;
	}

	/**
	 * @return the userRole
	 */
	public Set<UserRole> getUserRole() {
		return userRole;
	}

	/**
	 * @return the userDetail
	 */
	public UserDetail getUserDetail() {
		return userDetail;
	}

	// Setter Methods
	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @param accountNonExpired
	 *            the accountNonExpired to set
	 */
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	/**
	 * @param accountNonLocked
	 *            the accountNonLocked to set
	 */
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	/**
	 * @param credentialsNonExpired
	 *            the credentialsNonExpired to set
	 */
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	/**
	 * @param createdtime
	 *            the createdtime to set
	 */
	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	/**
	 * @param modifiedtime
	 *            the modifiedtime to set
	 */
	public void setModifiedtime(Date modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

	/**
	 * @param userRole
	 *            the userRole to set
	 */
	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	/**
	 * @param userDetail
	 *            the userDetail to set
	 */
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

}
