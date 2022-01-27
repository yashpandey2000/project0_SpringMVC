/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.service;

import java.util.List;

import in.co.rays.project0.dto.TimetableDTO;
import in.co.rays.project0.exception.DuplicateRecordException;

/**
 * The Interface TimetableServiceInt.
 */
public interface TimetableServiceInt {
	/**
	 * Adds the.
	 *
	 * @param dto the dto
	 * @return the long
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public long add(TimetableDTO dto)throws DuplicateRecordException;
	/**
	 * Update.
	 *
	 * @param dto the dto
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public void update(TimetableDTO dto) throws DuplicateRecordException;

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
	 * @return the timetable DTO
	 */
	public TimetableDTO findbypk(long pk);
	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List search(TimetableDTO dto);
	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @param pageNo the page no
	 * @param pageSize the page size
	 * @return the list
	 */
	public List search(TimetableDTO dto,int pageNo,int pageSize);
	
}

