/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.dao;

import java.util.List;

import in.co.rays.project0.dto.RoleDTO;

/**
 * The Interface RoleDAOInt.
 */

public interface RoleDAOInt {

	/**
	 * Adds the.
	 *
	 * @param dto the dto
	 * @return the long
	 */
	public long add(RoleDTO dto);
	
	/**
	 * Update.
	 *
	 * @param dto the dto
	 */
	public void update(RoleDTO dto);
	
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
	 * Find by PK.
	 *
	 * @param pk the pk
	 * @return the role DTO
	 */
	public RoleDTO findByPK(long pk);
	
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
	public  List search(RoleDTO dto);
	
}
