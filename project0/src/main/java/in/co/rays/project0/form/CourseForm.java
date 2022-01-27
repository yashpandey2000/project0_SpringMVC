/*
 * @author Yash Pandey
 */
package in.co.rays.project0.form;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.project0.dto.BaseDTO;
import in.co.rays.project0.dto.CourseDTO;

public class CourseForm extends BaseForm{
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String description;
	
	@NotEmpty
	private String duration;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	@Override
	public BaseDTO getdto(){
		CourseDTO dto = new CourseDTO();
		dto.setId(id);
    	dto.setName(name);
    	dto.setDuration(duration);
        dto.setDescription(description);
        dto.setCreatedBy(createdBy);
        dto.setModifiedBy(modifiedBy);
        dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
        dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
    	return dto;
		
	}
	
	@Override
	public void populate(BaseDTO bDto){
		 CourseDTO dto=(CourseDTO) bDto;
		 id=dto.getId();
   	  name=dto.getName();
   	  duration=dto.getDuration();
   	  description=dto.getDescription();
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
