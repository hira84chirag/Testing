package test;

import org.testng.annotations.Test;
import Util.Obj_RediffValidation;


public class RediffValidation extends BaseTest {
	
	
	@Test
	public void Redfflogin() {
		// Open  browser and pass url
		RediffValidation br=new RediffValidation();	
		br.setupBrowser("chrome","https://mail.rediff.com/cgi-bin/login.cgi");
		
		// Create object from object Repository 
		Obj_RediffValidation obj=new Obj_RediffValidation(driver);
		
		// Enter user name
		obj.enteruname("chiragpatel@infosystechnologies.com");
		// Enter password
		obj.enterpwd("SoftwareTestingHead");	
		// Get value by FindBy Method.	
		obj.getvalue();
		
		// Click sign in button.
		obj.clicksignbtn();
		
		driver.quit();
	}

}
