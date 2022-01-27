/*
 * @author Yash Pandey
 */
package in.co.rays.project0.form;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.project0.dto.BaseDTO;
import in.co.rays.project0.dto.RoleDTO;

/**
 * The Class RoleForm.
 */
public class RoleForm extends BaseForm {
	
	/** The name. */
	@NotEmpty
	private String name;
	
	/** The description. */
	@NotEmpty
	private String description;
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/* (non-Javadoc)
	 * @see in.co.rays.project_0.form.BaseForm#getDto()
	 */
	@Override
	public BaseDTO getdto(){


        RoleDTO dto = new RoleDTO();
        dto.setId(id);
        dto.setRoleName(name);
        dto.setDescription(description);
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
	public void populate(BaseDTO bdto){
	
		RoleDTO dto=(RoleDTO) bdto;


        id = dto.getId();
        name = dto.getRoleName();
        description = dto.getDescription();
        createdBy = dto.getCreatedBy();
        modifiedBy = dto.getModifiedBy();
        if(dto.getCreatedDateTime()!=null)
        createdDateTime = dto.getCreatedDateTime().getTime();
        if(dto.getModifiedDateTime()!=null)
        modifiedDateTime = dto.getModifiedDateTime().getTime();
    
	}

}
