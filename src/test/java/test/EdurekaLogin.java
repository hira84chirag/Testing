package test;
import java.time.Duration;

import org.testng.annotations.Test;

import Utilities.Obj_Edureka;


public class EdurekaLogin extends BaseTest{
	@Test
	//public static void main(String[] args) throws InterruptedException
	public void Edureka() throws InterruptedException{
		// TODO Auto-generated method stub
		
		driver.get(prop.getProperty("edurekaurl"));		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
	
	//	Click Log in button on Homepage
		Obj_Edureka Eduobj=new Obj_Edureka(driver);
		Eduobj.clickHomepageLogin();
		Thread.sleep(100);		
		Eduobj.clickLoginbtn();
		// get email message from web elements	
		Eduobj.getLoginValue();
		
	}

}
