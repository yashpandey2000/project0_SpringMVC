/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.ctl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.co.rays.project0.dto.RoleDTO;
import in.co.rays.project0.dto.UserDTO;
import in.co.rays.project0.exception.ApplicationException;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.form.ForgetPasswordForm;
import in.co.rays.project0.form.LoginForm;
import in.co.rays.project0.form.UserRegistrationForm;
import in.co.rays.project0.service.UserServiceInt;


/**
 * The Class LoginCtl.
 */

@Controller
public class LoginCtl extends BaseCtl{
	
	protected static final String OP_SIGNIN = "SignIn";
	
	protected static final String OP_SIGNUP = "SignUp";
	
	/** The service. */
	@Autowired
	private UserServiceInt service;
	
	/** The message source. */
	@Autowired
	private MessageSource ms;
	
	
	/**
	 * Gets the gender list.
	 *
	 * @return the gender list
	 */
	
	@ModelAttribute(value="genderList")
	public Map<String,String> getgenderList(){
		Map<String,String> genderlist = new HashMap<String, String>();
		genderlist.put("Male","Male");
		genderlist.put("Female", "Female");
		return genderlist;
		
	}
	
	
	/**
	 * Display.
	 *
	 * @param form the form
	 * @param session the session
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	
	@RequestMapping(value="/Login" , method=RequestMethod.GET)
	public String Display(@ModelAttribute("form") LoginForm form , HttpSession session , Model model,Locale locale){
		String entermail = ms.getMessage("label.enteremail",null,locale);		
		model.addAttribute("enteremail", entermail);
		
		String enterpassword = ms.getMessage("label.enterpassword", null, locale);
		model.addAttribute("enterpassword",enterpassword);
		
		if(session.getAttribute("user")!=null){
			session.invalidate();
			String msg  = ms.getMessage("label.logout",null , locale);
		   model.addAttribute("success",msg);
		}
		
		return "LoginView";
		
	}
	
	
	/**
	 * Submit.
	 *
	 * @param locale the locale
	 * @param form the form
	 * @param bindingResult the binding result
	 * @param session the session
	 * @param request the request
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String submit(Locale locale, @ModelAttribute("form") @Valid LoginForm form, BindingResult bindingResult,
			HttpSession session, HttpServletRequest request, Model model) {
		System.out.println("in method" + form.getOperation());
		
		String enterEmail = ms.getMessage("label.enteremail", null, locale);
		model.addAttribute("enteremail", enterEmail);

		String enterPassword = ms.getMessage("label.enterpassword", null, locale);
		model.addAttribute("enterpassword", enterPassword);

		if (OP_SIGNIN.equalsIgnoreCase(form.getOperation())) {
			System.out.println("in login method" + form.getOperation());
			if (bindingResult.hasErrors()) {

				return "LoginView";
			}
			UserDTO dto = new UserDTO();

			dto.setPassword(form.getPassword());
			dto.setLogin(form.getEmailId());
			dto = service.authenticate(dto);
			
			System.out.println("in again ..." + dto);
			if (dto != null) {
				UserDTO udto = service.findbypk(dto.getId());
				dto.setLastLogin(new Timestamp(new Date().getTime()));
				//dto.setLastLoginIP(request.getRemoteAddr());
				
				service.update(udto);
				session.setAttribute("user", dto);
				RoleDTO rdto = service.getrole(dto);
				System.out.println("----------------------------"+rdto.getRoleName());
				session.setAttribute("role", rdto.getRoleName());
				if (form.getUri() == "" || form.getUri() == null) {
					return "redirect:/Welcome";
				} else {
					return "redirect:/" + form.getUri().replace("/project0/", "");
				}
			} else {
				String msg = ms.getMessage("login.error", null, locale);
				model.addAttribute("error", msg);
			}
		}
		if (OP_SIGNUP.equalsIgnoreCase(form.getOperation())) {

			return "redirect:/Registration";
		}
		System.out.println("operation" + OP_FORGET + ".." + form.getOperation());
		if (OP_FORGET.equalsIgnoreCase(form.getOperation())) {

			return "redirect:/ForgetPassword";
		}
		return "LoginView";
	}

	/**
	 * Display.
	 *
	 * @param model the model
	 * @param form the form
	 * @param locale the locale
	 * @return the string
	 */
	@RequestMapping(value = "/Registration", method = RequestMethod.GET)
	public String display(Model model, @ModelAttribute("form") UserRegistrationForm form, Locale locale) {
		String enteremail = ms.getMessage("label.enteremail", null, locale);
		model.addAttribute("enteremail", enteremail);

		String enterpassword = ms.getMessage("label.enterpassword", null, locale);
		model.addAttribute("enterpassword", enterpassword);

		String enterdob = ms.getMessage("label.enterdob", null, locale);
		model.addAttribute("enterdob", enterdob);

		String enterfirstName = ms.getMessage("label.enterfname", null, locale);
		model.addAttribute("enterfirstName", enterfirstName);

		String enterLastName = ms.getMessage("label.enterlname", null, locale);
		model.addAttribute("enterLastName", enterLastName);

		String enterconPassword = ms.getMessage("label.entercpassword", null, locale);
		model.addAttribute("enterconPassword", enterconPassword);

		String enterMobile = ms.getMessage("label.entermob", null, locale);
		model.addAttribute("enterMobile", enterMobile);

		return "UserRegistration";
	}

