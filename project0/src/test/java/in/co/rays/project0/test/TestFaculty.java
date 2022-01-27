package in.co.rays.project0.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.co.rays.project0.dto.FacultyDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.service.FacultyServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
public class TestFaculty {
	
	@Autowired
	private FacultyServiceInt model ;
	
	@Ignore
	public void add() throws ParseException, DuplicateRecordException{
		FacultyDTO dto = new FacultyDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//dto.setSubjectid(1);
		dto.setCollegeid(1);
		dto.setCourseid(1);
		dto.setSubjectid(1);
		dto.setEmailid("hemesh23@gmail.com");
		dto.setFirstname("hemesh");
		dto.setLastname("shrikant");
		dto.setDob(sdf.parse("22/07/1995"));
		dto.setCreatedBy("admin");
		dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
		
		model.add(dto);
	}
	
	
	@Test
	public void update() throws ParseException{
		FacultyDTO dto = new FacultyDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dto.setId(1);
		dto.setCollegeid(1);
		dto.setSubjectid(1);
		dto.setCourseid(1);
		dto.setEmailid("lokesh23@gmail.com");
		dto.setFirstname("lokesh");
		dto.setLastname("dixit");
		dto.setDob(sdf.parse("10/06/2000"));
		dto.setCreatedBy("admin");
		dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
		model.update(dto);
	}
	
	@Ignore
	public void findbyemail(){
		FacultyDTO dto = model.findbyemail("lokesh23@gmail.com");
		System.out.println(dto.getCollegename());
		System.out.println(dto.getCoursename());
		System.out.println(dto.getFirstname());
		System.out.println(dto.getLastname());
		System.out.println(dto.getCreatedBy());
	}
	
@Ignore
	public void findbypk(){
		FacultyDTO dto = model.findbypk(1);
		System.out.println(dto.getCollegename());
		System.out.println(dto.getCoursename());
		System.out.println(dto.getFirstname());
		System.out.println(dto.getLastname());
		System.out.println(dto.getCreatedBy());
	}

@Ignore
public void search(){
	FacultyDTO dto = null;
	List list = model.search(dto, 0, 0);
	Iterator it = list.iterator();
	while(it.hasNext()){
		dto = (FacultyDTO) it.next();
		System.out.println(dto.getCollegename());
		System.out.println(dto.getCoursename());
		System.out.println(dto.getFirstname());
		System.out.println(dto.getLastname());
		System.out.println(dto.getCreatedBy());
		
	}
	
	
}
	
}
