/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.dao;

import java.util.List;

import javax.print.DocFlavor.READER;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.rays.project0.dto.FacultyDTO;
import in.co.rays.project0.dto.SubjectDTO;


/**
 * The Class SubjectDAOHibImpl.
 */
@Repository(value="subjectDao")
public class SubjectDAOHibImpl implements SubjectDAOInt {

	/** The log. */
	private static Logger log = Logger.getLogger(SubjectDAOHibImpl.class);
	
	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory = null;
	
	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.SubjectDAOInt#add(in.co.rays.project_0.dto.SubjectDTO)
	 */
	public long add(SubjectDTO dto) {
		// TODO Auto-generated method stub
		log.debug("subject Dao Add Started");
		long pk = 0;
		pk = (Long) sessionFactory.getCurrentSession().save(dto);
		log.debug("subject Dao Add ended");
		return pk;
	}
	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.SubjectDAOInt#update(in.co.rays.project_0.dto.SubjectDTO)
	 */

	public void update(SubjectDTO dto) {
		// TODO Auto-generated method stub
		log.debug("subject Dao update Started");
		sessionFactory.getCurrentSession().update(dto);
		log.debug("subject Dao update ended");	
	}

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.SubjectDAOInt#delete(long)
	 */
	public void delete(long id) {
		// TODO Auto-generated method stub
		log.debug("subject Dao delete Started");
		SubjectDTO dto = findbypk(id);
		sessionFactory.getCurrentSession().delete(dto);
		log.debug("subject Dao delete ended");	
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.SubjectDAOInt#findByName(java.lang.String)
	 */
	
	public SubjectDTO findbyname(String name) {
		// TODO Auto-generated method stub
		log.debug("subject Dao findByName Started");
		SubjectDTO dto = null;
	List list = sessionFactory.getCurrentSession().createCriteria(SubjectDTO.class).add(Restrictions.like("name", name)).list();
		
	if(list.size()>0){
		dto = (SubjectDTO) list.get(0);
	}
	
	log.debug("subject Dao findByName ended");
		return dto;
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.SubjectDAOInt#findByPK(long)
	 */
	public SubjectDTO findbypk(long pk) {
		// TODO Auto-generated method stub
		log.debug("subject Dao findBypk Started");
		SubjectDTO  dto = (SubjectDTO) sessionFactory.getCurrentSession().get(SubjectDTO.class, pk);
		log.debug("subject Dao findBypk ended");
		return dto;
	}

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.SubjectDAOInt#search(in.co.rays.project_0.dto.SubjectDTO, int, int)
	 */
	public List search(SubjectDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.debug("subject Dao search Started");
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SubjectDTO.class);
		if(dto!=null){
			
			if(dto.getId()>0){
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			
			if(dto.getCourseid()>0){
				criteria.add(Restrictions.eq("courseid", dto.getCourseid()));
			}
			
			if(dto.getName()!=null && dto.getName().length()>0){
				criteria.add(Restrictions.like("name",dto.getName()+"%"));
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
	 * @see in.co.rays.project0.dao.SubjectDAOInt#search(in.co.rays.project_0.dto.SubjectDTO)
	 */
	
	public List search(SubjectDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

}