	/**
	 * Submit.
	 *
	 * @param locale the locale
	 * @param form the form
	 * @param bindingResult the binding result
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/Registration", method = RequestMethod.POST)
	public String submit(Locale locale, @ModelAttribute("form") @Valid UserRegistrationForm form,
			BindingResult bindingResult, Model model) {
		String enteremail = ms.getMessage("label.enteremail", null, locale);
		model.addAttribute("enteremail", enteremail);

		String enterpassword = ms.getMessage("label.enterpassword", null, locale);
		model.addAttribute("enterpassword", enterpassword);

		String enterdob = ms.getMessage("label.enterdob", null, locale);
		model.addAttribute("enterdob", enterdob);

		String enterfirstName = ms.getMessage("label.enterfname", null, locale);
		model.addAttribute("enterfirstName", enterfirstName);

		String enterLastName = ms.getMessage("label.enterlname", null, locale);
		model.addAttribute("enterLastName", enterLastName);

		String enterconPassword = ms.getMessage("label.entercpassword", null, locale);
		model.addAttribute("enterconPassword", enterconPassword);

		String enterMobile = ms.getMessage("label.entermob", null, locale);
		model.addAttribute("enterMobile", enterMobile);

		//System.out.println("in post method" + form.getOperation() + "mmmm");
		if (OP_SIGNUP.equalsIgnoreCase(form.getOperation())) {

			System.out.println("in registration method");
			if (bindingResult.hasErrors()) {
				return "UserRegistration";
			}

			UserDTO dto = (UserDTO) form.getdto();
			//System.out.println("User Registration form" + dto.getConfirmpassword() + "..." + dto.getPassword());
	
			if (!dto.getPassword().equals(dto.getConfirmpassword())) {
				String conPwdMatch = ms.getMessage("label.conPwdMatch", null, locale);
				model.addAttribute("conPwdMatch", conPwdMatch);

				return "UserRegistration";
			}
			try {

				dto.setRoleid(RoleDTO.STUDENT);
				dto.setCreatedBy("root");
				dto.setModifiedBy("root");
				dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
				dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
				service.registeruser(dto);
				
				String msg = ms.getMessage("message.success", null, locale);
				model.addAttribute("success", msg);
				form.populate(dto);
				return "UserRegistration";

			} catch (DuplicateRecordException e) {
				String msg = ms.getMessage("error.loginid", null, locale);
				model.addAttribute("error", msg);

			} catch (ApplicationException e) {
				String msg = ms.getMessage("error.loginid", null, locale);
				model.addAttribute("error", msg);

			} 
			return "redirect:/UserRegistration";

		}
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/Registration";
		}
		return "UserRegistration";
	}

	/**
	 * Display.
	 *
	 * @param form the form
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	@RequestMapping(value = "/ForgetPassword", method = RequestMethod.GET)
	public String display(@ModelAttribute("form") ForgetPasswordForm form, Model model, Locale locale) {
		System.out.println("in forgot password ");
		String enteremail = ms.getMessage("label.enteremail", null, locale);
		model.addAttribute("enteremail", enteremail);
		return "ForgetPasswordView";

	}

	/**
	 * Submit.
	 *
	 * @param locale the locale
	 * @param form the form
	 * @param bindingResult the binding result
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/ForgetPassword", method = RequestMethod.POST)
	public String submit(Locale locale, @ModelAttribute("form") @Valid ForgetPasswordForm form,
			BindingResult bindingResult, Model model) {

		
		String enteremail = ms.getMessage("label.enteremail", null, locale);
		model.addAttribute("enteremail", enteremail);
		
		System.out.println("kjkjkjk");
		if (OP_CANCEL.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/Login";
		}
		if (OP_GO.equalsIgnoreCase(form.getOperation())) {
			if (bindingResult.hasErrors()) {
				return "ForgetPasswordView";
			}
			try {
				boolean flag = false;
				flag = service.forgetpassword(form.getLogin());

				if (flag) {
					model.addAttribute("success", "Password has been sent to your registered Email ID!!");
				} else {
					String msg = ms.getMessage("forgetpass.error", null, locale);
					model.addAttribute("error", msg);
				}

			} catch (ApplicationException e) {
				e.printStackTrace();
			}
		}

		return "ForgetPasswordView";

	}
	
	

}
 