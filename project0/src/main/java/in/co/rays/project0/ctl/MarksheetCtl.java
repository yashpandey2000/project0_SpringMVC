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

import in.co.rays.project0.dto.MarksheetDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.form.MarksheetForm;
import in.co.rays.project0.service.MarksheetServiceInt;
import in.co.rays.project0.service.StudentServiceInt;

/**
 * The Class MarksheetCtl.
 */
@Controller
@RequestMapping(value = "/ctl/Marksheet")
public class MarksheetCtl extends BaseCtl {
	
	/** The service. */
	@Autowired
	private MarksheetServiceInt service;
	
	/** The message source. */
	@Autowired
	private MessageSource messageSource;
	
	/** The studetn service. */
	@Autowired
	private StudentServiceInt studetnService;

	/* (non-Javadoc)
	 * @see in.co.rays.project_0.ctl.BaseCtl#preload(org.springframework.ui.Model)
	 */
	public void preload(Model model) {
		List list = studetnService.search(null);
		model.addAttribute("studentList", list);
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
	@RequestMapping(value = "/AddMarksheet", method = RequestMethod.GET)
	public String Display(@RequestParam(required = false) Long id, @ModelAttribute("form") MarksheetForm form,
			Model model, Locale locale) {
		String enterrollno = messageSource.getMessage("label.enterrollno", null, locale);
		model.addAttribute("enterRollNo", enterrollno);

		String enterphysics = messageSource.getMessage("label.enterphysics", null, locale);
		model.addAttribute("enterPhysics", enterphysics);

		String enterchemistry = messageSource.getMessage("label.enterchemistry", null, locale);
		model.addAttribute("enterChemistry", enterchemistry);

		String entermaths = messageSource.getMessage("label.entermaths", null, locale);
		model.addAttribute("enterMaths", entermaths);
		if (id != null && id > 0) {
			MarksheetDTO dto = service.findbypk(id);
			form.populate(dto);

		}
		return "MarksheetView";

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
	@RequestMapping(value = "/AddMarksheet", method = RequestMethod.POST)
	public String submit(@RequestParam(required = false) Long id, @ModelAttribute("form") @Valid MarksheetForm form,
			BindingResult result, Model model, Locale locale) {
		String enterrollno = messageSource.getMessage("label.enterrollno", null, locale);
		model.addAttribute("enterRollNo", enterrollno);

		String enterphysics = messageSource.getMessage("label.enterphysics", null, locale);
		model.addAttribute("enterPhysics", enterphysics);

		String enterchemistry = messageSource.getMessage("label.enterchemistry", null, locale);
		model.addAttribute("enterChemistry", enterchemistry);

		String entermaths = messageSource.getMessage("label.entermaths", null, locale);
		model.addAttribute("enterMaths", entermaths);
		if (OP_SAVE.equalsIgnoreCase(form.getOperation())||OP_UPDATE.equalsIgnoreCase(form.getOperation())) {
			if (result.hasErrors()) {
				return "MarksheetView";
			}
			MarksheetDTO dto = (MarksheetDTO) form.getdto();
			dto.setCreatedBy("root");
			dto.setModifiedBy("root");
			if (id > 0) {
				service.update(dto);
				String msg = messageSource.getMessage("message.updatesuccess", null, locale);
				model.addAttribute("success", msg);

			} else {
				try {
					service.add(dto);
					String msg = messageSource.getMessage("message.success", null, locale);
					model.addAttribute("success", msg);

				} catch (DuplicateRecordException e) {
					// TODO Auto-generated catch block
					String msg = messageSource.getMessage("message.rollno", null, locale);
					model.addAttribute("error", msg);

					e.printStackTrace();
				}

			}
		}
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			System.out.println("Inside Add MArksheet POST RESET");
			return "redirect:/ctl/Marksheet/AddMarksheet";
		}

		if (OP_CANCEL.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/Marksheet/MarksheetListCtl";
		}

		return "MarksheetView";

	}

	/**
	 * Display.
	 *
	 * @param form the form
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/MeritList", method = RequestMethod.GET)
	public String display(@ModelAttribute("form") MarksheetForm form, Model model) {
		
		List list = service.getMeritList(form.getPageNo(), form.getPageSize());
		model.addAttribute("list", list);
		return "MarksheetMeritList";

	}
	
	
	
	@RequestMapping(value = "/MeritList", method = RequestMethod.POST)
	public String submit(@ModelAttribute("form") MarksheetForm form, Model model) {
	
		
		if(OP_BACK.equalsIgnoreCase(form.getOperation())){
			return "redirect:/Welcome";
		}
		else{
		return "MarksheetMeritList";
		}
		

	}

	/**
	 * Display.
	 *
	 * @param form the form
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	@RequestMapping(value = "/GetMarksheet", method = RequestMethod.GET)
	public String display(@ModelAttribute("form") MarksheetForm form, Model model, Locale locale) {
		
		String msg = messageSource.getMessage("label.enterrollno", null, locale);
		model.addAttribute("enterRollNo", msg);
		
		
		return "GetMarksheet";
	}

	/**
	 * Submit.
	 *
	 * @param form the form
	 * @param result the result
	 * @param operation the operation
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	@RequestMapping(value = "/GetMarksheet", method = RequestMethod.POST)
	public String submit(@ModelAttribute("form") @Valid MarksheetForm form, BindingResult result,
			@RequestParam(required = false) String operation, Model model, Locale locale) {
		
		String msg = messageSource.getMessage("label.enterrollno", null, locale);
		model.addAttribute("enterRollNo", msg);
		

		if (OP_SEARCH.equalsIgnoreCase(operation)) {
			if (form.getRollNo() != "") {
				MarksheetDTO dto = service.findbyrollno(form.getRollNo());
				if (dto != null) {
					form.populate(dto);
					model.addAttribute("GetMarksheet",dto);
				} else {
					String msg1 = messageSource.getMessage("error.roll", null, locale);
					model.addAttribute("error", msg1);
				}}


		}
		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Marksheet/GetMarksheet";
		}
		return "GetMarksheet";

	}
	
	/**
	 * Display.
	 *
	 * @param form the form
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value="/MarksheetListCtl" , method=RequestMethod.GET)
	public String display(@ModelAttribute("form") MarksheetForm form,Locale locale,Model model)
	{
		String enterrollno=messageSource.getMessage("label.enterrollno",null,locale);
		model.addAttribute("enterRollNo",enterrollno);
		String entername=messageSource.getMessage("label.studentName",null,locale);
		model.addAttribute("enterName",entername);
		
		
		int pageNo=1;
		
		List list = service.search(new MarksheetDTO(), pageNo, form.getPageSize());
		model.addAttribute("list",list);
		
		List next = service.search(new MarksheetDTO(), pageNo+1,form.getPageSize());
		model.addAttribute("nextlistsize", next.size());
		
		return "MarksheetListView";	
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
	@RequestMapping(value="/MarksheetListCtl" , method=RequestMethod.POST)
	public String submit(@RequestParam(required=false) String operation,@ModelAttribute("form") MarksheetForm form,Model model , Locale locale)
	{
		String sno = messageSource.getMessage("label.sno", null, locale);
		model.addAttribute("sno", sno);
		String enterrollno=messageSource.getMessage("label.enterrollno",null,locale);
		model.addAttribute("enterRollNo",enterrollno);
		String entername=messageSource.getMessage("label.studentName",null,locale);
		model.addAttribute("enterName",entername);
		
		int pageNo = (form.getPageNo()==0) ? 1: form.getPageNo();
		
		int pageSize = form.getPageSize();
		
		List list = null;
		List next = null;
		
		MarksheetDTO dto = (MarksheetDTO) form.getdto();
		
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
		if(OP_DELETE.equalsIgnoreCase(operation))
		{
		   if(form.getChk_1()!=null)
		   {
			   for(long id:form.getChk_1()){
	    			service.delete(id);
	    		}
			   String msg = messageSource.getMessage("message.deleterecord", null, locale);
				model.addAttribute("success", msg);
	    	}else {
	    		String msg = messageSource.getMessage("message.atleastone", null, locale);
				model.addAttribute("error", msg);
	    	}
		}
		if(OP_RESET.equalsIgnoreCase(operation))
		{
			return "redirect:/ctl/Marksheet/MarksheetListCtl";
		}
		if(OP_NEW.equalsIgnoreCase(operation))
		{
			return "redirect:/ctl/Marksheet/AddMarksheet";
		}
		
		
		form.setPageNo(pageNo);
		list = service.search(dto, pageNo, pageSize);
		
		if(list.size()==0 && !OP_DELETE.equalsIgnoreCase(operation))
		{
		  model.addAttribute("error",messageSource.getMessage("message.norecord", null, locale));	
		}
		
		next = service.search(dto, pageNo+1, pageSize);
		
		model.addAttribute("list",list);
		model.addAttribute("nextlistsize", next.size());
		
		return "MarksheetListView";
	}
	


}
