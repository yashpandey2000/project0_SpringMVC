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

import in.co.rays.project0.dto.CollegeDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.form.CollegeForm;
import in.co.rays.project0.service.CollegeServiceInt;


/**
 * The Class CollegeCtl.
 */

@Controller
@RequestMapping(value="/ctl/College")
public class CollegeCtl  extends BaseCtl{
	
	/** The service. */
	@Autowired
	private CollegeServiceInt service;
	/** The message source. */
	@Autowired
	private MessageSource ms;
	
	
	/**
	 * Display.
	 *
	 * @param id the id
	 * @param form the form
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	@RequestMapping(value="/AddCollege" , method=RequestMethod.GET)
	public String display(@RequestParam(required=false) Long id , @ModelAttribute("form") CollegeForm form ,Model model , Locale locale ){
		
		String name = ms.getMessage("label.entercname", null , locale);
		model.addAttribute("entername", name);
		
		String address = ms.getMessage("label.enteraddress", null , locale);
		model.addAttribute("enteraddress", address);
		
		String state = ms.getMessage("label.enterstate", null , locale);
		model.addAttribute("enterstate", state);
		
		String city = ms.getMessage("label.entercity", null , locale) ;
		model.addAttribute("entercity", city);
		
		String phone = ms.getMessage("label.enterphone", null , locale);
		model.addAttribute("enterphone", phone);
		
		if(id!=null && id>0){
			CollegeDTO dto = service.findbypk(id);
			form.populate(dto);
		}
		
		return "CollegeView";
		
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
	@RequestMapping(value="AddCollege" , method=RequestMethod.POST)
	public String submit(@RequestParam (required = false) long id, @ModelAttribute("form") @Valid CollegeForm form , BindingResult result, Locale locale , Model model){
		
		String name = ms.getMessage("label.entercname", null , locale);
		model.addAttribute("entername", name);
		
		String address = ms.getMessage("label.enteraddress", null , locale);
		model.addAttribute("enteraddress" , address);
		
		String state = ms.getMessage("label.enterstate", null , locale);
		model.addAttribute("enterstate", state);
		
		String city = ms.getMessage("label.entercity", null , locale);
		model.addAttribute("entercity", city);
		
		String phone = ms.getMessage("label.enterphone", null , locale);
		model.addAttribute("enterphone", phone);
		
		if(OP_SAVE.equalsIgnoreCase(form.getOperation()) || OP_UPDATE.equalsIgnoreCase(form.getOperation())){
			if(result.hasErrors()){
				return "CollegeView";
			}
			
			CollegeDTO dto = (CollegeDTO) form.getdto();
			dto.setCreatedBy("root");
			dto.setModifiedBy("root");
			
			if(id>0){
				service.update(dto);
				String msg = ms.getMessage("message.updatesuccess", null , locale);
				model.addAttribute("success", msg);
			}else{
				
				try {
					service.add(dto);
					String msg = ms.getMessage("message.success", null , locale );
					model.addAttribute("success", msg);
				} catch (DuplicateRecordException e) {
					// TODO Auto-generated catch block
					String msg = ms.getMessage("error.collegename", null , locale);
					model.addAttribute("error", msg);
				}
			}
		}
		
		if(OP_RESET.equalsIgnoreCase(form.getOperation())){
			return"redirect:/ctl/College/AddCollege";
		}
		
		if(OP_CANCEL.equalsIgnoreCase(form.getOperation())){
			return "redirect:/ctl/College/CollegeListCtl";
		}
		
		
		
		return "CollegeView";
		
	}
	
	
	/**
	 * Display.
	 *
	 * @param form the form
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	
	@RequestMapping(value="/CollegeListCtl" , method=RequestMethod.GET)
	public String Display( @ModelAttribute("form") CollegeForm form , Model model , Locale locale){
		
		String name = ms.getMessage("label.entercname", null , locale );
		model.addAttribute("enterName", name );
		
		String state = ms.getMessage("label.enterstate", null , locale);
		model.addAttribute("enterState", state );
		
		List list = service.search(new CollegeDTO(),form.getPageNo(), form.getPageSize());
		model.addAttribute("list",list);
		
		List nextlist = service.search(new CollegeDTO(), form.getPageNo()+1, form.getPageSize());
		model.addAttribute("nextlistsize", nextlist.size());
		
		return "CollegeListView";
		
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
	@RequestMapping(value = "/CollegeListCtl", method = RequestMethod.POST)
	public String submit(@RequestParam(required = false) String operation, @ModelAttribute("form") CollegeForm form,
			BindingResult result, Model model, Locale locale) {
		String enterName = ms.getMessage("label.entercname", null, locale);
		model.addAttribute("enterName", enterName);
		String enterstate = ms.getMessage("label.enterstate", null, locale);
		model.addAttribute("enterState", enterstate);

		String sno = ms.getMessage("label.sno", null, locale);
		model.addAttribute("sno", sno);
		int pageNo = (form.getPageNo() == 0) ? 1 : form.getPageNo();
		int pageSize = form.getPageSize();
		List list = null;
		List nextlistsize = null;
		CollegeDTO dto = (CollegeDTO) form.getdto();
		if (OP_SEARCH.equalsIgnoreCase(operation)) {
			pageNo = 1;
		}
		if (OP_PREVIOUS.equalsIgnoreCase(operation)) {
			pageNo--;
			System.out.println("page No POST--->" + pageNo);
		}
		if (OP_NEXT.equalsIgnoreCase(operation)) {
			pageNo++;
			System.out.println("page No POST--->" + pageNo);
		}
		if (OP_DELETE.equalsIgnoreCase(operation)) {
			if (form.getChk_1() != null) {
				for (Long id : form.getChk_1()) {
					service.delete(id);
				}
				String msg = ms.getMessage("message.deleterecord", null, locale);
				model.addAttribute("success", msg);
			} else {
				String msg = ms.getMessage("message.atleastone", null, locale);
				model.addAttribute("error", msg);

			}
		}
		if (OP_NEW.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/College/AddCollege";
		}
		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/College/CollegeListCtl";
		}
		form.setPageNo(pageNo);
		list = service.search(dto, pageNo, pageSize);
		model.addAttribute("list", list);
		nextlistsize = service.search(dto, pageNo + 1, pageSize);
		model.addAttribute("nextlistsize", nextlistsize.size());
		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation))
		{
			model.addAttribute("error", ms.getMessage("message.norecord", null, locale));
		}

		return "CollegeListView";
	}
}
