/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



/**
 * The Class UserDTO.
 */


@Entity
@Table(name="st_user")
public class UserDTO extends BaseDTO{
	
	/** The Constant ACTIVE. */
	public static final String ACTIVE = "Active";
	 /** The Constant INACTIVE. */
	public static final String INACTIVE = "Inactive";
	
	
	/** The first name. */
	@Column(name="FIRST_NAME" , length=50)
	private String firstname;
	
	/** The last name. */
	@Column(name="LAST_NAME" , length=50)
	private String lastname;
	
	/** The login. */
	@Column(name="LOGIN_ID" , length=50)
	private String login;
	
	/** The password. */
	@Column(name="PASSWORD" , length=50)
	private String password;
	
	/** The confirm password. */
	@Column(name="CONFIRM_PASSWORD" , length=50)
	private String confirmpassword;
	
	/** The last login. */
	@Column(name = "LAST_LOGIN", length = 50)
    private Timestamp lastLogin;
	

	@Column(name="DOB")
	private Date dob;
	
	@Column(name="MOBILE_NO" , length=15)
	private String mobileno;
	
	@Column(name="ROLE_ID" )
	private long roleid;
	
	@Column(name="ROLE_NAME" )
	private String rolename;
	
	
	@Column(name="GENDER" , length=10)
	private String gender;
	
	
	@Column(name="USER_LOCK" , length=10)
	private String lock = ACTIVE;
	
	
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */

	public String getFirstname() {
		return firstname;
	}

	
	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	
	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastname() {
		return lastname;
	}
	
	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the login.
	 *
	 * @param login the new login
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */

	public String getPassword() {
		return password;
	}

	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the confirm password.
	 *
	 * @return the confirm password
	 */

	public String getConfirmpassword() {
		return confirmpassword;
	}
	
	
	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	
	/**
	 * Sets the confirm password.
	 *
	 * @param confirmPassword the new confirm password
	 */
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	
	/**
	 * Gets the dob.
	 *
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	
	/**
	 * Sets the dob.
	 *
	 * @param dob the new dob
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	

	/**
	 * Gets the mobile no.
	 *
	 * @return the mobile no
	 */
	public String getMobileno() {
		return mobileno;
	}

	/**
	 * Sets the mobile no.
	 *
	 * @param mobileNo the new mobile no
	 */
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	public long getRoleid() {
		return roleid;
	}

	
	/**
	 * Sets the role id.
	 *
	 * @param roleId the new role id
	 */
	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}

	/**
	 * Gets the role name.
	 *
	 * @return the role name
	 */
	public String getRolename() {
		return rolename;
	}
	
	/**
	 * Sets the role name.
	 *
	 * @param roleId the new role name
	 */

	public void setRolename(String string) {
		this.rolename = string;
	}
	
	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */


	public String getGender() {
		return gender;
	}


	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the lock.
	 *
	 * @return the lock
	 */
	
	public String getLock() {
		return lock;
	}


	/**
	 * Sets the lock.
	 *
	 * @param lock the new lock
	 */
	public void setLock(String lock) {
		this.lock = lock;
	}


	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(BaseDTO o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project_0.dto.DropdownList#getKey()
	 */
	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	
	/* (non-Javadoc)
	 * @see in.co.rays.project_0.dto.DropdownList#getValue()
	 */
	public String getValue() {
		// TODO Auto-generated method stub
		return firstname+" "+lastname;
	}
	
	
	
	
	
	
	
	
	
	
	

}
