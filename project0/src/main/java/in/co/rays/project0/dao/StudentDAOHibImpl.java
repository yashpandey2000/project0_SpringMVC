/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.rays.project0.dto.StudentDTO;


/**
 * The Class StudentDAOHibImpl.
 */
@Repository(value="studentDao")
public class StudentDAOHibImpl implements StudentDAOInt {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory = null;

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.StudentDAOInt#add(in.co.rays.project_0.dto.StudentDTO)
	 */
	
	public long add(StudentDTO dto) {
		// TODO Auto-generated method stub
		long pk = 0;
		pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	

	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.StudentDAOInt#update(in.co.rays.project_0.dto.StudentDTO)
	 */
	public void update(StudentDTO dto) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(dto);
		
	}
	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.StudentDAOInt#delete(long)
	 */

	public void delete(long id) {
		// TODO Auto-generated method stub
		StudentDTO dto = findbypk(id);
		sessionFactory.getCurrentSession().delete(dto);
		
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.StudentDAOInt#findByEmail(java.lang.String)
	 */
	
	public StudentDTO findbyemail(String email) {
		// TODO Auto-generated method stub
		StudentDTO dto = null;
		 List list = sessionFactory.getCurrentSession().createCriteria(StudentDTO.class).add(Restrictions.eq("emailid",email)).list();
		if(list.size()>0)
		{
			dto = (StudentDTO) list.get(0);
		}
		 return dto;
	}

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.StudentDAOInt#findByPK(long)
	 */
	public StudentDTO findbypk(long pk) {
		// TODO Auto-generated method stub
		StudentDTO dto = (StudentDTO) sessionFactory.getCurrentSession().get(StudentDTO.class, pk);
		return dto;
	}

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.StudentDAOInt#search(in.co.rays.project_0.dto.StudentDTO, int, int)
	 */
	public List search(StudentDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StudentDTO.class);
		if(dto!=null){
			if(dto.getId()>0){
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if(dto.getFirstname()!=null && dto.getFirstname().length()>0){
				criteria.add(Restrictions.like("firstname", dto.getFirstname()+"%"));
			}
			if(dto.getLastname()!=null && dto.getLastname().length()>0){
				criteria.add(Restrictions.like("lastname", dto.getLastname()+"%"));
			}
			if(dto.getEmailid()!=null && dto.getEmailid().length()>0){
				criteria.add(Restrictions.like("emailid", dto.getEmailid()+"%"));
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
	 * @see in.co.rays.project_0.dao.StudentDAOInt#search(in.co.rays.project_0.dto.StudentDTO)
	 */
	public List search(StudentDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

}
