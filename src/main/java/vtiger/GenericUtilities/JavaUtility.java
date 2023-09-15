package vtiger.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
		/**
		 * this method will return a random number for every execution
		 * @return
		 */
		
		public int getRandomNumber()
		{
			Random r= new Random();
			r.nextInt(1000);
			return r.nextInt(1000);
		}
		/**
		 * this method will generate the current system date in specified format
		 * @return
		 */
		
		public String getSystemDate()
		{
			Date d= new Date(0);
			SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
			String date = formatter.format(d);
			return date ;

		}
	}

