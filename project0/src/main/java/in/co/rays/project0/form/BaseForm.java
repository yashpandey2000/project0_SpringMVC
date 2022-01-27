/*
 * @author Yash Pandey
 */
package in.co.rays.project0.form;

import in.co.rays.project0.dto.BaseDTO;

/**
 * The Class BaseForm.
 */
public class BaseForm {

	/** The id. */
	protected long id=0;
	
	/** The page no. */
	private int pageNo=1;
	
	/** The chk 1. */
	private Long[] chk_1;
	
	/** The page size. */
	private int pageSize=5;
	
	/** The operation. */
	private String operation;
	
	/** The created by. */
	protected String createdBy;
	
	/** The modified by. */
	protected String modifiedBy;
	
	/** The created date time. */
	protected long createdDateTime;
	
	/** The modified date time. */
	protected long modifiedDateTime;
	
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
	 * Gets the page no.
	 *
	 * @return the page no
	 */
	public int getPageNo() {
		return pageNo;
	}
	
	/**
	 * Sets the page no.
	 *
	 * @param pageNo the new page no
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Gets the chk 1.
	 *
	 * @return the chk 1
	 */
	public Long[] getChk_1() {
		return chk_1;
	}
	
	/**
	 * Sets the chk 1.
	 *
	 * @param chk_1 the new chk 1
	 */
	public void setChk_1(Long[] chk_1) {
		this.chk_1 = chk_1;
	}
	
	/**
	 * Gets the page size.
	 *
	 * @return the page size
	 */
	public int getPageSize() {
		return pageSize;
	}
	
	/**
	 * Sets the page size.
	 *
	 * @param pageSize the new page size
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * Gets the operation.
	 *
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}
	
	/**
	 * Sets the operation.
	 *
	 * @param operation the new operation
	 */
	public void setOperation(String operation) {
		this.operation = operation;
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
	public long getCreatedDateTime() {
		return createdDateTime;
	}
	
	/**
	 * Sets the created date time.
	 *
	 * @param createdDateTime the new created date time
	 */
	public void setCreatedDateTime(long createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	
	/**
	 * Gets the modified date time.
	 *
	 * @return the modified date time
	 */
	public long getModifiedDateTime() {
		return modifiedDateTime;
	}
	
	/**
	 * Sets the modified date time.
	 *
	 * @param modifiedDateTime the new modified date time
	 */
	public void setModifiedDateTime(long modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}
	
	/**
	 * Gets the dto.
	 *
	 * @return the dto
	 */
	public BaseDTO getdto(){
		return null;
	}
	
	/**
	 * Populate.
	 *
	 * @param dto the dto
	 */
	public void populate(BaseDTO dto){
		
	}
}
