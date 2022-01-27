/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.project0.dao.CourseDAOInt;
import in.co.rays.project0.dao.SubjectDAOInt;
import in.co.rays.project0.dao.TimetableDAOInt;
import in.co.rays.project0.dto.CourseDTO;
import in.co.rays.project0.dto.SubjectDTO;
import in.co.rays.project0.dto.TimetableDTO;
import in.co.rays.project0.exception.DuplicateRecordException;


/**
 * The Class TimetableServiceSpringImpl.
 */
@Service(value = "timetableService")
public class TimetableServiceSpringImpl implements TimetableServiceInt{

	/** The dao. */
	@Autowired
	TimetableDAOInt dao;
	
	/** The coudao. */
	@Autowired
	private CourseDAOInt coudao;
	
	/** The subdao. */
	@Autowired
	private SubjectDAOInt subdao;

	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.TimetableServiceInt#add(in.co.rays.project_0.dto.TimetableDTO)
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(TimetableDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		if ((dao.checkbycourse(dto) != null) && (dao.checkbysemester(dto) != null)
				&& (dao.checkbysubject(dto) != null)) {
			throw new DuplicateRecordException("time table already exist");
		}
		
		CourseDTO coudto=coudao.findbypk(dto.getCourseid());
		dto.setCoursename(coudto.getName());
		SubjectDTO subdto=subdao.findbypk(dto.getSubjectid());
		dto.setSubjectname(subdto.getName());
		
		return dao.add(dto);
	}

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.TimetableServiceInt#update(in.co.rays.project_0.dto.TimetableDTO)
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(TimetableDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		if ((dao.checkbycourse(dto) != null) && (dao.checkbysemester(dto) != null)
				&& (dao.checkbysubject(dto) != null)) {
			throw new DuplicateRecordException("time table already exist");
		}
		dao.update(dto);
		
	}

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.TimetableServiceInt#delete(long)
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
		
	}


	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.TimetableServiceInt#findByPK(long)
	 */
	@Transactional(readOnly = true)
	public TimetableDTO findbypk(long pk) {
		// TODO Auto-generated method stub
		return dao.findbypk(pk);
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.TimetableServiceInt#search(in.co.rays.project_0.dto.TimetableDTO)
	 */
	@Transactional(readOnly = true)
	public List search(TimetableDTO dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}

	

	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.TimetableServiceInt#search(in.co.rays.project_0.dto.TimetableDTO, int, int)
	 */
	@Transactional(readOnly = true)
	public List search(TimetableDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return dao.search(dto, 0, 0);
	}

}
