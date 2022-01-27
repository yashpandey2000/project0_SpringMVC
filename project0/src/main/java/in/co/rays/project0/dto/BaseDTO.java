/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.dto;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 *The Class BaseDTO.
 */
@MappedSuperclass
public abstract class BaseDTO implements Serializable,Comparable<BaseDTO>,DropdownList {

	
/** The id. */
@Id
@GenericGenerator(name="hiIncrement",strategy="increment")
@GeneratedValue(generator="hiIncrement")
@Column(name="ID",unique=true,nullable=false)
protected long id;

/**
 * Gets the id.
 *
 * @return the id
 */
public long getId() {
	return id;
}

/**
 * Sets the id.
 *
 * @param id the new id
 */
public void setId(long id) {
	this.id = id;
}

/**
 * Gets the created by.
 *
 * @return the created by
 */
public String getCreatedBy() {
	return createdBy;
}

/**
 * Sets the created by.
 *
 * @param createdBy the new created by
 */
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}

/**
 * Gets the modified by.
 *
 * @return the modified by
 */
public String getModifiedBy() {
	return modifiedBy;
}

/**
 * Sets the modified by.
 *
 * @param modifiedBy the new modified by
 */
public void setModifiedBy(String modifiedBy) {
	this.modifiedBy = modifiedBy;
}

/**
 * Gets the created date time.
 *
 * @return the created date time
 */
public Timestamp getCreatedDateTime() {
	return createdDateTime;
}

/**
 * Sets the created date time.
 *
 * @param createdDateTime the new created date time
 */
public void setCreatedDateTime(Timestamp createdDateTime) {
	this.createdDateTime = createdDateTime;
}

/**
 * Gets the modified date time.
 *
 * @return the modified date time
 */
public Timestamp getModifiedDateTime() {
	return modifiedDateTime;
}

/**
 * Sets the modified date time.
 *
 * @param modifiedDateTime the new modified date time
 */
public void setModifiedDateTime(Timestamp modifiedDateTime) {
	this.modifiedDateTime = modifiedDateTime;
}

/** The created by. */
@Column(name="CREATED_BY",length=50)
protected String createdBy;

/** The modified by. */
@Column(name="MODIFIED_BY",length=50)
protected String modifiedBy;

/** The created date time. */
@Column(name="CREATED_DATE_TIME")
protected Timestamp createdDateTime;

/** The modified date time. */
@Column(name="MODIFIED_DATE_TIME")
protected Timestamp modifiedDateTime;
}
