/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.service;

import java.util.List;

import in.co.rays.project0.dto.MarksheetDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
/**
 * The Interface MarksheetServiceInt.
 */
public interface MarksheetServiceInt {
	
	/**
	 * Adds the.
	 *
	 * @param dto the dto
	 * @return the long
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public long add(MarksheetDTO dto)throws DuplicateRecordException;
	/**
	 * Update.
	 *
	 * @param dto the dto
	 */
	public void update(MarksheetDTO dto);
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
	 * @return the marksheet DTO
	 */
	public MarksheetDTO findbypk(long pk);
	/**
	 * Find by roll no.
	 *
	 * @param rollNo the roll no
	 * @return the marksheet DTO
	 */
	public MarksheetDTO findbyrollno(String rollNo);
	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @param pageNo the page no
	 * @param pageSize the page size
	 * @return the list
	 */
	public List search(MarksheetDTO dto,int pageNo,int pageSize);
	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List search(MarksheetDTO dto);
	 /**
     * Gets the merit list.
     *
     * @param pageNo the page no
     * @param pageSize the page size
     * @return the merit list
     */
	 public List getMeritList(int pageNo, int pageSize);

}
