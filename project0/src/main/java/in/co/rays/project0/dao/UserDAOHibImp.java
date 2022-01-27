/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.rays.project0.dto.UserDTO;
/**
 * The Class UserDAOHibImpl.
 */
@Repository(value="userDao")
public class UserDAOHibImp implements UserDAOInt {

	/** The log. */
	private static Logger log = Logger.getLogger(UserDAOHibImp.class);
	
	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory = null;
	
	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.UserDAOInt#add(in.co.rays.project_0.dto.UserDTO)
	 */
	public long add(UserDTO dto) {
		// TODO Auto-generated method stub
		log.debug("User Dao Add Started");
		long pk = 0;
		pk = (Long) sessionFactory.getCurrentSession().save(dto);
		log.debug("User Dao Add End");
		return pk;
	}

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.UserDAOInt#update(in.co.rays.project_0.dto.UserDTO)
	 */
	public void update(UserDTO dto) {
		// TODO Auto-generated method stub
		log.debug("User Dao Update Started");
		sessionFactory.getCurrentSession().update(dto);
	     log.debug("User Dao Update End");
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.UserDAOInt#delete(long)
	 */
	public void delete(long id) {
		// TODO Auto-generated method stub
		log.debug("User Dao Delete Started");
		UserDTO dto  = findbypk(id);
        sessionFactory.getCurrentSession().delete(dto);
        log.debug("User Dao Delete End");
	}

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.UserDAOInt#findByLogin(java.lang.String)
	 */
	public UserDTO findbylogin(String login) {
		// TODO Auto-generated method stub
		log.debug("User Dao findbylogin Started");
		UserDTO dto = null;
		List list = sessionFactory.getCurrentSession().createCriteria(UserDTO.class).add(Restrictions.eq("login",login)).list();
		if(list.size()==1){
			dto = (UserDTO) list.get(0);
		}
		
		return dto;
	}

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.UserDAOInt#findByPK(long)
	 */
	public UserDTO findbypk(long pk) {
		// TODO Auto-generated method stub
		UserDTO dto = null;
		dto = (UserDTO) sessionFactory.getCurrentSession().get(UserDTO.class, pk);
		return dto;
	}

	

	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.UserDAOInt#search(in.co.rays.project_0.dto.UserDTO, int, int)
	 */
	public List search(UserDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserDTO.class);
		if(dto!=null){
			if(dto.getId()>0){
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if(dto.getFirstname()!=null&&dto.getFirstname().length()>0){
				criteria.add(Restrictions.like("firstname", dto.getFirstname()+"%"));
			}
			if(dto.getLastname()!=null&&dto.getLastname().length()>0){
				criteria.add(Restrictions.like("lastname", dto.getLastname()+"%"));
			}
			
		}
		
		if(pageSize>0){
			criteria.setFirstResult((pageNo-1)*pageSize);
		    criteria.setMaxResults(pageSize);
		}
		
		List list = criteria.list();
		
		return list;
	}

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.UserDAOInt#search(in.co.rays.project_0.dto.UserDTO)
	 */
	public List search(UserDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}
	
	
	
	

}
