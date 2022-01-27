/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.service;

import java.util.List;

import in.co.rays.project0.dto.CourseDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
/**
 * The Interface CourseServiceInt.
 */
public interface CourseServiceInt {

	/**
	 * Adds the.
	 *
	 * @param dto the dto
	 * @return the long
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public long add(CourseDTO dto) throws DuplicateRecordException;
	/**
	 * Update.
	 *
	 * @param dto the dto
	 * @throws DuplicateRecordException the duplicate record exception
	 */

	public void update(CourseDTO dto)throws DuplicateRecordException;

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	public void delete(long id);
	/**
	 * Find by name.
	 *
	 * @param CourseName the course name
	 * @return the course DTO
	 */

	public CourseDTO findbyname(String CourseName);
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the course DTO
	 */

	public CourseDTO findbypk(Long pk);

	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List search(CourseDTO dto);
	
	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @param pageNo the page no
	 * @param pageSize the page size
	 * @return the list
	 */
	public List search(CourseDTO dto, int pageNo, int pageSize);

}
