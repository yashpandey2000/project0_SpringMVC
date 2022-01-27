/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.service;

import java.util.List;

import in.co.rays.project0.dto.SubjectDTO;
import in.co.rays.project0.exception.DuplicateRecordException;

/**
 * The Interface SubjectServiceInt.
 */
public interface SubjectServiceInt {
	
	/**
	 * Adds the.
	 *
	 * @param dto the dto
	 * @return the long
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public long add(SubjectDTO dto) throws DuplicateRecordException;

	/**
	 * Update.
	 *
	 * @param dto the dto
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public void update(SubjectDTO dto)throws DuplicateRecordException;
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	public void delete(long id);
	
	/**
	 * Find by name.
	 *
	 * @param SubjectName the subject name
	 * @return the subject DTO
	 */
	public SubjectDTO findbyname(String SubjectName);
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the subject DTO
	 */
	public SubjectDTO findbypk(Long pk);
	
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
