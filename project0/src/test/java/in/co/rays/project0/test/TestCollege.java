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

import in.co.rays.project0.dto.CollegeDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.service.CollegeServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class TestCollege {
	
	@Autowired
	CollegeServiceInt model;
	
	
	@Ignore
	public void add() throws DuplicateRecordException{
		
		CollegeDTO dto = new CollegeDTO();
		dto.setName("SVVV");
		dto.setCity("indore");
		dto.setAddress("ujjain");
		dto.setState("m.p.");
		dto.setPhoneno("9897646443");
		dto.setModifiedBy("admin");
		dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
		model.add(dto);
		
	}
	
	@Ignore
	public void delete(){
		
		model.delete(2);
		
	}
	
	@Ignore
	
	public void update(){
		
		CollegeDTO dto = model.findbypk(1);
		dto.setName("SGSITS");
		dto.setCity("indore");
		dto.setAddress("RNT MARG");
		dto.setState("m.p.");
		dto.setPhoneno("97653534213");
		dto.setModifiedBy("admin");
		dto.setCreatedBy("admin");
		dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
		dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
		model.update(dto);
		
	}
	
	@Ignore
	public void findbypk(){
		CollegeDTO dto = model.findbypk(1);
		
		System.out.println(dto.getAddress());
		System.out.println(dto.getCity());
		System.out.println(dto.getName());
		System.out.println(dto.getState());
		System.out.println(dto.getPhoneno());
		
	}
	
	@Ignore
	public void findbyname(){
		CollegeDTO dto = model.findbyname("SGSITS");
		
	   System.out.println(dto.getAddress());
		System.out.println(dto.getCity());
		System.out.println(dto.getName());
		System.out.println(dto.getState());
		System.out.println(dto.getPhoneno());
	}
	
	@Test
	public void search(){
		
		CollegeDTO dto = new CollegeDTO();
		List list = model.search(dto, 0, 0);
		Iterator it = list.iterator();
		while(it.hasNext()){
			dto = (CollegeDTO) it.next();
			 System.out.println(dto.getAddress());
				System.out.println(dto.getCity());
				System.out.println(dto.getName());
				System.out.println(dto.getState());
				System.out.println(dto.getPhoneno());

			
		}
		
		
		
	}

}
