/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.dao;

import java.util.List;

import in.co.rays.project0.dto.CollegeDTO;

/**
 * The Interface CollegeDAOInt.
 */

public interface CollegeDAOInt {
	
	
	/**
	 * Adds the.
	 *
	 * @param dto the dto
	 * @return the long
	 */
	public long add(CollegeDTO dto);

	/**
	 * Update.
	 *
	 * @param dto the dto
	 */
	public void update(CollegeDTO dto);
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
	 * @return the college DTO
	 */
	public CollegeDTO findbyname(String name);
	/**
	 * Find by PK.
	 *
	 * @param pk the pk
	 * @return the college DTO
	 */
	public CollegeDTO findbypk(long pk);
	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @param pageNo the page no
	 * @param pageSize the page size
	 * @return the list
	 */
	public List search(CollegeDTO dto , int pageNo , int pageSize);
	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List search(CollegeDTO dto);
}
