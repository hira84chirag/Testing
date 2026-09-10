package test;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Utilities.CommonFun;

public class Facebook_BrokenLink extends  BaseTest{
	
	@Test
	public void FbService() throws Exception {
		
		driver.get(prop.getProperty("fburl"));
		driver.manage().window().maximize();
		// For Below code , Use selenium version 4 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		String xpath=prop.getProperty("forgotpass");
		CommonFun.Clickbutton(driver, xpath);
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(620));
		driver.get(prop.getProperty("fburl"));
		xpath=prop.getProperty("newaccount");
		CommonFun.Clickbutton(driver, xpath);
	
	}
	
	@Test
	public void FbServiceDirectory() throws InterruptedException {
	driver.get(prop.getProperty("fbdirectory"));
	driver.manage().window().maximize();
	
	//	Verify title of the site here;	
	String titlestr=driver.getTitle();
	Assert.assertEquals(titlestr,"Facebook services directory","Title isn't matched");
	Reporter.log(driver.getTitle()); // Create object from object Repository
	
	Thread.sleep(200);
	String classpath=prop.getProperty("fbdirpath");
	CommonFun.CountLinks(driver,classpath);
	Reporter.log("-----softare Testing-----");	
	classpath=prop.getProperty("fbdirpath1");
	
	List<WebElement>  webobj=driver.findElements(By.xpath(classpath));
	System.out.println("Total country="+webobj.size());
	
	//CommonFun.BrokenLinks(driver,classpath1);
	for(int i=0;i<webobj.size();i++){
		classpath=classpath+ " , "+ webobj.get(i).getText();
		
	}
	  Reporter.log(classpath);
	System.out.println("-----Done-----");		 
	}
		
}

