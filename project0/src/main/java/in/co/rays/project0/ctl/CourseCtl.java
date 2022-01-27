/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.ctl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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

import in.co.rays.project0.dto.CourseDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.form.CourseForm;
import in.co.rays.project0.service.CourseServiceInt;


/**
 * The Class CourseCtl.
 */


@Controller
@RequestMapping(value="/ctl/Course")
public class CourseCtl extends BaseCtl{
	
	/** The service. */
	@Autowired
	private CourseServiceInt service;
	/** The message source. */
	@Autowired
	private MessageSource ms ;
	
	
	/**
	 * Gets the duration list.
	 *
	 * @param model the model
	 * @return the duration list
	 */
	
	@ModelAttribute("durationList")
	public Map<String, String> getDurationList(Model model){
		Map<String, String> durationList = new LinkedHashMap<String, String>();
		durationList.put("1year", "1year");
		durationList.put("2year", "2year");
		durationList.put("3year", "3year");
		durationList.put("4year", "4year");
		durationList.put("5year", "5year");
		return durationList;
		
	}
	
	
	/**
	 * Display.
	 *
	 * @param id the id
	 * @param form the form
	 * @param result the result
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	@RequestMapping(value="/AddCourse" , method=RequestMethod.GET)
	public String display(@RequestParam(required = false) Long id , @ModelAttribute("form") CourseForm form , BindingResult result , Model model , Locale locale){
		
		String entername = ms.getMessage("label.entercoursename", null , locale);
		model.addAttribute("entername", entername);
		
		String enterdesc = ms.getMessage("label.enterdescription" ,  null , locale );
		model.addAttribute("enterdesc", enterdesc);
		
		if(id!=null && id>0){
			CourseDTO dto = service.findbypk(id);
		    form.populate(dto);
		}
		
		
		return "CourseView";
		
	}
	
	
	
	  /**
   	 * Submit.
   	 *
   	 * @param form the form
   	 * @param result the result
   	 * @param model the model
   	 * @param locale the locale
   	 * @return the string
   	 */
	@RequestMapping(value="/AddCourse" , method=RequestMethod.POST)
	public String submit(@ModelAttribute("form") @Valid CourseForm form , BindingResult result , Model model , Locale locale){
		
		String entername = ms.getMessage("label.entercoursename", null , locale);
		model.addAttribute("entername", entername);
		
		String enterdesc = ms.getMessage( "label.enterdescription", null , locale);
		model.addAttribute("enterdesc", enterdesc);
		
		if(OP_SAVE.equalsIgnoreCase(form.getOperation() ) || OP_UPDATE.equalsIgnoreCase(form.getOperation())){
			
			if(result.hasErrors()){
				return "CourseView";
			}
			
			CourseDTO dto = (CourseDTO) form.getdto();
			dto.setCreatedBy("root");
			dto.setModifiedBy("root");
			
			if(dto.getId()>0){
				try {
					service.update(dto);
					String msg = ms.getMessage("message.updatesuccess", null ,locale);
				     model.addAttribute("success", msg);
				} catch (DuplicateRecordException e) {
					// TODO Auto-generated catch block
					String msg = ms.getMessage("error.coursename", null , locale);
					model.addAttribute("error", msg);
				}
				
			     
			     
			}else{
				
				try {
					service.add(dto);
					String msg = ms.getMessage("message.success", null , locale);
					model.addAttribute("success", msg);
				} catch (DuplicateRecordException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					 String msg = ms.getMessage("error.coursename", null, locale);
					   model.addAttribute("error",msg);
				}
				
			}
			
		}
		
		if(OP_RESET.equalsIgnoreCase(form.getOperation())){
			 return "redirect:/ctl/Course/AddCourse";
		}
		if(OP_CANCEL.equalsIgnoreCase(form.getOperation())){
			return "redirect:/ctl/Course/CourseListCtl";
		}
		
		return "CourseView";
		}
	
	
	
	  /**
   	 * Display.
   	 *
   	 * @param form the form
   	 * @param model the model
   	 * @param locale the locale
   	 * @return the string
   	 */
	
	
	@RequestMapping(value="/CourseListCtl" , method=RequestMethod.GET)
	   public String display(@ModelAttribute("form") CourseForm form , Model model,Locale locale)
	   {
		   String entername=ms.getMessage("label.entercoursename",null,locale);
			model.addAttribute("enterName",entername);
			int pageNo =1; 
			List list = service.search(new CourseDTO(), form.getPageNo() , form.getPageSize());
			model.addAttribute("list", list);
			List next = service.search(new CourseDTO(), pageNo+1 , form.getPageSize());
			model.addAttribute("nextlistsize",next.size());
		   
		return "CourseListView";
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
	
	@RequestMapping(value="/CourseListCtl" , method=RequestMethod.POST)
	   public String submit(@RequestParam(required=false) String operation , @ModelAttribute("form") CourseForm form , BindingResult result ,Model model , Locale locale)
	   {
		   String entername=ms.getMessage("label.entercoursename",null,locale);
			model.addAttribute("enterName",entername);
			String sno = ms.getMessage("label.sno", null, locale);
			model.addAttribute("sno", sno);


			if(result.hasErrors())
			{
			  return "UserListView";
			}
			
			int pageNo = (form.getPageNo()== 0)?1:form.getPageNo();
			int pageSize = form.getPageSize();
			
			
			List list = null;
			List next = null;
		   
			CourseDTO dto = (CourseDTO)form.getdto();
			
			if(OP_SEARCH.equalsIgnoreCase(operation))
			{
				pageNo=1;
			}
			if(OP_NEXT.equalsIgnoreCase(operation))
			{
				pageNo++;
			}
			if(OP_PREVIOUS.equalsIgnoreCase(operation))
			{
				pageNo--;
			}
			if(OP_DELETE.equalsIgnoreCase(operation))
			{
			   if(form.getChk_1() != null)
			   {
				   for(long id : form.getChk_1())
				   {
					  service.delete(id);
				   }
				   String msg = ms.getMessage("message.deleterecord", null, locale);
					model.addAttribute("success", msg);
			   }else
			   {
				   String msg = ms.getMessage("message.atleastone", null, locale);
					model.addAttribute("error", msg);
			   }
			}
			if(OP_RESET.equalsIgnoreCase(operation))
			{
				return "redirect:/ctl/Course/CourseListCtl";
			}
			if(OP_NEW.equalsIgnoreCase(operation))
			{
				return "redirect:/ctl/Course/AddCourse";
			}
			
			form.setPageNo(pageNo);
			
			list = service.search(dto, pageNo, pageSize);
			model.addAttribute("list", list);
			
			if(list.size()==0 && !OP_DELETE.equalsIgnoreCase(operation))
			{
			  model.addAttribute("error",ms.getMessage("message.norecord", null, locale));	
			}
			
			next = service.search(dto, pageNo+1, pageSize);
			model.addAttribute("nextlistsize", next.size());
			
			
		return "CourseListView";
	   }

}
