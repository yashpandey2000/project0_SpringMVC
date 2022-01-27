/**
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.util;

import java.util.HashMap;

/**
 * The Class EmailBuilder.
 */
public class EmailBuilder {
	/**
	 * Returns Successful User Registration Message
	 * 
	 * param map
	 *            : Message parameters
	 * return
	 */
	public static String getUserRegistrationMessage(HashMap<String, String> map) {
		StringBuilder msg = new StringBuilder();

		msg.append("<HTML><BODY>");
		msg.append("Registration is successful for ORS Project0");
		msg.append("<H1>Hi! Greetings from ORS SUNIL OS</H1>");
		msg.append(
				"<P>Congratulations for registering on ORS! You can now access your ORS account online - anywhere, anytime and enjoy the flexibility to check the Marksheet Details.</P>");
		msg.append(
				"<P>Log in today at <a href='http://ors.sunraystechnologies.com'>http://ors.sunraystechnologies.com</a> with your following credentials:</P>");
		msg.append("<P><B>Login Id : " + map.get("login") + "<BR>" + " Password : " + map.get("password") + "</B></p>");

		msg.append(
				"<P> As a security measure, we recommended that you change your password after your first log in.</p>");
		msg.append("<p>For any assistance, please feel free to call us at +91 0000000000 helpline number.</p>");
		msg.append("<p>You may also write to us at programmer.ajayraghu@gmail.com</p>");
		msg.append(
				"<p>We assure you the best service at all times and look forward to a warm and long-standing association with you.</p>");
		msg.append("<P><a href='http://www.sunrays.co.in' >-SUNRAYS Technolgies</a></P>");
		msg.append("</BODY></HTML>");

		return msg.toString();
	}

	/**
	 * Returns Email message of Forget Password
	 * 
	 * param map
	 *            : params
	 * return
	 */

	public static String getForgetPasswordMessage(HashMap<String, String> map) {
		StringBuilder msg = new StringBuilder();

		msg.append("<HTML><BODY>");
		msg.append("<H1>Your password is recovered !! " + map.get("firstName") + " " + map.get("lastName") + "</H1>");
		/*
		 * msg.append("<P>To access account user login ID : " + map.get("login")
		 * + " and password " + map.get("password") + "</P>");
		 */
		msg.append("<P><B>To access account use Login Id : " + map.get("login") + "<BR>" + " Password : "
				+ map.get("password") + "</B></p>");
		msg.append("</BODY></HTML>");

		return msg.toString();
	}

	/**
	 * Returns Email message of Change Password
	 * 
	 * param map
	 * return
	 */
	public static String getChangePasswordMessage(HashMap<String, String> map) {
		StringBuilder msg = new StringBuilder();

		msg.append("<HTML><BODY>");
		msg.append("<H1>Your Password has been changed Successfully !! " + map.get("firstName") + " "
				+ map.get("lastName") + "</H1>");
		/*
		 * msg.append("<P>To access account user login ID : " + map.get("login")
		 * + " and password " + map.get("password") + "</P>");
		 */
		msg.append("<P><B>To access account use Login Id : " + map.get("login") + "<BR>" + " Password : "
				+ map.get("password") + "</B></p>");
		msg.append("</BODY></HTML>");

		return msg.toString();
	}

}
