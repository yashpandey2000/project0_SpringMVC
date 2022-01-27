/**
 * @author Yash Pandey
 *
 */
package in.co.rays.project0.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class Util.
 */
public class Util {
 
 /**
  * Gets the date.
  *
  * @param date the date
  * @return the date
  */
 public static Date getDate(String date){
	 SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
	 Date date1=null;
	 System.out.println("inside the util package");
	 if(date!=null){
		 try {
			date1=formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 }
	 return date1; 
 } 

 /**
  * Gets the date.
  *
  * @param indate the indate
  * @return the date
  */
 public static String getDate(Date indate) {
     String dateString = null;
     SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
     /*
      * you can also use DateFormat reference instead of SimpleDateFormat
      * like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
      */
     try {
         dateString = sdfr.format(indate);
     } catch (Exception ex) {
         System.out.println(ex);
     }
     return dateString;
 }

 /**
  * Convert string to date.
  *
  * @param indate the indate
  * @return the string
  */
 public static String convertStringToDate(Date indate) {
     String dateString = null;
     SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
     /*
      * you can also use DateFormat reference instead of SimpleDateFormat
      * like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
      */
     try {
         dateString = sdfr.format(indate);
     } catch (Exception ex) {
         System.out.println(ex);
     }
     return dateString;
 }

 
}
