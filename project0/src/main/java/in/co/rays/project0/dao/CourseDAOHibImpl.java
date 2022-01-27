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

import in.co.rays.project0.dto.CourseDTO;
/**
 * The Class CourseDAOHibImpl.
 */
@Repository(value="courseDao")
public class CourseDAOHibImpl implements CourseDAOInt{
	
	/** The log. */
	private static Logger log = Logger.getLogger(CourseDAOHibImpl.class);
	
	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory = null;

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.CourseDAOInt#add(in.co.rays.project_0.dto.CourseDTO)
	 */
	
	public long add(CourseDTO dto) {
		// TODO Auto-generated method stub
		log.debug("Course Dao Add Started");
		long pk = 0;
		pk = (Long) sessionFactory.getCurrentSession().save(dto);
		log.debug("Course Dao Add ended");
		return pk;
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.CourseDAOInt#update(in.co.rays.project_0.dto.CourseDTO)
	 */
	public void update(CourseDTO dto) {
		// TODO Auto-generated method stub
		log.debug("course Dao Update Started");
		sessionFactory.getCurrentSession().update(dto);
		log.debug("course Dao Update End");
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.CourseDAOInt#delete(long)
	 */
	public void delete(long id) {
		// TODO Auto-generated method stub
		log.debug("course Dao Delete Started");
		CourseDTO dto = findbypk(id);
		sessionFactory.getCurrentSession().delete(dto);
		log.debug("course Dao Delete End");
	}

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.CourseDAOInt#findByName(java.lang.String)
	 */
	public CourseDTO findbyname(String name) {
		// TODO Auto-generated method stub
		log.debug("coure Dao FindByname Started");
		CourseDTO dto = null;
		List list = sessionFactory.getCurrentSession().createCriteria(CourseDTO.class).add(Restrictions.like("name", name)).list();
		if(list.size()>0){
			dto = (CourseDTO) list.get(0);
		}
		log.debug("coure Dao FindByname Started");
		return dto;
	}
	
	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.CourseDAOInt#findByPK(long)
	 */

	public CourseDTO findbypk(long pk) {
		// TODO Auto-generated method stub
		log.debug("course Dao FindByLogin Started");
		CourseDTO dto = null;
		dto = (CourseDTO) sessionFactory.getCurrentSession().get(CourseDTO.class, pk);
		log.debug("course Dao FindByLogin ended");
		return dto;
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.CourseDAOInt#search(in.co.rays.project_0.dto.CourseDTO, int, int)
	 */
	public List search(CourseDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.debug("User Dao search Started");
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CourseDTO.class);
		if(dto!=null){
			if(dto.getId()>0){
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			
			if(dto.getDuration()!=null && dto.getDuration().length()>0){
				criteria.add(Restrictions.like("duration",dto.getDuration()+"%"));
			}
			
		}
		
		if(pageSize>0){
			criteria.setFirstResult((pageNo-1)*pageSize);
			criteria.setMaxResults(pageSize);
		}
		
	List list = criteria.list();
	
	log.debug("course Dao search ended");
		return list;
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.CourseDAOInt#search(in.co.rays.project_0.dto.CourseDTO)
	 */
	public List search(CourseDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	

	

	
}
