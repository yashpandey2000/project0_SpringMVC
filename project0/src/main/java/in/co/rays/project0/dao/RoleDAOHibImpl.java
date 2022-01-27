/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.dao;

import java.util.List;


import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import in.co.rays.project0.dto.RoleDTO;

/**
 * The Class RoleDAOHibImpl.
 */
@Repository("roleDAO")
public class RoleDAOHibImpl implements RoleDAOInt{
	
	/** The session factory. */
	@Autowired
	SessionFactory sessionFactory=null;
	
	/** The log. */
	private static Logger log = Logger.getLogger(RoleDAOHibImpl.class);

	/* (non-Javadoc)
	 * @see in.co.rays.project_0.dao.RoleDAOInt#add(in.co.rays.project_0.dto.RoleDTO)
	 */
	public long add(RoleDTO dto) {
		log.debug("Role Dao Add Started");
		System.out.println("Add run success");
		 long pk=(Long)sessionFactory.getCurrentSession().save(dto);
		log.debug("Role Dao Add End");
		
		return pk;
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project_0.dao.RoleDAOInt#update(in.co.rays.project_0.dto.RoleDTO)
	 */
	public void update(RoleDTO dto) {
		log.debug("Role Dao Update Started");
		Session session=sessionFactory.getCurrentSession();
		session.clear();
		sessionFactory.getCurrentSession().update(dto);
		
		log.debug("Role Dao Update End");
		
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project_0.dao.RoleDAOInt#delete(long)
	 */
	public void delete(long id) {
		log.debug("Role Dao Delete Started");
		RoleDTO dto=findByPK(id);
		sessionFactory.getCurrentSession().delete(dto);
		log.debug("Role Dao Delete End");
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project_0.dao.RoleDAOInt#findByName(java.lang.String)
	 */
	public RoleDTO findByName(String roleName) {
		log.debug("Role DAO Find by Name Started");
		RoleDTO dto=null;
		System.out.println("findbyname started");
		List list=sessionFactory.getCurrentSession().createCriteria(RoleDTO.class).add(Restrictions.eq("roleName",roleName)).list();
        System.out.println("list return size"+list.size());
		if(list.size()>0){
        	dto=(RoleDTO)list.get(0);
        }
        System.out.println("dto value"+dto);
        log.debug("Role DAO Find by Name Ended");
		return dto;
	}

	
	
	/* (non-Javadoc)
	 * @see in.co.rays.project_0.dao.RoleDAOInt#search(in.co.rays.project_0.dto.RoleDTO, int, int)
	 */
	public List search(RoleDTO dto, int pageNo, int pageSize) throws DataAccessException {
		log.debug("DAO search Started");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RoleDTO.class);
		//	Criteria criteria=sessionFactory.getCurrentSession().createCriteria(RoleDTO.class);
		if(dto!=null){
			if(dto.getId()>0){
				criteria.add(Restrictions.eq("id",dto.getId()));
			}
			if(dto.getRoleName()!=null&&dto.getRoleName().length()>0){
				criteria.add(Restrictions.like("roleName", dto.getRoleName()+"%"));
			}
		}
		if(pageSize>0){
			criteria.setFirstResult((pageNo-1)*pageSize);
			criteria.setMaxResults(pageSize);
		}
		List list=criteria.list();
		log.debug("DAO search End");
		return list;
	}

	

	/* (non-Javadoc)
	 * @see in.co.rays.project_0.dao.RoleDAOInt#search(in.co.rays.project_0.dto.RoleDTO)
	 */
	public List search(RoleDTO dto) {
		// TODO Auto-generated method stub
		return search(dto,0,0);
	}
	
	
	/* (non-Javadoc)
	 * @see in.co.rays.project_0.dao.RoleDAOInt#findByPK(long)
	 */


	public RoleDTO findByPK(long pk) {
		log.debug("RoleDAO Find by PK Started");
		RoleDTO dto=null;
		dto=(RoleDTO) sessionFactory.getCurrentSession().get(RoleDTO.class,pk);
		log.debug("RoleDAO Find by PK Ended");
		return dto;
	}

	
}

