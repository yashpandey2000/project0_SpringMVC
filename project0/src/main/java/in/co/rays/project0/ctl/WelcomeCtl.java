/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The Class WelcomeCtl.
 */

@Controller
@RequestMapping("/Welcome")
public class WelcomeCtl {
	

	/**
	 * Display.
	 *
	 * @param model the model
	 * @return the string
	 */
	
	@RequestMapping( method=RequestMethod.GET)
	public String Display(ModelMap model){
		
		return "Welcome";
		}

}
