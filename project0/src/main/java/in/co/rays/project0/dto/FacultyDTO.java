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
 * The Class FacultyDTO.
 */

@Entity
@Table(name="st_faculty")
public class FacultyDTO extends BaseDTO{
	
	/** The first name. */
	@Column(name="FIRST_NAME" , length=50)
	private String firstname;
	
	/** The last name. */
	@Column(name="LAST_NAME" , length=50)
	private String lastname;
	
	/** The dob. */
	@Column(name="DOB" , length=50)
	private Date dob;
	
	/** The gender. */
	@Column(name="GENDER" , length=50)
	private String gender;
	
	/** The mobile no. */
	@Column(name="MOBILE_NO" , length=50)
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
	
	/** The course id. */
	@Column(name="COURSE_ID" , length=50)
	private long courseid;
	
	/** The course name. */
	@Column(name="COURSE_NAME" , length=50)
	private String coursename;
	
	/** The subject id. */
	@Column(name="SUBJECT_ID" , length=50)
	private long subjectid;
	
	/** The subject name. */
	@Column(name="SUBJECT_NAME" , length=50)
	private String subjectname;
	
	
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
	
	/**
	 * Gets the course id.
	 *
	 * @return the course id
	 */
	public long getCourseid() {
		return courseid;
	}
	
	
	/**
	 * Sets the course id.
	 *
	 * @param courseId the new course id
	 */
	public void setCourseid(long courseid) {
		this.courseid = courseid;
	}
	
	/**
	 * Gets the course name.
	 *
	 * @return the course name
	 */
	public String getCoursename() {
		return coursename;
	}
	

	/**
	 * Sets the course name.
	 *
	 * @param courseName the new course name
	 */
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	
	/**
	 * Gets the subject id.
	 *
	 * @return the subject id
	 */
	public long getSubjectid() {
		return subjectid;
	}
	
	/**
	 * Sets the subject id.
	 *
	 * @param subjectId the new subject id
	 */
	public void setSubjectid(long subjectid) {
		this.subjectid = subjectid;
	}
	
	
	/**
	 * Gets the subjectname.
	 *
	 * @return the subjectname
	 */
	
	
	public String getSubjectname() {
		return subjectname;
	}
	
	/**
	 * Sets the subjectname.
	 *
	 * @param subjectId the new subjectname
	 */
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
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
