/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.dao;

import java.util.List;

import in.co.rays.project0.dto.TimetableDTO;

public interface TimetableDAOInt {
	

	/**
	 * Adds the.
	 *
	 * @param dto the dto
	 * @return the long
	 */
	public long add(TimetableDTO dto);
	
	/**
	 * Check by semester.
	 *
	 * @param dto the dto
	 * @return the timetable DTO
	 */
	public TimetableDTO checkbysemester(TimetableDTO dto);
	
	/**
	 * Check by course.
	 *
	 * @param dto the dto
	 * @return the timetable DTO
	 */
	public TimetableDTO checkbycourse(TimetableDTO dto);
	
	/**
	 * Check by subject.
	 *
	 * @param dto the dto
	 * @return the timetable DTO
	 */
	public TimetableDTO checkbysubject(TimetableDTO dto);
	
	/**
	 * Update.
	 *
	 * @param dto the dto
	 */
	public void update(TimetableDTO dto);
	
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
	 * @return the timetable DTO
	 */
	public TimetableDTO findbyname(String name);
	
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
	public List search(TimetableDTO dto, int pageNo, int pageSize);

}
