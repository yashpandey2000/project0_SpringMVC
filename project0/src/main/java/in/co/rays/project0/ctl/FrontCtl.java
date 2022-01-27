/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.ctl;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * The Class FrontCtl.
 */

public class FrontCtl extends HandlerInterceptorAdapter{

/** The message source. */
@Autowired
private MessageSource messageSource;

/**
 * Pre handler.
 *
 * @param request the request
 * @param response the response
 * @param handler the handler
 * @return true, if successful
 * @throws ServletException the servlet exception
 * @throws IOException Signals that an I/O exception has occurred.
 */
public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws ServletException, IOException{
	HttpSession session = request.getSession();
	if(session.getAttribute("user")==null || session.getAttribute("role")==null) {
		System.out.println(session.getAttribute("user")+"=================== "+session.getAttribute("role"));
		Locale locale = null;
		String msg = messageSource.getMessage("message.session", null , locale);
		request.setAttribute("error", msg);
    	String str = request.getRequestURI();
    	request.setAttribute("uri",str);
        RequestDispatcher rd = request.getRequestDispatcher("/Login");
        rd.forward(request, response);
        return false;
	}
	return true;
}

}
