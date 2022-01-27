/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.dao;

import java.util.List;

import in.co.rays.project0.dto.SubjectDTO;

public interface SubjectDAOInt {
	
	/**
	 * Adds the.
	 *
	 * @param dto the dto
	 * @return the long
	 */
	public long add(SubjectDTO dto);

	/**
	 * Update.
	 *
	 * @param dto the dto
	 */
	public void update(SubjectDTO dto);
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	public void delete(long id);

	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the subject DTO
	 */
	public SubjectDTO findbyname(String name);
	
	/**
	 * Find by PK.
	 *
	 * @param pk the pk
	 * @return the subject DTO
	 */
	public SubjectDTO findbypk(long pk);
	
	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @param pageNo the page no
	 * @param pageSize the page size
	 * @return the list
	 */
	public List search(SubjectDTO dto, int pageNo, int pageSize);
	
	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List search(SubjectDTO dto);
	

}
