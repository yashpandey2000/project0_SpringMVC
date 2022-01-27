/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.dao;

import java.util.List;

import in.co.rays.project0.dto.FacultyDTO;

public interface FacultyDAOInt {
	/**
	 * Adds the.
	 *
	 * @param dto the dto
	 * @return the long
	 */
	public long add(FacultyDTO dto);

	/**
	 * Update.
	 *
	 * @param dto the dto
	 */
	public void update(FacultyDTO dto);
	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	public void delete(long id);
	/**
	 * Find by PK.
	 *
	 * @param pk the pk
	 * @return the college DTO
	 */
	public FacultyDTO findbypk(long pk);
	/**
	 * Find by email.
	 *
	 * @param email the email
	 * @return the faculty DTO
	 */
	public FacultyDTO findbyemail(String email);
	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @param pageNo the page no
	 * @param pageSize the page size
	 * @return the list
	 */
	public List search(FacultyDTO dto , int pageNo , int pageSize);
	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List search(FacultyDTO dto);

}
