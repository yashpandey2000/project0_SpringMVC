package in.co.rays.project0.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.co.rays.project0.dto.StudentDTO;
import in.co.rays.project0.dto.TimetableDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.service.TimetableServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class TestTimetable {

	
	@Autowired
	private TimetableServiceInt model;
	
	@Ignore
	public void add() throws DuplicateRecordException, ParseException{
		
		TimetableDTO dto = new TimetableDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dto.setCourseid(1);
		dto.setSubjectid(1);
		dto.setExamdate(sdf.parse("12/06/2021"));
		dto.setSemester("4th");
		dto.setCreatedBy("admin");
		model.add(dto);
	}
	
	@Ignore
	public void update() throws ParseException, DuplicateRecordException{
		TimetableDTO dto =model.findbypk(1l);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dto.setCourseid(1);
		dto.setSubjectid(1);
		dto.setExamdate(sdf.parse("15/06/2021"));
		dto.setSemester("6th");
		dto.setCreatedBy("admin");
		model.update(dto);
	}
	
	@Ignore
	public void delete(){
		
		model.delete(1);
		
	}
	
	
	@Test
	public void search(){
		TimetableDTO dto = new TimetableDTO();
		List list = model.search(dto, 0, 0);
		Iterator it = list.iterator();
		while(it.hasNext()){
			dto = (TimetableDTO) it.next();
			System.out.println(dto.getCoursename());
			System.out.println(dto.getSubjectname());
			System.out.println(dto.getSemester());
	
		}
		}
	
	
	
	
}
