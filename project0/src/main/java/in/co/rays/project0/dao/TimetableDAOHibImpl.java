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
import org.springframework.stereotype.Repository;

import in.co.rays.project0.dto.TimetableDTO;
@Repository("timetableDAO")
public class TimetableDAOHibImpl implements TimetableDAOInt{

	/** The log. */
	private static Logger log = Logger.getLogger(TimetableDAOHibImpl.class);
	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;
	
	/** The course DAO. */
	@Autowired
	private CourseDAOInt courseDAO;

	/** The subject DAO. */
	@Autowired
	private SubjectDAOInt subjectDAO;
	
	public long add(TimetableDTO dto) {
		// TODO Auto-generated method stub
		log.debug("DAO add Started");
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		log.debug("DAO add ended");
		return pk;
	}

	public TimetableDTO checkbysemester(TimetableDTO dto) {
		// TODO Auto-generated method stub
		log.debug("Check Duplicates");
		TimetableDTO getDTO = null;
		Session session = sessionFactory.getCurrentSession();
		List list= session.createCriteria(TimetableDTO.class)
				.add(Restrictions.eq("courseid", dto.getCourseid()))
				.add(Restrictions.eq("subjectid", dto.getSubjectid()))
				.add(Restrictions.like("semester", dto.getSemester()))
				.add(Restrictions.eq("examdate", dto.getExamdate())).list();
		
		if (list.size() > 0) {
			getDTO = (TimetableDTO) list.get(0);
		}
		log.debug("Check Duplicates");
		return getDTO;
		
	}

	public TimetableDTO checkbycourse(TimetableDTO dto) {
		// TODO Auto-generated method stub
		log.debug("Check Duplicates");
		TimetableDTO dto1=null;
		Session session = sessionFactory.getCurrentSession();
		List list = session.createCriteria(TimetableDTO.class)
		.add(Restrictions.eq("courseid", dto.getCourseid()))
		.add(Restrictions.eq("examdate", dto.getExamdate())).list();
		if (list.size() > 0) {
			dto1 = (TimetableDTO) list.get(0);
		}
		log.debug("Check Duplicates");
		return dto1;
	}

	public TimetableDTO checkbysubject(TimetableDTO dto) {
		// TODO Auto-generated method stub
		log.debug("Check Duplicates");
		TimetableDTO dto1=null;
		Session session = sessionFactory.getCurrentSession();
		List list = session.createCriteria(TimetableDTO.class)
		.add(Restrictions.eq("courseid", dto.getCourseid()))
		.add(Restrictions.eq("subjectid", dto.getSubjectid()))
		.add(Restrictions.eq("examdate", dto.getExamdate())).list();
		 
		if (list.size() > 0) {
			dto1 = (TimetableDTO) list.get(0);
		}
		log.debug("Check Duplicates");
		return dto1;
	}

	public void update(TimetableDTO dto) {
		// TODO Auto-generated method stub
		log.debug("DAO Update Started");
		dto.setCoursename(courseDAO.findbypk(dto.getCourseid()).getName());
		dto.setSubjectname(subjectDAO.findbypk(dto.getSubjectid()).getName());
		sessionFactory.getCurrentSession().update(dto);
		log.debug("DAO Update ended");
		
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		
		log.debug("DAO delete Started");
		TimetableDTO dto = new TimetableDTO();
		dto = findbypk(id);
		sessionFactory.getCurrentSession().delete(dto);
		log.debug("DAO delete ended");
		
	}

	public TimetableDTO findbypk(long pk) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		TimetableDTO dto = (TimetableDTO) session.get(TimetableDTO.class, pk);
		return dto;
	}

	public List search(TimetableDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	public List search(TimetableDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TimetableDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getCourseid() > 0) {
				criteria.add(Restrictions.eq("courseid", dto.getCourseid()));
			}
			if (dto.getSubjectid() > 0) {
				criteria.add(Restrictions.eq("subjectid", dto.getSubjectid()));
			}
			if (dto.getExamdate() != null && dto.getExamdate().getTime() > 0) {
				criteria.add(Restrictions.like("examdate", dto.getExamdate()));
			}
		}
		if (pageSize > 0) {
			criteria.setFirstResult((pageNo - 1) * pageSize);
			criteria.setMaxResults(pageSize);
		}
		List list = criteria.list();
		return list;
	}

	public TimetableDTO findbyname(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
	
