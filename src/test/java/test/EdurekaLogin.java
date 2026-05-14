package test;
import java.time.Duration;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Utilities.ExtentTestNGListener;
import Pom.Obj_Edureka;
@Listeners(ExtentTestNGListener.class)

public class EdurekaLogin extends BaseTest{
	
	@Test
	public void EdurekaLogin() {
		
		driver.get(prop.getProperty("edurekaurl"));		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));

	//	Click Log in button on Homepage
		Obj_Edureka Eduobj=new Obj_Edureka(driver);
		
		Eduobj.waitforHomepageLogin();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));	
		Eduobj.clickLoginbtn();
		
		// get email message from web elements	
		Eduobj.getLoginValue();
	}

	
}
