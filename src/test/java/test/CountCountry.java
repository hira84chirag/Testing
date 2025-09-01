package test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Util.Common;

// import pom.ObjectRepo;

public class CountCountry extends BaseTest{
	
	@Test
	public void FbServiceDirectory() throws InterruptedException {
		
	// Open  browser and pass url
	
	String url="https://www.facebook.com/biz/directory/";
	driver.get(url);
	driver.manage().window().maximize();
	
	//	obj.beforetest(brow,url);			
	Reporter.log(driver.getCurrentUrl()); // Create object from object Repository
	String classpath="//div[@class='_4-u2 _80gx _4-u8']//a";
	Common.countLinks(driver,classpath);
	Reporter.log("-----softare Testing-----");	  
	 //	  Common.countclass(driver,classpath);
	driver.quit();
		 
	}
		
}

/*
 * public void openBro(String browser,String url) { CountCountry obj=new
 * CountCountry(); browser="chrome";
 * url="https://www.facebook.com/biz/directory/"; obj.openBro(browser, url); }
 */	
