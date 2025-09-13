package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions_Test extends BaseTest{
	
			@Test
			public void SoftAss() {
			SoftAssert softAssert = new SoftAssert();

	        System.out.println("Step 1: Verify Username field validation.");
	        // This assertion will fail.
	        softAssert.assertEquals("testuser", "correctuser", "Username mismatch!");

	        System.out.println("Step 2: Verify Email field validation.");
	        // This assertion will fail.
	        softAssert.assertEquals("test@example.com", "test@correct.com", "Email mismatch!");
	        
	        System.out.println("Step 3: Verify Password field validation.");
	        // This assertion will pass.
	        softAssert.assertTrue(true, "Password format is invalid.");

	        // This statement is crucial! It checks for all recorded failures and throws a single exception.
	        softAssert.assertAll(); 
	    }
	
	
	
@Test	
public void HardAssert() {
	
	  driver.get(prop.getProperty("fburl")); 
	  String title=driver.getTitle(); 
	 	
	  System.out.println("Facebook – log in or sign up");
	// This line will NOT be executed because the assertion above failed.
	Assert.assertEquals(title,"Facebook – log in or sign up123");
	System.out.println("This is Hard Assertion");
	
}	
	
}
