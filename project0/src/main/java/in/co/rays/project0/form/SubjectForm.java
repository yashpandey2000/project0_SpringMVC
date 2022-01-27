/*
 * @author Yash Pandey
 */
package in.co.rays.project0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.project0.dto.BaseDTO;
import in.co.rays.project0.dto.SubjectDTO;

/**
 * The Class SubjectForm.
 */
public class SubjectForm extends BaseForm {
	
	/** The course id. */
	@Min(value = 1, message = "{Min.form.courseId}")
	private long courseId;
	
	/** The course name. */
	private String courseName;
	
	/** The subject name. */
	@NotEmpty
	private String subjectName;
	
	/** The description. */
	@NotEmpty
	private String description;
	
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
	public BaseDTO getdto() {
	SubjectDTO dto=new SubjectDTO();
	System.out.println("in form id"+id);
	dto.setId(id);
	dto.setName(subjectName);
    dto.setCourseid(courseId);
    dto.setDescription(description);
    dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
    dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
	
	return dto;
	}
	
	/* (non-Javadoc)
	 * @see in.co.rays.project_0.form.BaseForm#populate(in.co.rays.project_0.dto.BaseDTO)
	 */
	@Override
	public void populate(BaseDTO bDto) {
	SubjectDTO dto=(SubjectDTO) bDto;
	id=dto.getId();
	subjectName=dto.getName();
	courseId=dto.getCourseid();
	description=dto.getDescription();
	createdBy = dto.getCreatedBy();
    modifiedBy = dto.getModifiedBy();
    if(dto.getCreatedDateTime()!=null)
    createdDateTime = dto.getCreatedDateTime().getTime();
    if(dto.getModifiedDateTime()!=null)
    modifiedDateTime = dto.getModifiedDateTime().getTime();
	}

}
