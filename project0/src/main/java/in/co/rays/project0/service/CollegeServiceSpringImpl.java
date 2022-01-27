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

import in.co.rays.project0.dao.CollegeDAOInt;
import in.co.rays.project0.dto.CollegeDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
/**
 * The Class CollegeServiceSpringImpl.
 */
@Service(value="collegeService")
public class CollegeServiceSpringImpl implements CollegeServiceInt {
	/** The dao. */
	@Autowired
	private CollegeDAOInt dao ;

	

	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.CollegeServiceInt#add(in.co.rays.project_0.dto.CollegeDTO)
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(CollegeDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		CollegeDTO dtoexist = findbyname(dto.getName());
		if(dtoexist!=null){
			throw new DuplicateRecordException("name already exist");
		}
		
		return dao.add(dto);
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.CollegeServiceInt#update(in.co.rays.project_0.dto.CollegeDTO)
	 */
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(CollegeDTO dto) {
		// TODO Auto-generated method stub
		dao.update(dto);
		
	}
	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.CollegeServiceInt#delete(long)
	 */

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
		
	}
	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.CollegeServiceInt#findByName(java.lang.String)
	 */

	@Transactional(readOnly = true)
	public CollegeDTO findbyname(String name) {
		// TODO Auto-generated method stub
		
		return dao.findbyname(name);
	}

	

	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.CollegeServiceInt#findByPK(long)
	 */
	@Transactional(readOnly = true)
	public CollegeDTO findbypk(long pk) {
		// TODO Auto-generated method stub
		return dao.findbypk(pk);
	}

	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.CollegeServiceInt#search(in.co.rays.project_0.dto.CollegeDTO)
	 */
	@Transactional(readOnly = true)
	public List search(CollegeDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return dao.search(dto, pageNo, pageSize);
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.CollegeServiceInt#search(in.co.rays.project_0.dto.CollegeDTO, int, int)
	 */
	@Transactional(readOnly = true)
	public List search(CollegeDTO dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}

}
