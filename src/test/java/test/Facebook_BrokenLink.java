package test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	
	Thread.sleep(200);
	String classpath="//div[@class='_4-u2 _80gx _4-u8']//a";
	CommonFun.CountLinks(driver,classpath);
	Reporter.log("-----softare Testing-----");	
	
	
	
	String classpath1="//div[@class='_80gt _2ph_']";
	
	List<WebElement>  webobj=driver.findElements(By.xpath(classpath1));
	System.out.println("Total country="+webobj.size());
	
	//CommonFun.BrokenLinks(driver,classpath1);
	for(int i=0;i<webobj.size();i++){
		classpath1=classpath1+ " , "+ webobj.get(i).getText();
		
	}
	Reporter.log(classpath1);
	System.out.println("-----Done-----");		 
	}
		
}

