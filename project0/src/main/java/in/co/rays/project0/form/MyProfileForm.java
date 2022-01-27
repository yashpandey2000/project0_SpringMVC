/*
 * @author Yash Pandey
 */
package in.co.rays.project0.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.project0.dto.BaseDTO;
import in.co.rays.project0.dto.UserDTO;
import in.co.rays.project0.util.Util;

/**
 * The Class MyProfileForm.
 */
public class MyProfileForm extends BaseForm {

	/** The first name. */
	@NotEmpty
	private String firstName;
	
	/** The last name. */
	@NotEmpty
	private String lastName;
	
	/** The gender. */
	@NotEmpty
	private String gender;
	
	/** The dob. */
	@NotEmpty
	private String dob;
	
	/** The mobile no. */
	@NotEmpty
	@Pattern(regexp = "^[6-9][0-9]{9}$", message = "{Pattern.password}")
	private String mobileNo;
	
	/** The login. */
	@NotEmpty
	@Pattern(regexp = "^[_A-Za-z0-9-]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "{Email.form.emailId}")
	private String login;
	
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
        dto.setDob(Util.getDate(dob));
        dto.setMobileno(mobileNo);
        dto.setGender(gender);
      
        return dto;
    }

    /* (non-Javadoc)
     * @see in.co.rays.project_0.form.BaseForm#populate(in.co.rays.project_0.dto.BaseDTO)
     */
    @Override
    public void populate(BaseDTO bDto) {
        UserDTO dto = (UserDTO) bDto;
        System.out.println("in populate----<<<"+dto.getGender());
        id = dto.getId();
        firstName = dto.getFirstname();
        lastName = dto.getLastname();
        login = dto.getLogin();
        dob = Util.getDate(dto.getDob());
        mobileNo = dto.getMobileno();
        gender = dto.getGender();
        
        super.populate(bDto);
    }

	
}
