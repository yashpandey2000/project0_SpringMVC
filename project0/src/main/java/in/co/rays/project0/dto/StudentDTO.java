/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * The Class StudentDTO.
 */

@Entity
@Table(name="st_student")
public class StudentDTO extends BaseDTO{
	
	
	/** The first name. */
	@Column(name="FIRST_NAME" , length=50)
	private String firstname;
	
	/** The last name. */
	@Column(name="LAST_NAME" , length=50)
	private String lastname;
	
	/** The dob. */
	@Column(name="DOB")
	private Date dob;
	
	/** The mobile no. */
	@Column(name="MOBILE_NO" , length=15)
	private String mobileno;
	
	/** The email. */
	@Column(name="EMAIL_ID" , length=50)
	private String emailid;
	
	/** The college id. */
	@Column(name="COLLEGE_ID" , length=50)
	private long collegeid;
	
	/** The college name. */
	@Column(name="COLLEGE_NAME" , length=50)
	private String collegename;
	
	
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
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmailid() {
		return emailid;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	

	/**
	 * Gets the college id.
	 *
	 * @return the college id
	 */
	public long getCollegeid() {
		return collegeid;
	}
	
	/**
	 * Sets the college id.
	 *
	 * @param collegeId the new college id
	 */
	public void setCollegeid(long collegeid) {
		this.collegeid = collegeid;
	}
	
	/**
	 * Gets the college name.
	 *
	 * @return the college name
	 */
	public String getCollegename() {
		return collegename;
	}
	
	/**
	 * Sets the college name.
	 *
	 * @param collegeName the new college name
	 */
	public void setCollegename(String collegename) {
		this.collegename = collegename;
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
