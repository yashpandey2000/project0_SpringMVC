/*
 * @author Yash Pandey
 */
package in.co.rays.project0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.project0.dto.BaseDTO;
import in.co.rays.project0.dto.MarksheetDTO;

/**
 * The Class MarksheetForm.
 */
public class MarksheetForm extends BaseForm {
	
	/** The roll no. */
	@NotEmpty
	private String rollNo;
	
	/** The name. */
	private String name;
	
	/** The student id. */
	@Min(value = 1, message = ("Min.form.studentId"))
	private long studentId;
	
	/** The physics. */
	@NotNull
	@Min(0)
	@Max(100)
	private Integer physics;
	
	/** The chemistry. */
	@NotNull
	@Min(0)
	@Max(100)
	private Integer chemistry;

	/** The maths. */
	@NotNull
	@Min(0)
	@Max(100)

	private Integer maths;

	/**
	 * Gets the roll no.
	 *
	 * @return the roll no
	 */
	public String getRollNo() {
		return rollNo;
	}

	/**
	 * Sets the roll no.
	 *
	 * @param rollNo the new roll no
	 */
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

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
	 * Gets the student id.
	 *
	 * @return the student id
	 */
	public long getStudentId() {
		return studentId;
	}

	/**
	 * Sets the student id.
	 *
	 * @param studentId the new student id
	 */
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	/**
	 * Gets the physics.
	 *
	 * @return the physics
	 */
	public Integer getPhysics() {
		return physics;
	}

	/**
	 * Sets the physics.
	 *
	 * @param physics the new physics
	 */
	public void setPhysics(Integer physics) {
		this.physics = physics;
	}

	/**
	 * Gets the chemistry.
	 *
	 * @return the chemistry
	 */
	public Integer getChemistry() {
		return chemistry;
	}

	/**
	 * Sets the chemistry.
	 *
	 * @param chemistry the new chemistry
	 */
	public void setChemistry(Integer chemistry) {
		this.chemistry = chemistry;
	}

	/**
	 * Gets the maths.
	 *
	 * @return the maths
	 */
	public Integer getMaths() {
		return maths;
	}

	/**
	 * Sets the maths.
	 *
	 * @param maths the new maths
	 */
	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project_0.form.BaseForm#getDto()
	 */
	@Override
	public BaseDTO getdto() {

		MarksheetDTO dto = new MarksheetDTO();
		System.out.println("Marksheet Form getDTO Student id--->" + id);
		System.out.println("Marksheet Form getDTO Student name--->" + name);

		dto.setId(id);
		dto.setRollno(rollNo);
		dto.setStudentid(studentId);
		dto.setName(name);
		dto.setMaths(maths);
		dto.setChemistry(chemistry);
		dto.setPhysics(physics);
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
	public void populate(BaseDTO bDto) {

		MarksheetDTO dto = (MarksheetDTO) bDto;

		id = dto.getId();
		rollNo = dto.getRollno();
		studentId = dto.getStudentid();
		name = dto.getName();
		maths = dto.getMaths();
		chemistry = dto.getChemistry();
		physics = dto.getPhysics();
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
