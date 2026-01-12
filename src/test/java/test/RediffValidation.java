package test;

import org.testng.annotations.Test;

import Pom.Obj_RediffValidation;
import Utilities.CommonFun;


public class RediffValidation extends BaseTest {
	
	
	@Test
	public void Redfflogin() {
		// Open  browser and pass url
		
		driver.get(prop.getProperty("redifflogin"));
		
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
		// verify validation message for login page
		obj.LoginValidationmsg();
		// Find out brokenlink on page
		CommonFun.BrokenLinks(driver, "a");
		
		
	}

}
