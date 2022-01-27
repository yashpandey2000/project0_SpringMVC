/*
 * @author Yash Pandey
 */
package in.co.rays.project0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.project0.dto.BaseDTO;
import in.co.rays.project0.dto.StudentDTO;
import in.co.rays.project0.util.Util;

/**
 * The Class StudentForm.
 */
public class StudentForm extends BaseForm{
 
	/** The first name. */
	@NotEmpty
	private String firstName;
	
	/** The last name. */
	@NotEmpty
	private String lastName;
	
	/** The dob. */
	@NotEmpty
	private String dob;
	
	/** The mobile no. */
	@NotEmpty
    @Pattern(regexp = "\\d{10}", message = "{Pattern.form.phoneNo}")
	private String mobileNo;
	
	/** The email. */
	@NotEmpty
	private String email;
    
    /** The college id. */
    @Min(value=1,message="{Min.form.collegeId}")
	private long collegeId;

	/** The college name. */
	private String collegeName;
	
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
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
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
	
	/* (non-Javadoc)
	 * @see in.co.rays.project_0.form.BaseForm#getDto()
	 */
	
	@Override
	public BaseDTO getdto(){
		StudentDTO dto=new StudentDTO();
		dto.setFirstname(firstName);
		dto.setLastname(lastName);
		dto.setMobileno(mobileNo);
		dto.setCollegeid(collegeId);
		if(dob!=""){
			dto.setDob(Util.getDate(dob));
			
		}
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
		dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
		dto.setCollegename(collegeName);
		dto.setEmailid(email);
		return dto;
		
	}
	
	/* (non-Javadoc)
	 * @see in.co.rays.project_0.form.BaseForm#populate(in.co.rays.project_0.dto.BaseDTO)
	 */
	
	@Override
	public void populate(BaseDTO bdto){
        StudentDTO dto = (StudentDTO) bdto;
        id = dto.getId();
        firstName = dto.getFirstname();
        lastName = dto.getLastname();
        dob = Util.getDate(dto.getDob());
        mobileNo = dto.getMobileno();
        email = dto.getEmailid();
        collegeId = dto.getCollegeid();
        firstName=dto.getFirstname();
        lastName=dto.getLastname();
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
