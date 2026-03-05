package test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Utilities.CommonFun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Listeners(ExtentTestNGListener.class)
public class Exa_Checkbox extends BaseTest {
	
	@Test
public  void Testcheckbox()  throws Exception {
		
//	ExtentManager.getTest().log(Status.INFO, "Checkbox page.");
	driver.get(prop.getProperty("demoqa"));
	String path="//span[@class='rc-tree-switcher rc-tree-switcher_close']";
	CommonFun.scrollpage(driver,"//div[@id='Ad.Plus-970x250-2']");
//	Thread.sleep(4000);
	WebElement chkpath=driver.findElement(By.xpath(path));
	
	chkpath.click();
//	Thread.sleep(4000);
	List<WebElement> w = chkpath.findElements(By.xpath("//span[@class='rc-tree-checkbox']"));
	System.out.println("Total=" + w.size());
	// Scroll the page here	
	
	for(int i=0;i<w.size()-1;i++){
			Thread.sleep(300);
		 if (i<1)	w.get(i).click();
			Reporter.log(w.get(i).toString());
		}
//	ExtentManager.getTest().log(Status.PASS, "checkbox test passed successfully.");
	}
	
}
