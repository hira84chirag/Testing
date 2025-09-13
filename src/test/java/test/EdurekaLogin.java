package test;
import java.time.Duration;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Pom.Obj_Edureka;
import Utilities.CommonFun;

@Listeners(ExtentTestNGListener.class)
public class EdurekaLogin extends BaseTest{
	
	@Test
	
	//public static void main(String[] args) throws InterruptedException
	public void EdurekaLogin() throws InterruptedException{
		// TODO Auto-generated method stub
//		ExtentManager.getTest().log(Status.INFO, "Navigated to login page.");
		
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
//		ExtentManager.getTest().log(Status.PASS, "Login test passed successfully.");
	}

	
}
