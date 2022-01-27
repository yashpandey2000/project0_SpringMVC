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
import in.co.rays.project0.dto.StudentDTO;
import in.co.rays.project0.dto.SubjectDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.service.StudentServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class TestStudent {
	
	@Autowired
	private StudentServiceInt model;
	
	@Ignore
	public void add() throws DuplicateRecordException{
		
		StudentDTO dto = new StudentDTO();
		dto.setCollegeid(1);
		dto.setEmailid("kelash344@gmail.com");
		dto.setFirstname("kelash");
		dto.setLastname("khemot");
		dto.setMobileno("9869695493");
		model.add(dto);
	}
	@Ignore
	public void update() throws ParseException{
		StudentDTO dto =model.findbypk(1l);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dto.setCollegeid(2);
		dto.setFirstname("mayank");
		dto.setLastname("silawat");
		dto.setMobileno("8959594932");
		dto.setEmailid("mayank455@gmail.com");
		dto.setDob(sdf.parse("23/04/1998"));
		dto.setCreatedBy("admin");
		model.update(dto);
	}
	
	
	@Ignore
	public void delete(){
		
		model.delete(1);
		
	}
	
	
	
	@Ignore
	public void findbyemail(){
		
		StudentDTO dto  = model.findbyemail("mayank455@gmail.com");
		System.out.println(dto.getFirstname());
		System.out.println(dto.getLastname());
		System.out.println(dto.getCollegename());
		
	}

	
	@Test
	public void search(){
		StudentDTO dto = new StudentDTO();
		List list = model.search(dto, 0, 0);
		Iterator it = list.iterator();
		while(it.hasNext()){
			dto = (StudentDTO) it.next();
			System.out.println(dto.getId());
			System.out.println(dto.getFirstname());
			System.out.println(dto.getLastname());
			System.out.println(dto.getCollegename());
	
		}
		}
}
