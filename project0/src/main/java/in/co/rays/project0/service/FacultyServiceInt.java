/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.service;

import java.util.List;

import in.co.rays.project0.dto.FacultyDTO;
import in.co.rays.project0.exception.DuplicateRecordException;

/**
 * The Interface FacultyServiceInt.
 */
public interface FacultyServiceInt {
	/**
	 * Adds the.
	 *
	 * @param dto the dto
	 * @return the long
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public long add(FacultyDTO dto)throws DuplicateRecordException;

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
	 * Find by pk.
	 *
	 * @param pk the pk
	 * @return the faculty DTO
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
	public List search(FacultyDTO dto,int pageNo,int pageSize);
	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List search(FacultyDTO dto);
}
