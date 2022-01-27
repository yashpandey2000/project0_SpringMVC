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

import in.co.rays.project0.dto.SubjectDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.form.SubjectForm;
import in.co.rays.project0.service.CourseServiceInt;
import in.co.rays.project0.service.SubjectServiceInt;

/**
 * The Class SubjectCtl.
 */
@Controller
@RequestMapping(value="/ctl/Subject")
public class SubjectCtl extends BaseCtl{
	
	/** The service. */
	@Autowired
	private SubjectServiceInt service;
	
	/** The message source. */
	@Autowired
	private MessageSource messageSource;
	
	/** The course service. */
	@Autowired
	private CourseServiceInt courseService;
	
	/* (non-Javadoc)
	 * @see in.co.rays.project_0.ctl.BaseCtl#preload(org.springframework.ui.Model)
	 */
	public void preload(Model model) {
		
		List list1 = courseService.search(null);
		model.addAttribute("courseList", list1);

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
	@RequestMapping(value="/AddSubject", method=RequestMethod.GET)
	public String display(@RequestParam(required=false) Long id,@ModelAttribute("form") SubjectForm form,Model model,Locale locale){
		   String entername=messageSource.getMessage("label.entersubjectname",null,locale);
			model.addAttribute("enterName",entername);
			String enterdescription=messageSource.getMessage("label.enterdescription",null,locale);
			model.addAttribute("enterdescription",enterdescription);
		   
            if(id!=null&&id>0){
            
            	SubjectDTO dto=service.findbypk(id);
            	System.out.println("in get method"+id+"...."+dto);
            	form.populate(dto);
            }
            return "SubjectView";
		
	}

	   /**
   	 * Submit.
   	 *
   	 * @param id the id
   	 * @param form the form
   	 * @param result the result
   	 * @param model the model
   	 * @param locale the locale
   	 * @return the string
   	 */
   	@RequestMapping(value="/AddSubject" , method=RequestMethod.POST)
	   public String submit(@RequestParam(required = false) Long id,@ModelAttribute("form") @Valid SubjectForm form , BindingResult result , Model model , Locale locale)
	   {
		   String entername=messageSource.getMessage("label.entersubjectname",null,locale);
			model.addAttribute("enterName",entername);
			String enterdescription=messageSource.getMessage("label.enterdescription",null,locale);
			model.addAttribute("enterdescription",enterdescription);
		   if(OP_SAVE.equalsIgnoreCase(form.getOperation())||OP_UPDATE.equalsIgnoreCase(form.getOperation())){
			  
			if(result.hasErrors()){
				return "SubjectView";
			}
			 System.out.println("in subject method "+id+"...");
			
			SubjectDTO dto=(SubjectDTO) form.getdto();
			dto.setCreatedBy("root");
			dto.setModifiedBy("root");
			
			if(id>0){
				try {
					service.update(dto);
				} catch (DuplicateRecordException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					String msg = messageSource.getMessage("error.subjectname", null,locale);
				    model.addAttribute("error", msg);
				}
				   String msg = messageSource.getMessage("message.updatesuccess", null,locale);
			       model.addAttribute("success", msg);

				
			}else{
				try {
					service.add(dto);
					
					String msg = messageSource.getMessage("message.success", null,locale);
				    model.addAttribute("success", msg);
				} catch (DuplicateRecordException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					String msg = messageSource.getMessage("error.subjectname", null,locale);
				    model.addAttribute("error", msg);
				}
			}
			
			}
		   if(OP_CANCEL.equalsIgnoreCase(form.getOperation()))
		   {
			   return "redirect:/ctl/Subject/SubjectListCtl";
		   }
		   if(OP_RESET.equalsIgnoreCase(form.getOperation()))
		   {
			   return "redirect:/ctl/Subject/AddSubject";
		   }
		  return "SubjectView";   

		   
	   }

	   /**
   	 * Display.
   	 *
   	 * @param form the form
   	 * @param model the model
   	 * @param locale the locale
   	 * @return the string
   	 */
   	@RequestMapping(value="/SubjectListCtl" , method=RequestMethod.GET)
	   public String display(@ModelAttribute("form") SubjectForm form , Model model , Locale locale)
	   {
		   String enterName = messageSource.getMessage("label.entersubjectname", null, locale);
		   model.addAttribute("enterName",enterName);
		   
		   String sno = messageSource.getMessage("label.sno", null, locale);
			model.addAttribute("sno", sno);
		  
			int pageNo=1;
		   
		   List list = service.search(new SubjectDTO(), pageNo, form.getPageSize());
		   model.addAttribute("list",list);
		   
		   List nextlistsize = service.search(new SubjectDTO(), pageNo+1, form.getPageSize());
		   model.addAttribute("nextlistsize",nextlistsize.size());
		   
		return "SubjectListView";
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
   	@RequestMapping(value="/SubjectListCtl" , method=RequestMethod.POST)
	   public String submit(@RequestParam(required=false) String operation,@ModelAttribute("form") SubjectForm form,Model model,Locale locale)
	   {
		   
   	 String enterName = messageSource.getMessage("label.entersubjectname", null, locale);
	   model.addAttribute("enterName",enterName);
	   
	   String sno = messageSource.getMessage("label.sno", null, locale);
		model.addAttribute("sno", sno);
		   
		   int pageNo = (form.getPageNo()==0)?1:form.getPageNo();
		   int pageSize = form.getPageSize();
		   
		   form.setPageNo(pageNo);
		   
		   List list = null;
		   List nextlistsize = null;
		   
		   SubjectDTO dto = (SubjectDTO) form.getdto();
		   
		   if(OP_SEARCH.equalsIgnoreCase(operation))
		   {
			   pageNo=1;
		   }
		   if(OP_PREVIOUS.equalsIgnoreCase(operation))
		   {
			   pageNo--;
		   }
		   if(OP_NEXT.equalsIgnoreCase(operation))
		   {
			   pageNo++;
		   }
		   if(OP_DELETE.equalsIgnoreCase(operation)){
		    	if(form.getChk_1()!=null){
		    		for (long id : form.getChk_1()) {
						service.delete(id);
					}
		    		
		    		String msg = messageSource.getMessage("message.deleterecord", null , locale);
		    		model.addAttribute("success", msg);
		    	}
		    	
		    	else{
		    		
		    		String msg = messageSource.getMessage("message.atleastone",null , locale);
		    		model.addAttribute("error", msg);
		    	}
		    }
		   if(OP_NEW.equalsIgnoreCase(operation))
		   {
			   return "redirect:/ctl/Subject/AddSubject";
		   }
		   if(OP_RESET.equalsIgnoreCase(operation))
		   {
			   return "redirect:/ctl/Subject/SubjectListCtl";
		   }
		   
		   form.setPageNo(pageNo);
		    list = service.search(dto, pageNo, form.getPageSize());
			model.addAttribute("list", list);
			
			nextlistsize = service.search(dto, pageNo + 1, form.getPageSize());
			model.addAttribute("nextlistsize", nextlistsize.size());
			
			if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation))
			{
				model.addAttribute("error", messageSource.getMessage("message.norecord", null, locale));
			}
		   
		return "SubjectListView";
	   }
	   

	   
	   
	   
	   
	   
	

}
