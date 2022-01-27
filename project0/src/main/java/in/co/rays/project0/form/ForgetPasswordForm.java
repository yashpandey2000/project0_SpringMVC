/*
 * @author Yash Pandey
 */
package in.co.rays.project0.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * The Class ForgetPasswordForm.
 */
public class ForgetPasswordForm extends BaseForm {

	/** The login. */
	@NotEmpty
    @Email
	private String login;

	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the login.
	 *
	 * @param login the new login
	 */
	public void setLogin(String login) {
		this.login = login;
	}
}
