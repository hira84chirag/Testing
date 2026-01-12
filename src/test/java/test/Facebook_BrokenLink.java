package test;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Utilities.CommonFun;

public class Facebook_BrokenLink extends BaseTest{
	
	@Test
	public void FbServiceDirectory() throws InterruptedException {
	driver.get(prop.getProperty("fbdirectory"));
	driver.manage().window().maximize();
	
	//	Verify title of the site here;	
	String titlestr=driver.getTitle();
	Assert.assertEquals(titlestr,"Facebook services directory","Title isn't matched");
	Reporter.log(driver.getTitle()); // Create object from object Repository
	String classpath="//div[@class='_4-u2 _80gx _4-u8']//a";
	CommonFun.CountLinks(driver,classpath);
	Reporter.log("-----softare Testing-----");	  

		 
	}
		
}

