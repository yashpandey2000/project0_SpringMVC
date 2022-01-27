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
import in.co.rays.project0.dao.StudentDAOInt;
import in.co.rays.project0.dto.CollegeDTO;
import in.co.rays.project0.dto.StudentDTO;
import in.co.rays.project0.dto.SubjectDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
/**
 * The Class StudentServiceSpringImpl.
 */
@Service(value="studentService")
public class StudentServiceSpringImpl implements StudentServiceInt{

	/** The cdao. */
	@Autowired
	private CollegeDAOInt cdao ;
	/** The dao. */
	@Autowired
	private StudentDAOInt sdao;
	
	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.StudentServiceInt#add(in.co.rays.project_0.dto.StudentDTO)
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly = false)
	public long add(StudentDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
       CollegeDTO cdto = cdao.findbypk(dto.getCollegeid());
       dto.setCollegename(cdto.getName());
       
       StudentDTO dtoexist = sdao.findbyemail(dto.getEmailid());
       if(dtoexist!=null){
    	   throw new DuplicateRecordException("student already exist !!");
       }
       
		return sdao.add(dto);
	}
	

	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.StudentServiceInt#update(in.co.rays.project_0.dto.StudentDTO)
	 */

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void update(StudentDTO dto) {
		// TODO Auto-generated method stub
		 CollegeDTO cdto = cdao.findbypk(dto.getCollegeid());
	       dto.setCollegename(cdto.getName());
	       
		sdao.update(dto);
		
	}
	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.StudentServiceInt#delete(long)
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void delete(long id) {
		// TODO Auto-generated method stub
		sdao.delete(id);
	}
	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.StudentServiceInt#findByPK(long)
	 */

	@Transactional(readOnly=true)
	public StudentDTO findbypk(long pk) {
		// TODO Auto-generated method stub
		
		return sdao.findbypk(pk);
	}
	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.service.StudentServiceInt#findByEmail(java.lang.String)
	 */

	@Transactional(readOnly=true)
	public StudentDTO findbyemail(String email) {
		// TODO Auto-generated method stub
		return sdao.findbyemail(email);
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project_0.service.StudentServiceInt#search(in.co.rays.project_0.dto.StudentDTO, int, int)
	 */
	@Transactional(readOnly=true)
	public List search(StudentDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return sdao.search(dto, pageNo, pageSize);
	}
	/* (non-Javadoc)
	 * @see in.co.rays.project_0.service.StudentServiceInt#search(in.co.rays.project_0.dto.StudentDTO)
	 */
	@Transactional(readOnly=true)
	public List search(StudentDTO dto) {
		// TODO Auto-generated method stub
		return sdao.search(dto);
	}

}
