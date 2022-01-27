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
import in.co.rays.project0.dto.CourseDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
/**
 * The Class CourseServiceSpringImpl.
 */
@Service(value="courseService")
public class CourseServiceSpringImpl implements CourseServiceInt{
	/** The log. */
	private static Logger log = Logger.getLogger(CourseServiceSpringImpl.class);
	
	/** The dao. */
	@Autowired
	private CourseDAOInt dao;

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.CourseServiceInt#add(in.co.rays.project_0.dto.CourseDTO)
	 */
	@Transactional(propagation=Propagation.REQUIRED , readOnly=false)
	public long add(CourseDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		log.debug("Course Service Add Started");
		CourseDTO dtoexist = dao.findbyname(dto.getName());
		if(dtoexist!=null){
			throw new DuplicateRecordException("Course name already exist !!");
		}
		  log.debug("Course Service Add Ended");
		return dao.add(dto);
	}
	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.CourseServiceInt#update(in.co.rays.project_0.dto.CourseDTO)
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void update(CourseDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		log.debug("Course Service update Started");
		dao.update(dto);
		log.debug("Course Service update Ended");

	}
	
	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.CourseServiceInt#delete(long)
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void delete(long id) {
		// TODO Auto-generated method stub
		log.debug("Course Service delete started");
		dao.delete(id);
		log.debug("Course Service delete Ended");

	}
	

	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.CourseServiceInt#findByName(java.lang.String)
	 */

	@Transactional(readOnly=true)
	public CourseDTO findbyname(String CourseName) {
		// TODO Auto-generated method stub
		log.debug("Course Service findByName Started");
		CourseDTO dto = dao.findbyname(CourseName);
		 log.debug("Course Service findByName Ended");
		return dto;
	}

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.CourseServiceInt#findById(java.lang.Long)
	 */
	@Transactional(readOnly=true)
	public CourseDTO findbypk(Long pk) {
		// TODO Auto-generated method stub
		log.debug("Course Service findByName Started");
		CourseDTO dto = dao.findbypk(pk);
		 log.debug("Course Service findByName Ended");
		return dto;
	}

	
	/* (non-Javadoc)
	 * @see in.co.rays.project_0.service.CourseServiceInt#search(in.co.rays.project_0.dto.CourseDTO)
	 */
	@Transactional(readOnly=true)
	public List search(CourseDTO dto) {
		// TODO Auto-generated method stub
		
		return search(dto, 0, 0);
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.CourseServiceInt#search(in.co.rays.project_0.dto.CourseDTO, int, int)
	 */
	@Transactional(readOnly=true)
	public List search(CourseDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		
		return dao.search(dto, pageNo, pageSize);
	}

}
