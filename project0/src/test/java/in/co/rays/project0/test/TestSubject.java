package in.co.rays.project0.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.co.rays.project0.dto.SubjectDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.service.SubjectServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class TestSubject {
	
	@Autowired
	private SubjectServiceInt model;
	
	@Ignore
	public void add() throws DuplicateRecordException{
		
		SubjectDTO dto = new SubjectDTO();
		dto.setCourseid(1);
		dto.setDescription("Subject of Mathmetics");
		dto.setName("M1");
		dto.setCreatedBy("admin");
		dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
		model.add(dto);
	}
	
	@Ignore
	public void update() throws DuplicateRecordException{
		
		SubjectDTO dto = model.findbypk(2l);
		dto.setCourseid(2);
		dto.setDescription("Subject of Mathmetics");
		dto.setName("M1");
		dto.setCreatedBy("admin");
		dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
		model.update(dto);
	}
	
	  @Ignore
	public void delete(){
		
		model.delete(1);
		
	}
	
	@Ignore
	public void findbypk(){
		
		SubjectDTO dto = model.findbypk(1l);
		System.out.println(dto.getCoursename());
		System.out.println(dto.getDescription());
		System.out.println(dto.getId());
		
	}
	
	@Ignore
	public void findbyname(){
		
		SubjectDTO dto  = model.findbyname("m1");
		System.out.println(dto.getCoursename());
		System.out.println(dto.getDescription());
		System.out.println(dto.getId());
		
	}
	
	@Test
	public void search(){
		SubjectDTO dto = new SubjectDTO();
		List list = model.search(dto, 0, 0);
		Iterator it = list.iterator();
		while(it.hasNext()){
			dto = (SubjectDTO) it.next();
		System.out.println(dto.getCoursename());
		System.out.println(dto.getDescription());
		System.out.println(dto.getId());
		}
	}

}
