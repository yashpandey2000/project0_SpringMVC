/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.ctl;

import java.util.HashMap;
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

import in.co.rays.project0.dto.FacultyDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.form.FacultyForm;
import in.co.rays.project0.service.CollegeServiceInt;
import in.co.rays.project0.service.CourseServiceInt;
import in.co.rays.project0.service.FacultyServiceInt;
import in.co.rays.project0.service.SubjectServiceInt;

/**
 * The Class FacultyCtl.
 */
@Controller
@RequestMapping(value = "/ctl/Faculty")
public class FacultyCtl extends BaseCtl {

	/** The service. */
	@Autowired
	private FacultyServiceInt service;
	
	/** The message source. */
	@Autowired
	private MessageSource messageSource;
	
	/** The college service. */
	@Autowired
	private CollegeServiceInt collegeService;
	
	/** The course service. */
	@Autowired
	private CourseServiceInt courseService;
	
	/** The subject service. */
	@Autowired
	private SubjectServiceInt subjectService;

	/**
	 * Gets the gender list.
	 *
	 * @return the gender list
	 */
	@ModelAttribute("genderList")
	public Map<String, String> getGenderList() {
		Map<String, String> genderList = new HashMap<String, String>();
		genderList.put("Male", "Male");
		genderList.put("Female", "Female");
		return genderList;
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project_0.ctl.BaseCtl#preload(org.springframework.ui.Model)
	 */
	@Override
	public void preload(Model model) {
		List list = collegeService.search(null);
		model.addAttribute("collegeList", list);

		List list1 = courseService.search(null);
		model.addAttribute("courseList", list1);

		List list2 = subjectService.search(null);
		model.addAttribute("subjectList", list2);

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
	@RequestMapping(value = "/AddFaculty", method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") FacultyForm form,
			Model model, Locale locale) {
		String enteremail = messageSource.getMessage("label.enteremail", null, locale);
		model.addAttribute("enteremail", enteremail);

		String enterdob = messageSource.getMessage("label.enterdob", null, locale);
		model.addAttribute("enterdob", enterdob);

		String enterfirstName = messageSource.getMessage("label.enterfname", null, locale);
		model.addAttribute("enterfirstName", enterfirstName);

		String enterLastName = messageSource.getMessage("label.enterlname", null, locale);
		model.addAttribute("enterLastName", enterLastName);

		String enterMobile = messageSource.getMessage("label.entermob", null, locale);
		model.addAttribute("enterMobile", enterMobile);

		if (id != null && id > 0) {
			FacultyDTO dto = service.findbypk(id);
			form.populate(dto);
		}

		return "FacultyView";
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
	@RequestMapping(value = "/AddFaculty", method = RequestMethod.POST)
	public String submit(@ModelAttribute("form") @Valid FacultyForm form, BindingResult result, Model model,
			Locale locale) {
		String enteremail = messageSource.getMessage("label.enteremail", null, locale);
		model.addAttribute("enteremail", enteremail);

		String enterdob = messageSource.getMessage("label.enterdob", null, locale);
		model.addAttribute("enterdob", enterdob);

		String enterfirstName = messageSource.getMessage("label.enterfname", null, locale);
		model.addAttribute("enterfirstName", enterfirstName);

		String enterLastName = messageSource.getMessage("label.enterlname", null, locale);
		model.addAttribute("enterLastName", enterLastName);

		String enterMobile = messageSource.getMessage("label.entermob", null, locale);
		model.addAttribute("enterMobile", enterMobile);
		FacultyDTO dto1 = (FacultyDTO) form.getdto();
		System.out.println("in faculty"+form.getOperation()+"..."+dto1.getId());
		
		
		if (OP_SAVE.equalsIgnoreCase(form.getOperation())||OP_UPDATE.equalsIgnoreCase(form.getOperation())) {
			if (result.hasErrors()) {
				return "FacultyView";
			}

			FacultyDTO dto = (FacultyDTO) form.getdto();
			dto.setCreatedBy("root");
			dto.setModifiedBy("root");

			if (dto.getId() > 0) {
				System.out.println("in update method");
				service.update(dto);
				String msg = messageSource.getMessage("message.updatesuccess", null, locale);
				model.addAttribute("success", msg);
			} else {
				try {
					service.add(dto);
					String msg = messageSource.getMessage("message.success", null, locale);
					model.addAttribute("success", msg);
				} catch (DuplicateRecordException e) {
					e.printStackTrace();
					String msg = messageSource.getMessage("error.loginid", null, locale);
					model.addAttribute("error", msg);
				}
			}
		}

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/Faculty/AddFaculty";
		}
		if (OP_CANCEL.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/Faculty/FacultyListCtl";
		}

		return "FacultyView";
	}

	/**
	 * Display.
	 *
	 * @param form the form
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	@RequestMapping(value = "/FacultyListCtl", method = RequestMethod.GET)
	public String display(@ModelAttribute("form") FacultyForm form, Model model, Locale locale) {
		String enterFName = messageSource.getMessage("label.firstName", null, locale);
		model.addAttribute("enterFName", enterFName);

		String enterLName = messageSource.getMessage("label.lastName", null, locale);
		model.addAttribute("enterLName", enterLName);

		String enterEmail = messageSource.getMessage("label.emailId", null, locale);
		model.addAttribute("enterEmail", enterEmail);

		model.addAttribute("list", service.search(null, form.getPageNo(), form.getPageSize()));
		int pageNo = 1;
		List next = service.search(new FacultyDTO(), pageNo + 1, form.getPageSize());
		model.addAttribute("nextlistsize", next.size());

		return "FacultyListView";
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
	@RequestMapping(value = "/FacultyListCtl", method = RequestMethod.POST)
	public String submit(@RequestParam(required = false) String operation, @ModelAttribute("form") FacultyForm form,
			Model model, Locale locale) {
		String sno = messageSource.getMessage("label.sno", null, locale);
		model.addAttribute("sno", sno);
		
		String enterFName = messageSource.getMessage("label.firstName", null, locale);
		model.addAttribute("enterFName", enterFName);

		String enterLName = messageSource.getMessage("label.lastName", null, locale);
		model.addAttribute("enterLName", enterLName);

		String enterEmail = messageSource.getMessage("label.emailId", null, locale);
		model.addAttribute("enterEmail", enterEmail);

		int pageNo = form.getPageNo();
		if (OP_PREVIOUS.equalsIgnoreCase(operation)) {
			pageNo--;
		} else if (OP_NEXT.equalsIgnoreCase(operation)) {
			pageNo++;
		} else if (OP_DELETE.equalsIgnoreCase(operation)) {
			if (form.getChk_1() != null) {
				for (long id : form.getChk_1()) {
					service.delete(id);
				}
				String msg = messageSource.getMessage("message.deleterecord", null, locale);
				model.addAttribute("success", msg);
			} else {
				String msg = messageSource.getMessage("message.atleastone", null, locale);
				model.addAttribute("error", msg);
			}
		}
		pageNo = (pageNo < 1) ? 1 : pageNo;
		form.setPageNo(pageNo);
		FacultyDTO dto = (FacultyDTO) form.getdto();
		List list = service.search(dto, pageNo, form.getPageSize());
		model.addAttribute("list", list);
		List next = service.search(dto, pageNo + 1, form.getPageSize());
		model.addAttribute("nextlistsize", next.size());
		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error", messageSource.getMessage("message.norecord", null, locale));
		}
		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Faculty/FacultyListCtl";
		} else if (OP_NEW.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Faculty/AddFaculty";
		}

		return "FacultyListView";
	}

}
