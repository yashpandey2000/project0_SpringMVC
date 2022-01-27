package in.co.rays.project0.test;

import static org.junit.Assert.fail;

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

import in.co.rays.project0.dto.RoleDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.service.RoleServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
public class TestRole {

	@Autowired
	RoleServiceInt model;


@Test
	public void testadd() {

		RoleDTO dto = new RoleDTO();
		dto.setRoleName("Student");
		dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
		dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
		dto.setModifiedBy("admin");
		dto.setCreatedBy("admin");
		dto.setDescription("hello i am Student");

		try {
			model.add(dto);
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
			fail("testadd");
		}

	}

@Ignore

public void findbypk(){
	
	RoleDTO dto = model.findByPK(1l);
	
		System.out.println(dto.getRoleName());
		System.out.println(dto.getDescription());
		System.out.println(dto.getId());
		
	}
	
	

	
	@Ignore
	public void testfindbyname() {

		RoleDTO dto = model.findByName("student");

		System.out.println(dto.getRoleName());
		System.out.println(dto.getDescription());
		System.out.println(dto.getId());

	}
	
	@Ignore
	public void testupdate() throws DuplicateRecordException{
		
		RoleDTO dto = model.findByName("student");
		dto.setRoleName("staff");
		dto.setDescription("hell..");
		model.update(dto);
		
		
	}
	
	
	@Ignore
	public void testdelete(){
		
		model.delete(1l);
		
	}
	
	@Ignore
	public void testSearch(){
		RoleDTO dto=new RoleDTO();
	    List list=model.search(dto, 0, 0);
	    Iterator it=list.iterator();
	    while (it.hasNext()) {
		     dto = (RoleDTO) it.next();
			System.out.println(dto.getRoleName());
			System.out.println(dto.getDescription());
			System.out.println(dto.getId());
		}
	}
	
	
	
	

}
