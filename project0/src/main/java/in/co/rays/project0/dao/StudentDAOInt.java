/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.dao;

import java.util.List;

import in.co.rays.project0.dto.StudentDTO;

public interface StudentDAOInt {
	
	/**
	 * Adds the.
	 *
	 * @param dto the dto
	 * @return the long
	 */
	public long add(StudentDTO dto);

	/**
	 * Update.
	 *
	 * @param dto the dto
	 */
	public void update(StudentDTO dto);

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	public void delete(long id);

	/**
	 * Find by email.
	 *
	 * @param email the email
	 * @return the student DTO
	 */
	public StudentDTO findbyemail(String email);

	/**
	 * Find by PK.
	 *
	 * @param pk the pk
	 * @return the student DTO
	 */
	public StudentDTO findbypk(long pk);

	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @param pageNo the page no
	 * @param pageSize the page size
	 * @return the list
	 */
	public List search(StudentDTO dto, int pageNo, int pageSize);

	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List search(StudentDTO dto);

}
