package test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
//import Util.SetupBrowser;

public class BaseBrowser {
	// Calling browser from common method.
	BaseTest common;
	//String  browser="chrome";
	//String url="http://wwww.facebook.com";
private	static WebDriver  driver;
	
	@BeforeTest
	@Parameters({"browser","urlfb"})
	public void beforetest(String browser,String url) {	
		//open browser and url
		common =new BaseTest();		
		common.setupBrowser(browser, url); 
		driver=common.getDriver();
	}
	
	@AfterTest	
	public void quiteBrowser() {
		//Quite the browser
		common.quit();
	
	}
}
