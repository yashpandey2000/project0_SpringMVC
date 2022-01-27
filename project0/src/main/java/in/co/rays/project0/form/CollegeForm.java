/*
 * @author Yash Pandey
 */
package in.co.rays.project0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.project0.dto.BaseDTO;
import in.co.rays.project0.dto.CollegeDTO;

public class CollegeForm extends BaseForm{
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String address;
	
	@NotEmpty
	private String city;
	
	@NotEmpty
	private String state;
	
	@NotNull
    @Pattern(regexp = "\\d{10}")
	private String mobileNo;
	
	private String message;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public BaseDTO getdto(){
		 CollegeDTO dto = new CollegeDTO();
	        dto.setId(id);
	        dto.setName(name);
	        dto.setAddress(address);
	        dto.setCity(city);
	        dto.setState(state);
	        dto.setPhoneno(mobileNo);
	        dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
	        dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
		
		return dto;
		
	}
	
	@Override
	public void populate(BaseDTO bDto){
		 CollegeDTO dto = (CollegeDTO) bDto;
		 id = dto.getId();
	        name = dto.getName();
	        address = dto.getAddress();
	        city = dto.getCity();
	        state = dto.getState();
	        mobileNo = dto.getPhoneno(); 
	        
	        if(dto.getCreatedDateTime()!=null)
	            createdDateTime = dto.getCreatedDateTime().getTime();
	            
	            if(dto.getModifiedDateTime()!=null)
	            modifiedDateTime = dto.getModifiedDateTime().getTime();
		 
	}

}
