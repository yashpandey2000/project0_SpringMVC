/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.rays.project0.dto.MarksheetDTO;

/**
 * The Class MarksheetDAOHibImpl.
 */
@Repository(value = "marksheetDao")
public class MarksheetDAOHibImpl implements MarksheetDAOInt{
	
	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory = null;
	
	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.MarksheetDAOInt#add(in.co.rays.project_0.dto.MarksheetDTO)
	 */
	public long add(MarksheetDTO dto) {
		// TODO Auto-generated method stub
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		System.out.println("add ..." + pk);
		return pk;
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.MarksheetDAOInt#update(in.co.rays.project_0.dto.MarksheetDTO)
	 */
	public void update(MarksheetDTO dto) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(dto);
		
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.MarksheetDAOInt#delete(long)
	 */
	public void delete(long id) {
		// TODO Auto-generated method stub
		MarksheetDTO dto1 = findbypk(id);
		sessionFactory.getCurrentSession().delete(dto1);
		
	}

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.MarksheetDAOInt#findByRollNo(java.lang.String)
	 */
	
	public MarksheetDTO findbyrollno(String rollNo) {
		// TODO Auto-generated method stub
MarksheetDTO dto=null;
		
		List list = (List)sessionFactory.getCurrentSession().createCriteria(MarksheetDTO.class)
				.add(Restrictions.like("rollno", rollNo)).list();
		if(list.size()>0){
			dto=(MarksheetDTO) list.get(0);
		}
		return dto;
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.MarksheetDAOInt#findByPK(long)
	 */
	public MarksheetDTO findbypk(long pk) {
		// TODO Auto-generated method stub
MarksheetDTO dto= (MarksheetDTO) sessionFactory.getCurrentSession().get(MarksheetDTO.class, pk);
		
		return dto;
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.MarksheetDAOInt#search(in.co.rays.project_0.dto.MarksheetDTO, int, int)
	 */
	public List search(MarksheetDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(MarksheetDTO.class);
		if(dto!=null){
			if(dto.getId()>0){
				criteria.add(Restrictions.eq("id",dto.getId()));
			}
			if(dto.getName()!=null&&dto.getName().length()>0){
				criteria.add(Restrictions.like("name", dto.getName()+"%"));
			}
			if(dto.getRollno()!=null && dto.getRollno().length()>0){
				criteria.add(Restrictions.like("rollno",dto.getRollno()+"%"));
			}
		  /*if(dto.getPhysics()>0){
				criteria.add(Restrictions.eq("physics",dto.getPhysics()));
				
			}
			if(dto.getChemistry()>0){
				criteria.add(Restrictions.eq("chemistry",dto.getChemistry()));
			}
			if(dto.getMaths()>0){
				criteria.add(Restrictions.eq("maths",dto.getMaths()));
			}*/
		}
		if(pageSize>0){
			criteria.setFirstResult((pageNo-1)*pageSize);
			criteria.setMaxResults(pageSize);
		}
		List list=criteria.list();
		return list;
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project_0.dao.MarksheetDAOInt#search(in.co.rays.project_0.dto.MarksheetDTO)
	 */
	
	public List search(MarksheetDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.dao.MarksheetDAOInt#getMeritList(int, int)
	 */
	public List getMeritList(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		StringBuffer hql  = new StringBuffer("from MarksheetDTO order by (physics+chemistry+maths) desc");
		Query q = sessionFactory.getCurrentSession().createQuery(hql.toString());
		if(pageSize>0){
			q.setFirstResult((pageNo-1)*pageSize);
			q.setMaxResults(pageSize);
		}
		List list = q.list();
		return list;
	}

}
