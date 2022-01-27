package in.co.rays.project0.test;

import java.sql.Timestamp;
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

import in.co.rays.project0.dto.CourseDTO;
import in.co.rays.project0.dto.MarksheetDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.service.MarksheetServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class TestMarksheet {

	
	@Autowired
	private MarksheetServiceInt model;
	
	@Ignore
	public void add() throws DuplicateRecordException{
		MarksheetDTO dto = new MarksheetDTO();
		dto.setPhysics(80);
		dto.setChemistry(89);
		dto.setMaths(86);
		dto.setRollno("101");
		dto.setStudentid(1);
		dto.setCreatedBy("admin");
		dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
		model.add(dto);
	}
	
	@Ignore
	
	public void update() throws DuplicateRecordException{
		MarksheetDTO dto = model.findbypk(1);
		dto.setPhysics(86);
		dto.setChemistry(80);
		dto.setMaths(90);
		dto.setRollno("105");
		dto.setStudentid(1);
		dto.setCreatedBy("admin");
		dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
		model.update(dto);
	}
	
	@Ignore	

	
	public void delete(){
		
		model.delete(1);
	}
	
	@Ignore
	
public void findbyrollno(){
		
		MarksheetDTO dto = model.findbyrollno("101");
		
		System.out.println(dto.getId());
		System.out.println(dto.getName());
		System.out.println(dto.getRollno());
		System.out.println(dto.getChemistry());
		System.out.println(dto.getMaths());
		
	}
	
	
	@Ignore
	public void search(){
		MarksheetDTO dto = null;
		List list = model.search(dto, 0, 0);
		Iterator it = list.iterator();
		while(it.hasNext()){
			dto = (MarksheetDTO) it.next();
			System.out.println(dto.getId());
			System.out.println(dto.getName());
			System.out.println(dto.getRollno());
			System.out.println(dto.getChemistry());
			System.out.println(dto.getMaths());
			
			
   }
  }
	
	
	@Test
	public void getmeritlist(){
		MarksheetDTO dto = null;
		List list =  model.getMeritList(0, 0);
		
		Iterator it = list.iterator();
		while(it.hasNext()){
			dto = (MarksheetDTO) it.next();
			System.out.println(dto.getId());
			System.out.println(dto.getName());
			System.out.println(dto.getRollno());
			System.out.println(dto.getChemistry());
			System.out.println(dto.getMaths());
			
			
   }
		
	}
	
}