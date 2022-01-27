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
import org.springframework.ui.Model;

import in.co.rays.project0.dto.UserDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.service.UserServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class TestUser {
	
	@Autowired
	private UserServiceInt model ;
	
	@Ignore
	public void add() throws DuplicateRecordException, ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		UserDTO dto = new UserDTO();
		dto.setFirstname("yash");
		dto.setLastname("pandey");
		dto.setGender("male");
		dto.setDob(sdf.parse("17/06/2000"));
		dto.setLogin("yashpanday2000@gmail.com");
		dto.setMobileno("62646469746");
		dto.setCreatedBy("admin");
		dto.setRoleid(1);
		dto.setPassword("Yash@123");
		dto.setModifiedBy("admin");
		dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
		dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
		model.add(dto);
	}
	
	@Ignore
	public void update() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		UserDTO dto = model.findbylogin("nikhil22@gmail.com");
		dto.setFirstname("shreya");
		dto.setLastname("mehta");
		dto.setGender("female");
		dto.setDob(sdf.parse("17/06/2001"));
		dto.setLogin("shreya2000@gmail.com");
		dto.setMobileno("987662434");
		dto.setCreatedBy("admin");
		dto.setRoleid(1);
		dto.setModifiedBy("admin");
		dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
		dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
		model.update(dto);
		
	}
	
@Ignore
	public void findbypk(){
		
		UserDTO dto =model.findbypk(1);
		System.out.println(dto.getId());
		System.out.println(dto.getFirstname());
		System.out.println(dto.getLastname());
		System.out.println(dto.getGender());
		System.out.println(dto.getMobileno());
		System.out.println(dto.getCreatedBy());
		System.out.println(dto.getCreatedDateTime());
		System.out.println(dto.getRoleid());
		
		
	}
	
	@Ignore
	
	public void findbylogin(){
		UserDTO dto =model.findbylogin("yashanday2000@gmail.com");
		System.out.println(dto.getId());
		System.out.println(dto.getFirstname());
		System.out.println(dto.getLastname());
		System.out.println(dto.getGender());
		System.out.println(dto.getMobileno());
		System.out.println(dto.getCreatedBy());
		System.out.println(dto.getCreatedDateTime());
		System.out.println(dto.getRoleid());
		
		
	}
	
	
	
	@Ignore
	public void delete(){
		model.delete(2);
	}
	
	
	@Ignore
	public void search(){
		
		UserDTO dto = new UserDTO();
		List list = model.search(dto, 0, 0);
		Iterator it = list.iterator();
		while(it.hasNext()){
			
			dto = (UserDTO) it.next();
			
			System.out.println(dto.getId());
			System.out.println(dto.getFirstname());
			System.out.println(dto.getLastname());
			System.out.println(dto.getGender());
			System.out.println(dto.getMobileno());
			System.out.println(dto.getCreatedBy());
			System.out.println(dto.getCreatedDateTime());
			System.out.println(dto.getRoleid());
			
		}
		
	}
	
	
	
	@Test
	public void testregisteruser() {
		UserDTO dto = new UserDTO();
		
		try{
			
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
			
		dto.setFirstname("surya");
		dto.setLastname("yadav");
		dto.setLogin("yashpanday2000@gmail.com");
		dto.setPassword("Surya@123");
		//bean.setConfirmpassword("1234");
		dto.setDob(sdf.parse("16/07/2002"));
		dto.setGender("male");
		dto.setRoleid(2);
		
	model.registeruser(dto);
		
			System.out.println("successful register");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	
	/*@Test
	public void testchangepass() throws DuplicateRecordException{
		
		UserDTO dto = model.findbylogin("yashpanday2000@gmail.com");
		model.changepassword(1l, "yash@123" , "yash@2323");
		System.out.println("password changed Successfully");
	}*/
	
	

}
