package test;
import java.time.Duration;

import org.testng.annotations.Test;
import Util.Obj_Edureka;


public class EdurekaLogin extends BaseTest{
	@Test
	//public static void main(String[] args) throws InterruptedException
	public void Edureka() throws InterruptedException{
		// TODO Auto-generated method stub
			
		EdurekaLogin obj=new EdurekaLogin();	
		obj.setupBrowser("chrome","https://www.edureka.co/signin");		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
	
	//	Click Log in button on Homepage
		Obj_Edureka Eduobj=new Obj_Edureka(driver);
		Eduobj.clickHomepageLogin();
		Thread.sleep(100);		
		Eduobj.clickLoginbtn();
		// get email message from web elements	
		Eduobj.getLoginValue();
		
		driver.quit();
	}

}
