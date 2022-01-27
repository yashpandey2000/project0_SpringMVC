/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.ctl;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.rays.project0.dto.StudentDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.form.StudentForm;
import in.co.rays.project0.service.CollegeServiceInt;
import in.co.rays.project0.service.StudentServiceInt;

/**
 * The Class StudentCtl.
 */

@Controller
@RequestMapping(value="/ctl/Student")
public class StudentCtl extends BaseCtl{
	
	/** The service. */
	@Autowired
	private StudentServiceInt service;
	/** The message source. */
	@Autowired
	private MessageSource ms ; 
	
	/** The cservice. */
	@Autowired
	private CollegeServiceInt cs ;
	
	
	/* (non-Javadoc)
	 * @see in.co.rays.project0.ctl.BaseCtl#preload(org.springframework.ui.Model)
	 */
	
	public void preload(Model model){
		List list = cs.search(null);
		model.addAttribute("collegeList", list);
	} 
	
	/**
	 * Display.
	 *
	 * @param id the id
	 * @param form the form
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	
	
	@RequestMapping(value = "/AddStudent" , method = RequestMethod.GET) 
	public String display(@RequestParam(required = false) Long id ,@ModelAttribute("form") StudentForm form , Locale locale , Model model ){
		
		String mail = ms.getMessage("label.enteremail", null , locale);
		model.addAttribute("enteremail",mail);
		
		String dob = ms.getMessage("label.enterdob", null , locale);
		model.addAttribute("enterdob", dob);
		
		String fn = ms.getMessage("label.enterfname", null , locale);
		model.addAttribute("enterfirstName", fn);
		
		String ln = ms.getMessage("label.enterlname", null , locale);
		model.addAttribute("enterLastName",ln);
		
		String mobile = ms.getMessage("label.entermob", null , locale);
		model.addAttribute("enterMobile", mobile );
		
		if(id!=null && id>0){
			StudentDTO dto = service.findbypk(id);
			form.populate(dto);
		}
		
		return "StudentView";
		
	}
	
	
	/**
	 * Submit.
	 *
	 * @param id the id
	 * @param form the form
	 * @param bindresult the bindresult
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	
	@RequestMapping(value = "/AddStudent" , method=RequestMethod.POST)
	public String submit(@RequestParam(required = false) Long id , @ModelAttribute("form") @Valid StudentForm form , BindingResult result , Model model , Locale locale){
	String mail = ms.getMessage("label.enteremail", null , locale);	
	model.addAttribute("enteremail", mail);	
	
	String dob = ms.getMessage("label.enterdob", null , locale);
	model.addAttribute("enterdob", dob);
	
	String  fn  = ms.getMessage("label.enterfname", null , locale );
	model.addAttribute("enterfirstName", fn);
	
	String ln = ms.getMessage("label.enterlname", null , locale);
	model.addAttribute("enterLastName", fn);
	
	String mobile = ms.getMessage("label.entermob", null , locale);
	model.addAttribute("enterMobile", mobile);
	
	if(OP_SAVE.equalsIgnoreCase(form.getOperation()) || OP_UPDATE.equalsIgnoreCase(form.getOperation()))
	{
		
		if(result.hasErrors()){
			return "StudentView";
		}
		
		StudentDTO dto = (StudentDTO) form.getdto();
		dto.setCreatedBy("root");
		dto.setModifiedBy("root");
		
		if(dto.getId()>0){
			service.update(dto);
			String msg = ms.getMessage("message.updatesuccess", null,locale);
		       model.addAttribute("success", msg);
		}
		
		else{
			
			try {
				service.add(dto);
				String msg = ms.getMessage("message.success", null , locale );
				model.addAttribute("success", msg);
			} catch (DuplicateRecordException e) {
				String msg = ms.getMessage("message.email", null , locale );
				model.addAttribute("error", msg);
			}
		}
	}
	if(OP_RESET.equalsIgnoreCase(form.getOperation())){

		return "redirect:/ctl/Student/AddStudent";
		
	}
	
	if(OP_CANCEL.equalsIgnoreCase(form.getOperation())){
		return "redirect:/ctl/Student/StudentListCtl";
	}
		
		return "StudentView";
		
	}
	
	
	
	
	/**
	 * Display.
	 *
	 * @param form the form
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	
	@RequestMapping(value = "/StudentListCtl" , method=RequestMethod.GET)
	public String display (@ModelAttribute("form") StudentForm form , Model model , Locale locale){
		
		String fn = ms.getMessage("label.enterfname",null,locale);
		model.addAttribute("enterfirstName", fn);
		
		String ln = ms.getMessage("label.enterlname", null , locale);
		model.addAttribute("enterLastName", ln);
		
		List list = service.search(new StudentDTO(), form.getPageNo(),form.getPageSize());
		model.addAttribute("list", list);
		
		List next = service.search(new StudentDTO(), form.getPageNo()+1, form.getPageSize());
		model.addAttribute("nextlistsize", next.size());
		
		
		return "StudentListView";
		
	}
	
	
	
	/**
	 * Submit.
	 *
	 * @param operation the operation
	 * @param form the form
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	
	@RequestMapping(value = "/StudentListCtl" , method= RequestMethod.POST)
	public String submit(@RequestParam(required = false) String operation ,@ModelAttribute("form") StudentForm form, Model model , Locale locale){
		
		String sno = ms.getMessage("label.sno", null , locale);
		model.addAttribute("sno", sno);
		
		String fn = ms.getMessage("label.enterfname", null , locale );
		model.addAttribute("enterfirstName", fn);
		
		String ln = ms.getMessage("label.enterlname", null , locale );
		model.addAttribute("enterLastName", ln);
		
		int pageNo = form.getPageNo();
		
		if(OP_PREVIOUS.equalsIgnoreCase(operation)){
			pageNo--;
		}
		
		else if (OP_NEXT.equalsIgnoreCase(operation)){
			pageNo++;
		}
		
		else if(OP_DELETE.equalsIgnoreCase(operation)){
			if(form.getChk_1()!=null){
				for (long id : form.getChk_1()) {
					service.delete(id);
				}
				
				String msg = ms.getMessage("message.deleterecord",null,locale);
				model.addAttribute("success", msg);
			}else{
				
				String msg = ms.getMessage("message.atleastone",null,locale);
				model.addAttribute("error", msg);
			}
			if (OP_RESET.equalsIgnoreCase(operation)) {
				return "redirect:/ctl/Student/StudentListCtl";
			}
			if (OP_NEW.equalsIgnoreCase(operation)) {
				return "redirect:/ctl/Student/AddStudent";
			}
			
			pageNo = (pageNo<1)?1 : pageNo;
			form.setPageNo(pageNo);
			
			StudentDTO dto = (StudentDTO) form.getdto();
			
			List list = service.search(dto, pageNo , form.getPageSize());
			model.addAttribute("list", list);
			
			if(list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)){
				model.addAttribute("error", ms.getMessage("message.norecord", null , locale));
			}
			
			List next = service.search(dto, pageNo+1, form.getPageSize());
			model.addAttribute("nextlistsize", next.size());
		}
		return "StudentListView";
		
	}
	
	

}
