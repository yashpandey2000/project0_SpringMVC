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

import in.co.rays.project0.dto.TimetableDTO;
import in.co.rays.project0.dto.UserDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.form.TimetableForm;
import in.co.rays.project0.service.CourseServiceInt;
import in.co.rays.project0.service.SubjectServiceInt;
import in.co.rays.project0.service.TimetableServiceInt;

/**
 * The Class TimetableCtl.
 */
@Controller
@RequestMapping(value = "/ctl/Timetable")
public class TimetableCtl extends BaseCtl {

	/** The service. */
	@Autowired
	private TimetableServiceInt service;
	
	/** The message source. */
	@Autowired
	private MessageSource messageSource;
	
	/** The couservice. */
	@Autowired
	private CourseServiceInt couservice;

	/** The subservice. */
	@Autowired
	private SubjectServiceInt subservice;

	/* (non-Javadoc)
	 * @see in.co.rays.project_0.ctl.BaseCtl#preload(org.springframework.ui.Model)
	 */
	public void preload(Model model) {
		List list1 = couservice.search(null);
		model.addAttribute("courseList", list1);

		List list2 = subservice.search(null);
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
	@RequestMapping(value = "/AddTimetable", method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") TimetableForm form,
			Model model, Locale locale) {
		String entername = messageSource.getMessage("label.enterexamdate", null, locale);
		model.addAttribute("enterDate", entername);

		String enterdescription = messageSource.getMessage("label.enterdescription", null, locale);
		model.addAttribute("enterdescription", enterdescription);

		if (id != null && id > 0) {
			TimetableDTO dto = service.findbypk(id);
			form.populate(dto);
		}

		return "TimetableView";
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
	@RequestMapping(value = "/AddTimetable", method = RequestMethod.POST)
	public String submit(@RequestParam(required = false) Long id, @ModelAttribute("form") @Valid TimetableForm form,
			BindingResult result, Model model, Locale locale) {
		String entername = messageSource.getMessage("label.enterexamdate", null, locale);
		model.addAttribute("enterDate", entername);

		String enterdescription = messageSource.getMessage("label.enterdescription", null, locale);
		model.addAttribute("enterdescription", enterdescription);
		if (OP_SAVE.equalsIgnoreCase(form.getOperation())||OP_UPDATE.equalsIgnoreCase(form.getOperation())) {

		if (result.hasErrors()) {
				return "TimetableView";
			}
			
			
		
			TimetableDTO dto = (TimetableDTO) form.getdto();

			dto.setCreatedBy("root");
			dto.setModifiedBy("root");
			if (id > 0) {

				try {
					service.update(dto);
					String msg = messageSource.getMessage("message.updatesuccess", null, locale);
					model.addAttribute("success", msg);

				} catch (DuplicateRecordException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					String msg = messageSource.getMessage("error.record", null, locale);
					model.addAttribute("error", msg);
				}

			} else {
				try {
					System.out.println("in time add method");
					service.add(dto);

					String msg = messageSource.getMessage("message.success", null, locale);
					model.addAttribute("success", msg);
				} catch (DuplicateRecordException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					String msg = messageSource.getMessage("error.record", null, locale);
					model.addAttribute("error", msg);
				}

			}

		}
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/Timetable/AddTimetable";
		}
		if (OP_CANCEL.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/Timetable/TimetableListCtl";
		}

		return "TimetableView";

	}

	/**
	 * Display.
	 *
	 * @param form the form
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	@RequestMapping(value = "/TimetableListCtl", method = RequestMethod.GET)
	public String display(@ModelAttribute("form") TimetableForm form, Model model, Locale locale) {

		String entername = messageSource.getMessage("label.enterexamdate", null, locale);
		model.addAttribute("enterDate", entername);
		
		int pageNo = 1;
		
		List list = service.search(new TimetableDTO(), form.getPageNo(), form.getPageSize());
		model.addAttribute("list", list);
		
		List next = service.search(new TimetableDTO(), pageNo + 1, form.getPageSize());
		model.addAttribute("nextlistsize", next.size());

		return "TimetableListView";
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
	@RequestMapping(value = "/TimetableListCtl", method = RequestMethod.POST)
	public String submit(@RequestParam(required = false) String operation, @ModelAttribute("form") TimetableForm form,
			Model model, Locale locale) {

		String entername = messageSource.getMessage("label.enterexamdate", null, locale);
		model.addAttribute("enterDate", entername);
		
		String sno = messageSource.getMessage("label.sno", null, locale);
		model.addAttribute("sno", sno);
		
		int pageNo = (form.getPageNo()==0)?1:form.getPageNo();
		int pageSize = form.getPageSize();

		
		List list = null;
		List nextlistsize = null;
		

		if (OP_SEARCH.equalsIgnoreCase(operation)) {
			pageNo = 1;
		}
		if (OP_PREVIOUS.equalsIgnoreCase(operation)) {
			pageNo--;
		}
		if (OP_NEXT.equalsIgnoreCase(operation)) {
			pageNo++;
		}
		if (OP_DELETE.equalsIgnoreCase(operation)) {
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
		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Timetable/TimetableListCtl";
		}
		if (OP_NEW.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Timetable/AddTimetable";
		}

		form.setPageNo(pageNo);
		
		TimetableDTO dto1 = (TimetableDTO)form.getdto();

		 list = service.search(dto1, pageNo, pageSize);
		 model.addAttribute("list", list);

		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error", messageSource.getMessage("message.norecord", null, locale));
		}

	   nextlistsize = service.search(dto1, pageNo + 1, pageSize);
		model.addAttribute("nextlistsize", nextlistsize.size());

		System.out.println("nextlistsize" + nextlistsize.size());

		return "TimetableListView";
	}

}
