/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.dao;

import java.util.List;

import in.co.rays.project0.dto.CollegeDTO;
import in.co.rays.project0.dto.CourseDTO;

public interface CourseDAOInt {

	/**
	 * Adds the.
	 *
	 * @param dto the dto
	 * @return the long
	 */
	public long add(CourseDTO dto);
	/**
	 * Update.
	 *
	 * @param dto the dto
	 */
	public void update(CourseDTO dto);
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
	public CourseDTO findbyname(String name);
	/**
	 * Find by PK.
	 *
	 * @param pk the pk
	 * @return the college DTO
	 */
	public CourseDTO findbypk(long pk);

	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @param pageNo the page no
	 * @param pageSize the page size
	 * @return the list
	 */
	public List search(CourseDTO dto , int pageNo , int pageSize);
	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List search(CourseDTO dto);
	
}
