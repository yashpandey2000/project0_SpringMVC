/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.project0.dao.CourseDAOInt;
import in.co.rays.project0.dao.SubjectDAOHibImpl;
import in.co.rays.project0.dao.SubjectDAOInt;
import in.co.rays.project0.dto.CourseDTO;
import in.co.rays.project0.dto.SubjectDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
/**
 * The Class SubjectServiceSpringImpl.
 */
@Service(value="subjectService")
public class SubjectServiceSpringImpl implements SubjectServiceInt{
	/** The log. */
	private static Logger log = Logger.getLogger(SubjectServiceSpringImpl.class);

	/** The dao. */
	@Autowired
	private SubjectDAOInt dao ;
	/** The cdao. */
	@Autowired
	private CourseDAOInt cdao;
	
	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.SubjectServiceInt#add(in.co.rays.project_0.dto.SubjectDTO)
	 */
	@Transactional(propagation=Propagation.REQUIRED , readOnly=false)
	public long add(SubjectDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		log.debug("Subject Service Add Started");
		CourseDTO cdto = cdao.findbypk(dto.getCourseid());
		dto.setCoursename(cdto.getName());
		
		SubjectDTO dtoexist = dao.findbyname(dto.getName());
		if(dtoexist !=null){
			throw new DuplicateRecordException("subject already exist !!");
		}
		log.debug("Subject Service Add ended");
		return dao.add(dto);
	}

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.SubjectServiceInt#update(in.co.rays.project_0.dto.SubjectDTO)
	 */
	@Transactional(propagation=Propagation.REQUIRED , readOnly=false)
	public void update(SubjectDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		log.debug("Subject Service update Started");
		
		CourseDTO cdto = cdao.findbypk(dto.getCourseid());
		dto.setCoursename(cdto.getName());
		System.out.println(cdto.getName()+"------------------------");
		
		dao.update(dto);
		log.debug("Subject Service update ended");
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.SubjectServiceInt#delete(long)
	 */
	@Transactional(propagation=Propagation.REQUIRED , readOnly=false)
	public void delete(long id) {
		// TODO Auto-generated method stub
		log.debug("Subject Service delete Started");
		dao.delete(id);
		log.debug("Subject Service delete ended");
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.SubjectServiceInt#findByName(java.lang.String)
	 */
	@Transactional(readOnly = true)
	public SubjectDTO findbyname(String SubjectName) {
		// TODO Auto-generated method stub
		log.debug("Subject Service findByName Started");
		SubjectDTO dto = dao.findbyname(SubjectName);
		log.debug("Subject Service findByName ended");
		return dto;
	}
	

	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.SubjectServiceInt#findById(java.lang.Long)
	 */

	@Transactional(readOnly = true)
	public SubjectDTO findbypk(Long pk) {
		// TODO Auto-generated method stub
		log.debug("Subject Service findById Started");
		SubjectDTO dto = dao.findbypk(pk);
		log.debug("Subject Service findById ended");
		return dto;
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.SubjectServiceInt#search(in.co.rays.project_0.dto.SubjectDTO, int, int)
	 */
	@Transactional(readOnly = true)
	public List search(SubjectDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.debug("Subject Service search Started");
		log.debug("Subject Service search ended");
		return dao.search(dto, pageNo, pageSize);
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.SubjectServiceInt#search(in.co.rays.project_0.dto.SubjectDTO)
	 */
	@Transactional(readOnly = true)
	public List search(SubjectDTO dto) {
		// TODO Auto-generated method stub
		log.debug("Subject Service search Started");
		log.debug("Subject Service search ended");
		return search(dto,0,0);
	}

}
