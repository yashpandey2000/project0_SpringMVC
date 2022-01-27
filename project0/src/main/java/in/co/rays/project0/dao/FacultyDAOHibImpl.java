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

import in.co.rays.project0.dto.FacultyDTO;

/**
 * The Class FacultyDAOHibImpl.
 */

@Repository(value = "facultyDao")

public class FacultyDAOHibImpl implements FacultyDAOInt{

	private static Logger log = Logger.getLogger(FacultyDAOHibImpl.class);
	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory = null;
	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.FacultyDAOInt#add(in.co.rays.project_0.dto.FacultyDTO)
	 */
	
	public long add(FacultyDTO dto) {
		// TODO Auto-generated method stub
		long pk = 0 ;
		pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.FacultyDAOInt#update(in.co.rays.project_0.dto.FacultyDTO)
	 */
	
	public void update(FacultyDTO dto) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(dto);
		
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.FacultyDAOInt#delete(long)
	 */
	public void delete(long id) {
		// TODO Auto-generated method stub
		
		FacultyDTO dto = findbypk(id);
		sessionFactory.getCurrentSession().delete(dto);
		
	}


	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.FacultyDAOInt#findByPK(long)
	 */
	
	public FacultyDTO findbypk(long pk) {
		// TODO Auto-generated method stub
		FacultyDTO dto = (FacultyDTO) sessionFactory.getCurrentSession().get(FacultyDTO.class, pk);
		return dto;
	}

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.FacultyDAOInt#findByEmail(java.lang.String)
	 */
	public FacultyDTO findbyemail(String email) {
		// TODO Auto-generated method stub
		FacultyDTO dto = null;
		List list = sessionFactory.getCurrentSession().createCriteria(FacultyDTO.class).add(Restrictions.like("emailid", email)).list();
		if(list.size()>0){
			dto = (FacultyDTO) list.get(0);
		}
		
		return dto;
	}
	

	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.FacultyDAOInt#search(in.co.rays.project_0.dto.FacultyDTO, int, int)
	 */

	public List search(FacultyDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(FacultyDTO.class);
		if(dto!=null){
			if(dto.getId()>0){
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if(dto.getFirstname()!=null && dto.getFirstname().length()>0){
				criteria.add(Restrictions.like("firstname", dto.getFirstname()+"%"));
			}
			if(dto.getLastname()!=null && dto.getLastname().length()>0){
				criteria.add(Restrictions.like("lastname",dto.getLastname()+"%"));
			}
			if(dto.getEmailid()!=null && dto.getEmailid().length()>0){
				
				criteria.add(Restrictions.like("emailid", dto.getEmailid()+"%"));
			}
			if(dto.getCollegeid()>0){
				criteria.add(Restrictions.eq("courseid", dto.getCollegeid()));
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
	 * @see in.co.rays.project0.dao.FacultyDAOInt#search(in.co.rays.project_0.dto.FacultyDTO)
	 */
	
	public List search(FacultyDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

}
