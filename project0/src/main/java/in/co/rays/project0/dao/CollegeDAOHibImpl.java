/**
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

import in.co.rays.project0.dto.CollegeDTO;

/**
 * The Class CollegeDAOHibImpl.
 */


@Repository(value="collegeDao")
public class CollegeDAOHibImpl implements CollegeDAOInt{
	
	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory=null;

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.CollegeDAOInt#add(in.co.rays.project_0.dto.CollegeDTO)
	 */
	
	public long add(CollegeDTO dto) {
		// TODO Auto-generated method stub
		long pk = 0; 
		pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.CollegeDAOInt#update(in.co.rays.project_0.dto.CollegeDTO)
	 */
	public void update(CollegeDTO dto) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(dto);
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.CollegeDAOInt#delete(long)
	 */
	public void delete(long id) {
		// TODO Auto-generated method stub
		   CollegeDTO dto1 = findbypk(id);
	       sessionFactory.getCurrentSession().delete(dto1);
	}

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.CollegeDAOInt#findByName(java.lang.String)
	 */
	
	public CollegeDTO findbyname(String name) {
		// TODO Auto-generated method stub
		CollegeDTO dto = null;
		List list = sessionFactory.getCurrentSession().createCriteria(CollegeDTO.class).add(Restrictions.like("name", name)).list();
		if(list.size()>0){
			dto = (CollegeDTO) list.get(0);
		}
		return dto;
	}


	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.CollegeDAOInt#findByPK(long)
	 */
	
	public CollegeDTO findbypk(long pk) {
		// TODO Auto-generated method stub
		CollegeDTO dto = (CollegeDTO) sessionFactory.getCurrentSession().get(CollegeDTO.class, pk);
		return dto;
	}

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.CollegeDAOInt#search(in.co.rays.project_0.dto.CollegeDTO, int, int)
	 */
	public List search(CollegeDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CollegeDTO.class);
		if(dto!=null){
			
			if(dto.getId()>0){
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if(dto.getName()!=null&&dto.getName().length()>0){
				criteria.add(Restrictions.like("name", dto.getName()+"%"));
			}
			if(dto.getState()!=null&&dto.getState().length()>0){
				criteria.add(Restrictions.like("state", dto.getState()+"%"));
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
	 * @see in.co.rays.project0.dao.CollegeDAOInt#search(in.co.rays.project_0.dto.CollegeDTO)
	 */
	public List search(CollegeDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

}
