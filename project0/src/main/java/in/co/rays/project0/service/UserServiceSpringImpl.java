/*
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.project0.dao.UserDAOInt;
import in.co.rays.project0.dto.RoleDTO;
import in.co.rays.project0.dto.UserDTO;
import in.co.rays.project0.exception.ApplicationException;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.util.EmailBuilder;

@Service(value="userService")
public class UserServiceSpringImpl implements UserServiceInt{
	
	@Autowired
	private UserDAOInt dao ;
	
	@Autowired
	private RoleServiceInt roleService;
	
	@Autowired
	private JavaMailSenderImpl mailSender;

	private static Logger log = Logger.getLogger(UserServiceSpringImpl.class);
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(UserDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		RoleDTO cdto = roleService.findByPK(dto.getRoleid());
		dto.setRolename(cdto.getRoleName());
		
		UserDTO udto = dao.findbylogin(dto.getLogin());
		
		if(udto!=null && udto.getLogin()!=null){
			throw new DuplicateRecordException("login already exist");
		}
		
		long pk = dao.add(dto);
		
		return pk;
	}

	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long registeruser(UserDTO dto) throws DuplicateRecordException ,ApplicationException {
		// TODO Auto-generated method stub
		 
		  long id = add(dto);
		  
		 /* HashMap<String, String> map = new HashMap<String, String>();
          map.put("login", dto.getLogin());
          map.put("password", dto.getPassword());
          
          String message = EmailBuilder.getUserRegistrationMessage(map);
         
          MimeMessage msg = mailSender.createMimeMessage();

          // use the true flag to indicate you need a multipart message
          MimeMessageHelper helper;
          try {
              helper = new MimeMessageHelper(msg, true);
              helper.setTo(dto.getLogin());
              helper.setSubject("registration is successful for ORS");
              // use the true flag to indicate the text included is HTML
              helper.setText(message, true);
          } catch (MessagingException e) {
              System.out.println("Mail Sending Failed");
              e.printStackTrace();
          }
          mailSender.send(msg); */
		   
		  
			return id;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(UserDTO dto) {
		// TODO Auto-generated method stub
		log.debug("Service update Started");
		dao.update(dto);
		log.debug("Service update End");
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		// TODO Auto-generated method stub
		log.debug("Service Delete Started");
		dao.delete(id);
		log.debug("Service delete End");
	}

	@Transactional(readOnly = true)
	public UserDTO findbylogin(String login) {
		// TODO Auto-generated method stub
		log.debug("Service findByLogin Started");
		UserDTO dto = dao.findbylogin(login);
		log.debug("Service findByLogin ended");
		return dto;
	}

	@Transactional(readOnly = true)
	public UserDTO findbypk(long pk) {
		// TODO Auto-generated method stub
		log.debug("Service findBypk Started");
		UserDTO dto  = dao.findbypk(pk);
		log.debug("Service findBypk end");
		return dto;
	}

	@Transactional(readOnly = true)
	public List search(UserDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public List search(UserDTO dto) {
		// TODO Auto-generated method stub
	
		return 	dao.search(dto);
	}

	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean changepassword(long id, String oldpassword, String newpassword) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		UserDTO dto = findbypk(id);
		if(oldpassword.equals(dto.getPassword())){
			dto.setPassword(newpassword);
			dao.update(dto);
			
			
			 HashMap<String, String> map = new HashMap<String, String>();
	            map.put("login", dto.getLogin());
	            map.put("password", dto.getPassword());
	            map.put("firstName", dto.getFirstname());
	            map.put("lastName", dto.getLastname());
	            String message = EmailBuilder.getChangePasswordMessage(map);
	           
	            MimeMessage msg = mailSender.createMimeMessage();

	            // use the true flag to indicate you need a multipart message
	            MimeMessageHelper helper;
	            try {
	                helper = new MimeMessageHelper(msg, true);
	                helper.setTo(dto.getLogin());
	                helper.setSubject("Password has been changed Successfully.");
	                // use the true flag to indicate the text included is HTML
	                helper.setText(message, true);
	            } catch (MessagingException e) {
	                System.out.println("Mail Sending Failed");
	                e.printStackTrace();
	            }
	            mailSender.send(msg); 

	       
			return true;
			
		}	else{
		    
		return false;
		
		}
	}

	@Transactional(readOnly = true)
	public UserDTO authenticate(UserDTO dto) {
		// TODO Auto-generated method stub
		UserDTO dtoexist =null;
		UserDTO dto1 = null;
		
		dtoexist = dao.findbylogin(dto.getLogin());
		if(dtoexist!=null && dtoexist.getPassword().equals(dto.getPassword())){
			
			dto1= dtoexist;
			dao.update(dtoexist);
			
			
		}
		
		
		return dto1;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public boolean lock(String login) {
		// TODO Auto-generated method stub
		log.debug("Service lock Started");
		boolean flag = false;
		UserDTO dtoExist = null;
		dtoExist = findbylogin(login);
		if (dtoExist != null) {
			dtoExist.setLock(UserDTO.ACTIVE);
			dao.update(dtoExist);
			flag = true;
		} 
		log.debug("Service lock End");
		return flag;
	}

	
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public boolean resetpassword(String login) throws ApplicationException {
		// TODO Auto-generated method stub
		
		log.debug("Service resetPassword Started");
		boolean flag = false;
		UserDTO dtoExist = null;
		dtoExist = dao.findbylogin(login);
		if (dtoExist != null) {
			String newPassword = String.valueOf(new Date().getTime()).substring(0, 4);
			dtoExist.setPassword(newPassword);
			dao.update(dtoExist);

			HashMap<String, String> map = new HashMap<String, String>();
			map.put("login", dtoExist.getLogin());
			map.put("password", dtoExist.getPassword());
			map.put("firstName", dtoExist.getFirstname());
			map.put("lastName", dtoExist.getLastname());
			String message = EmailBuilder.getForgetPasswordMessage(map);

			MimeMessage msg = mailSender.createMimeMessage();

			// use the true flag to indicate you need a multipart message
			MimeMessageHelper helper;
			try {
				helper = new MimeMessageHelper(msg, true);
				helper.setTo(dtoExist.getLogin());
				helper.setSubject("Password has been reset.");
				// use the true flag to indicate the text included is HTML
				helper.setText(message, true);
			} catch (MessagingException e) {
				System.out.println("Mail Sending Failed");
				e.printStackTrace();
			}
			mailSender.send(msg);

			flag = true;
		} else {
		}
		log.debug("Service restPassword End");
		return flag;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public boolean forgetpassword(String login) throws ApplicationException {
		// TODO Auto-generated method stub
		log.debug("Service forgetPassword Started");

		 UserDTO dtoExist = dao.findbylogin(login);

	        if (dtoExist != null) {

	            HashMap<String, String> map = new HashMap<String, String>();
	            map.put("firstName", dtoExist.getFirstname());
	            map.put("lastName", dtoExist.getLastname());
	            map.put("login", dtoExist.getLogin());
	            map.put("password", dtoExist.getPassword());

	            String message = EmailBuilder.getForgetPasswordMessage(map);

	            MimeMessage msg = mailSender.createMimeMessage();

	            try {
	                MimeMessageHelper helper = new MimeMessageHelper(msg);
	                helper.setTo(login);
	                helper.setSubject("SunilOS ORS Password reset");
	                // use the true flag to indicate the text included is HTML
	                helper.setText(message, true);
	                mailSender.send(msg);
	            } catch (MessagingException e) {
	                e.printStackTrace();
	                log.error(e);
	                return false;
	            }
	        } else {
	            return false;
	        }
	        log.debug("Service forgetPassword End");
	        return true;
		}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public RoleDTO getrole(UserDTO dto) {
		// TODO Auto-generated method stub
		return roleService.findByPK(dto.getRoleid());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public UserDTO updateaccess(UserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
