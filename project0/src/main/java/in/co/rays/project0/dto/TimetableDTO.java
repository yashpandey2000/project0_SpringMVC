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
 * The Class TimetableDTO.
 */
@Entity 
@Table(name="st_timetable")
public class TimetableDTO extends BaseDTO {
	
	
	/** The semester. */
	@Column(name="SEMESTER" , length=50)
	private String semester;
	
	/** The description. */
	@Column(name="DESCRIPTION" , length=100)
	private String description;
	
	/** The exam date. */
	@Column(name="EXAM_DATE" , length=50)
	private Date examdate;
	
	/** The exam time. */
	@Column(name="EXAM_TIME" , length=50)
	private String examtime;
	
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
	 * Gets the semester.
	 *
	 * @return the semester
	 */
	public String getSemester() {
		return semester;
	}
	/**
	 * Sets the semester.
	 *
	 * @param semester the new semester
	 */
	public void setSemester(String semester) {
		this.semester = semester;
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
	
	

	/**
	 * Gets the exam date.
	 *
	 * @return the exam date
	 */
	
	public Date getExamdate() {
		return examdate;
	}
	

	/**
	 * Sets the exam date.
	 *
	 * @param examDate the new exam date
	 */
	public void setExamdate(Date examdate) {
		this.examdate = examdate;
	}
	
	/**
	 * Gets the exam time.
	 *
	 * @return the exam time
	 */
	public String getExamtime() {
		return examtime;
	}
	
	/**
	 * Sets the exam time.
	 *
	 * @param examTime the new exam time
	 */
	public void setExamtime(String examtime) {
		this.examtime = examtime;
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
	 * Gets the subject name.
	 *
	 * @return the subject name
	 */
	
	public String getSubjectname() {
		return subjectname;
	}
	
	/**
	 * Sets the subject name.
	 *
	 * @param subjectName the new subject name
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
		return coursename;
	}
	
	
	
	

}
