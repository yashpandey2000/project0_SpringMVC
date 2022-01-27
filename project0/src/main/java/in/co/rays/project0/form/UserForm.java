/*
 * @author Yash Pandey
 */
package in.co.rays.project0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.project0.dto.BaseDTO;
import in.co.rays.project0.dto.UserDTO;
import in.co.rays.project0.util.Util;

/**
 * The Class UserForm.
 */
public class UserForm extends BaseForm {

	/** The first name. */
	@NotEmpty
	private String firstName;

	/** The last name. */
	@NotEmpty
	private String lastName;

	/** The login. */
	@Email
	@NotEmpty
	@Pattern(regexp = "^[_A-Za-z0-9-]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "{Email.form.emailId}")
	private String login;
	
	/** The password. */
	@NotEmpty
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})", message = "{Pattern.password}")
	private String password;

	/** The confirm password. */
	@NotEmpty
	private String confirmPassword;

	/** The dob. */
	@NotEmpty
	private String dob;

	/** The mobile no. */
	@NotEmpty
	@Pattern(regexp = "^[6-9][0-9]{9}$", message = "{Pattern.form.phoneNo}")
	private String mobileNo;

	/** The role id. */
	@Min(value = 1, message = "{Min.form.roleId}")
	private long roleId;

	/** The un successful login. */
	private int unSuccessfulLogin;
	
	/** The gender. */
	@NotEmpty
	private String gender;

	/** The last login. */
	private long lastLogin;

	/** The lock. */
	private String lock;

	/** The registered IP. */
	private String registeredIP;

	/** The last login IP. */
	private String lastLoginIP;

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * Sets the confirm password.
	 *
	 * @param confirmPassword the new confirm password
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * Gets the dob.
	 *
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * Sets the dob.
	 *
	 * @param dob the new dob
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * Gets the mobile no.
	 *
	 * @return the mobile no
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * Sets the mobile no.
	 *
	 * @param mobileNo the new mobile no
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	public long getRoleId() {
		return roleId;
	}

	/**
	 * Sets the role id.
	 *
	 * @param roleId the new role id
	 */
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	/**
	 * Gets the un successful login.
	 *
	 * @return the un successful login
	 */
	public int getUnSuccessfulLogin() {
		return unSuccessfulLogin;
	}

	/**
	 * Sets the un successful login.
	 *
	 * @param unSuccessfulLogin the new un successful login
	 */
	public void setUnSuccessfulLogin(int unSuccessfulLogin) {
		this.unSuccessfulLogin = unSuccessfulLogin;
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
	 * Gets the last login.
	 *
	 * @return the last login
	 */
	public long getLastLogin() {
		return lastLogin;
	}

	/**
	 * Sets the last login.
	 *
	 * @param lastLogin the new last login
	 */
	public void setLastLogin(long lastLogin) {
		this.lastLogin = lastLogin;
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

	/**
	 * Gets the registered IP.
	 *
	 * @return the registered IP
	 */
	public String getRegisteredIP() {
		return registeredIP;
	}

	/**
	 * Sets the registered IP.
	 *
	 * @param registeredIP the new registered IP
	 */
	public void setRegisteredIP(String registeredIP) {
		this.registeredIP = registeredIP;
	}

	/**
	 * Gets the last login IP.
	 *
	 * @return the last login IP
	 */
	public String getLastLoginIP() {
		return lastLoginIP;
	}

	/**
	 * Sets the last login IP.
	 *
	 * @param lastLoginIP the new last login IP
	 */
	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project_0.form.BaseForm#getDto()
	 */
	@Override
	public BaseDTO getdto() {
		UserDTO dto = new UserDTO();
		dto.setId(id);
		dto.setFirstname(firstName);
		dto.setLastname(lastName);
		dto.setLogin(login);
		System.out.println("con pwd" + confirmPassword);
          
			dto.setPassword(password);
			dto.setConfirmpassword(confirmPassword);
		
		
        System.out.println("date"+Util.getDate(dob));
        if(dob!=""){
		dto.setDob(Util.getDate(dob));
        }

		dto.setMobileno(mobileNo);
		dto.setRoleid(roleId);
		dto.setLastLogin(new Timestamp(lastLogin));
		dto.setGender(gender);
		//dto.setRegisteredip(registeredIP);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
		dto.setModifiedDateTime(new Timestamp(new Date().getTime()));

		return dto;

	}

	/* (non-Javadoc)
	 * @see in.co.rays.project_0.form.BaseForm#populate(in.co.rays.project_0.dto.BaseDTO)
	 */
	@Override
	public void populate(BaseDTO bdto) {

		UserDTO dto = (UserDTO) bdto;

		id = dto.getId();
		firstName = dto.getFirstname();
		lastName = dto.getLastname();
		login = dto.getLogin();
		password = dto.getPassword();
		confirmPassword = dto.getConfirmpassword();

		dob = Util.getDate(dto.getDob());

		mobileNo = dto.getMobileno();
		roleId = dto.getRoleid();

		if (dto.getLastLogin() != null) {
			lastLogin = dto.getLastLogin().getTime();
		}
		gender = dto.getGender();
		//registeredIP = dto.getRegisteredip();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		if (dto.getCreatedDateTime() != null) {
			createdDateTime = dto.getCreatedDateTime().getTime();
		}
		if (dto.getModifiedDateTime() != null) {
			modifiedDateTime = dto.getModifiedDateTime().getTime();
		}

	}
}
