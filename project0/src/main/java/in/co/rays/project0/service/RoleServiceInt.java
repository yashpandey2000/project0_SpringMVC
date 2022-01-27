/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.service;

import java.util.List;

import in.co.rays.project0.dto.RoleDTO;
import in.co.rays.project0.exception.DuplicateRecordException;

/**
 * The Interface RoleServiceInt.
 */
public interface RoleServiceInt {
	
	/**
	 * Adds the.
	 *
	 * @param dto the dto
	 * @return the long
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public long add(RoleDTO dto) throws DuplicateRecordException;

	/**
	 * Update.
	 *
	 * @param dto the dto
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public void update(RoleDTO dto)throws DuplicateRecordException;
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	public void delete(long id);
	
	/**
	 * Find by name.
	 *
	 * @param roleName the role name
	 * @return the role DTO
	 */
	public RoleDTO findByName(String roleName);
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the role DTO
	 */
	public RoleDTO findByPK(Long id);
	
	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @param pageNo the page no
	 * @param pageSize the page size
	 * @return the list
	 */
	public List search(RoleDTO dto, int pageNo, int pageSize);
	
	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List search(RoleDTO dto);
	

}
