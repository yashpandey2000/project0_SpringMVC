/*
 * @author Yash Pandey
 */
package in.co.rays.project0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.project0.dto.BaseDTO;
import in.co.rays.project0.dto.FacultyDTO;
import in.co.rays.project0.util.Util;

/**
 * The Class FacultyForm.
 */
public class FacultyForm extends BaseForm {

	/** The first name. */
	@NotEmpty
	private String firstName;
	
	/** The last name. */
	@NotEmpty
	private String lastName;
	
	/** The dob. */
	@NotEmpty
    private String dob;
	
	/** The login. */
	@NotEmpty
    private String login;
	
	/** The mobile no. */
	@NotEmpty
    private String mobileNo;
	
	/** The gender. */
	@NotEmpty
	private String gender;
	
	/** The course id. */
	@Min(value=1,message="{Min.form.courseId}")
    private long courseId;
	
	/** The subject id. */
	@Min(value=1,message="{Min.form.subjectId}")
    private long subjectId;
	
	/** The college id. */
	@Min(value=1,message="{Min.form.collegeId}")
    private long collegeId;
	
	/** The college name. */
	private String collegeName;
	
	/** The subject name. */
	private String subjectName;
	
	/** The course name. */
	private String courseName;
	
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
	 * Gets the course id.
	 *
	 * @return the course id
	 */
	public long getCourseId() {
		return courseId;
	}
	
	/**
	 * Sets the course id.
	 *
	 * @param courseId the new course id
	 */
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	
	/**
	 * Gets the subject id.
	 *
	 * @return the subject id
	 */
	public long getSubjectId() {
		return subjectId;
	}
	
	/**
	 * Sets the subject id.
	 *
	 * @param subjectId the new subject id
	 */
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	
	/**
	 * Gets the college id.
	 *
	 * @return the college id
	 */
	public long getCollegeId() {
		return collegeId;
	}
	
	/**
	 * Sets the college id.
	 *
	 * @param collegeId the new college id
	 */
	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}
	
	/**
	 * Gets the college name.
	 *
	 * @return the college name
	 */
	public String getCollegeName() {
		return collegeName;
	}
	
	/**
	 * Sets the college name.
	 *
	 * @param collegeName the new college name
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
	/**
	 * Gets the subject name.
	 *
	 * @return the subject name
	 */
	public String getSubjectName() {
		return subjectName;
	}
	
	/**
	 * Sets the subject name.
	 *
	 * @param subjectName the new subject name
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	/**
	 * Gets the course name.
	 *
	 * @return the course name
	 */
	public String getCourseName() {
		return courseName;
	}
	
	/**
	 * Sets the course name.
	 *
	 * @param courseName the new course name
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	/* (non-Javadoc)
	 * @see in.co.rays.project_0.form.BaseForm#getDto()
	 */
	@Override
	public BaseDTO getdto(){
		FacultyDTO dto=new FacultyDTO();
		dto.setId(id);
		dto.setFirstname(firstName);
		dto.setLastname(lastName);
		dto.setMobileno(mobileNo);
		dto.setGender(gender);
		dto.setEmailid(login);
		System.out.println("in faculty dob"+dob);
		   if(dob!=""){
		        dto.setDob(Util.getDate(dob));
		        }

		dto.setCollegeid(collegeId);
		dto.setCourseid(courseId);
		dto.setSubjectid(subjectId);
		dto.setCollegename(collegeName);
		dto.setCoursename(courseName);
		dto.setSubjectname(subjectName);
		dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
        dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
		
		return dto;
		
	}
   
   /* (non-Javadoc)
    * @see in.co.rays.project_0.form.BaseForm#populate(in.co.rays.project_0.dto.BaseDTO)
    */
	@Override
   public void populate(BaseDTO bdto){
	   FacultyDTO dto=(FacultyDTO) bdto;
		id=dto.getId();
		collegeId=dto.getCollegeid();
		collegeName=dto.getCollegename();
		courseId=dto.getCourseid();
		courseName=dto.getCoursename();
		subjectId=dto.getSubjectid();
		subjectName=dto.getSubjectname();
		login=dto.getEmailid();
		firstName=dto.getFirstname();
		lastName=dto.getLastname();
		gender=dto.getGender();
		mobileNo=dto.getMobileno();
		dob=Util.getDate(dto.getDob());
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
