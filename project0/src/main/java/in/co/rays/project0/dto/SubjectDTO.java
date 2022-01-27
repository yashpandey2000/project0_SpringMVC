/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * The Class SubjectDTO.
 */

@Entity
@Table(name="st_subject")
public class SubjectDTO extends BaseDTO{
	
	/** The name. */
	@Column(name="NAME" , length=50)
	private String name;
	/** The course id. */
	@Column(name="COURSE_ID" , length=50)
	private long courseid;
	/** The course name. */
	@Column(name="COURSE_NAME" , length=50)
	private String coursename;
	/** The description. */
	@Column(name="DESCRIPTION" , length=50)
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
		return name;
	}
	
	
	

}
