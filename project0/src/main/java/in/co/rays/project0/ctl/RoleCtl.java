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

import in.co.rays.project0.dto.RoleDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.form.RoleForm;
import in.co.rays.project0.service.RoleServiceInt;


/**
 * The Class RoleCtl.
 */

@Controller
@RequestMapping(value = "/ctl/Role")
public class RoleCtl extends BaseCtl{
	
	/** The service. */
	@Autowired
  private RoleServiceInt service ; 
	
	/** The message source. */
	@Autowired
  private MessageSource ms ; 
	
	
	/**
	 * Display.
	 *
	 * @param id the id
	 * @param form the form
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	
	@RequestMapping(value = "AddRole" , method= RequestMethod.GET)
	public String display(@RequestParam(required = false) Long id , @ModelAttribute("form") RoleForm form , Model model , Locale locale ){
		
	String name = ms.getMessage("label.enterrname", null , locale);	
	model.addAttribute("enterName", name);	
	
	String desc = ms.getMessage("label.enterrdescription", null , locale);
	model.addAttribute("enterdescription", desc);
	
	if(id!=null && id > 0){
		RoleDTO dto = service.findByPK(id);
		form.populate(dto);
	}
		return "RoleView";
		
		
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
	
	@RequestMapping(value = "/AddRole" , method = RequestMethod.POST)
	public String submit(@RequestParam(required = false) long id , @ModelAttribute("form") @Valid RoleForm form ,BindingResult result , Locale locale , Model model ){
		
		String name = ms.getMessage("label.enterrname", null , locale);
		model.addAttribute("enterName", name);
		
		String desc = ms.getMessage("label.enterrdescription", null , locale);
		model.addAttribute("enterdescription", desc);
		
		if(OP_SAVE.equalsIgnoreCase(form.getOperation()) || OP_UPDATE.equalsIgnoreCase(form.getOperation())){
			
			if(result.hasErrors()){
				return "RoleView";
			}
			
			RoleDTO dto = (RoleDTO) form.getdto();
			dto.setCreatedBy("root");
			dto.setModifiedBy("root");
			
			if(id>0){
				
				try {
					service.update(dto);
					
					String msg = ms.getMessage("message.updatesuccess", null , locale);
					model.addAttribute("success", msg);
				} catch (DuplicateRecordException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					String msg = ms.getMessage("error.rolename", null , locale);
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
					
					String msg = ms.getMessage("error.rolename", null, locale );
					model.addAttribute("error", msg);
				}
				
				
			}
			
		}
		
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			System.out.println("Inside Role Ctl Reset");
			return "redirect:/ctl/Role/AddRole";
		
		}
		
		if (OP_CANCEL.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/Role/RoleListCtl";
		}
		
		
		return "RoleView" ;
		
	}
	
	
	
	
	/**
	 * Display.
	 *
	 * @param form the form
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	
	
	@RequestMapping(value = "/RoleListCtl" , method = RequestMethod.GET)
	public String display(@ModelAttribute("form") RoleForm form , Model model , Locale locale){
		
		String name = ms.getMessage("label.enterrname", null , locale);
		model.addAttribute("enterName", name);
		
		String no = ms.getMessage("label.sno", null , locale);
		model.addAttribute("sno", no);
		
		int pageNo = 1;
		
		List list = service.search(new RoleDTO(), form.getPageNo(), form.getPageSize());
		model.addAttribute("list", list);
		
		List next = service.search(new RoleDTO(), pageNo+1, form.getPageSize());
		model.addAttribute("nextlistsize",next.size());
		
		
		return "RoleListView";
		
	}
	
	
	
	/**
	 * Submit.
	 *
	 * @param operation the operation
	 * @param form the form
	 * @param result the result
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	
	
	@RequestMapping(value="/RoleListCtl" , method = RequestMethod.POST)
	public String submit(@RequestParam() String operation , @ModelAttribute("form") RoleForm form , BindingResult result , Model model , Locale locale){
		
		String entername = ms.getMessage("label.enterrname", null, locale);
		model.addAttribute("enterName", entername);
		
		String no = ms.getMessage("label.sno", null , locale);
		model.addAttribute("sno", no);
		
		int pageNo = (form.getPageNo()==0) ? 1 : form.getPageNo();
		int pageSize = form.getPageSize();
		
		List list = null;
		List next = null;
		
		RoleDTO dto = (RoleDTO) form.getdto();
		
		if(OP_SEARCH.equalsIgnoreCase(operation)){
			pageNo = 1;
		}
		
		if(OP_PREVIOUS.equalsIgnoreCase(operation)){
			pageNo--;
		}
		if(OP_NEXT.equalsIgnoreCase(operation)){
			pageNo++;
		}
		if(OP_DELETE.equalsIgnoreCase(operation)){
			if(form.getChk_1()!=null){
				for (Long id : form.getChk_1()) {
					service.delete(id);
				}
				
				String msg = ms.getMessage("message.deleterecord", null , locale);
				model.addAttribute("success", msg);
				
			}else{
				
				String msg = ms.getMessage("message.atleastone", null , locale);
				model.addAttribute("error", msg);
			}
		}
		
		if(OP_RESET.equalsIgnoreCase(operation)){
			return "redirect:/ctl/Role/RoleListCtl"; 
		}
		if (OP_NEW.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Role/AddRole";
		}
		
		form.setPageNo(pageNo);
		list = service.search(dto, pageNo, pageSize);
		model.addAttribute("list", list);
		
		if(list.size()==0 && !OP_DELETE.equalsIgnoreCase(operation)){
			model.addAttribute("error",ms.getMessage("message.norecord", null , locale));
		}
		
		next = service.search(dto, pageNo+1, pageSize);
		model.addAttribute("nextlistsize", next.size());
		
		return "RoleListView";
		
	}
	

}
