/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class RoleDTO.
 */
@Entity
@Table(name = "ST_ROLE")
public class RoleDTO extends BaseDTO {

	
	/** The Constant ADMIN. */
	public static final int ADMIN = 1;
    
    /** The Constant STUDENT. */
    public static final int STUDENT = 2;
    
    /** The Constant COLLEGE. */
    public static final int COLLEGE = 3;

    /** The role name. */
    @Column(name = "ROLE_NAME", length = 50)
    private String roleName;

    /** The description. */
    @Column(name = "DESCRIPTION", length = 70)
    private String description;

	/**
	 * Gets the role name.
	 *
	 * @return the role name
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * Sets the role name.
	 *
	 * @param roleName the new role name
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
		return roleName;
	}

}
