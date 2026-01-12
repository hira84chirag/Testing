package test;
import java.awt.AWTException;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Utilities.CommonFun;
import java.util.concurrent.*;
public class Flipkart extends BaseTest{
	@Test()
	public void Menul_Links() throws InterruptedException, AWTException, ExecutionException  {
		
		String s1 = new String("hello");
		String s2 = "hello";
		String s3 = s1.intern();

		System.out.println(s1 == s2);
		System.out.println(s2 == s3);
		
	        
		// TODO Auto-generated method stub

		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(600));
		driver.manage().window().maximize();
		
		try {
//		String xpath= "//span[@class='_1XjE3T']";
		
		String xpath= "//div[@class='_3sdu8W emupdz']/a";
		CommonFun.CountLinks(driver, xpath);
        String Fashionpath="//span[contains(text(),'Fashion')]";
	     // Locate the element you want to hover over
	        WebElement elementToHover = driver.findElement(By.xpath(Fashionpath)); 
	   
	        // Create an Actions object
	        Actions actions = new Actions(driver);

	        // Perform the mouse hover action
	        actions.moveToElement(elementToHover).perform();
	        CommonFun.scrollpage(driver, "//footer[@class='wzLzb3']");	        
	        CommonFun.photo("Flipkart");	
		} catch (NoSuchElementException e) {
			Reporter.log(e.getMessage());
			
		}
	}
}



// like clicking on a submenu item that appears.
//        WebElement subMenuItem = driver.findElement(By.linkText("Men's Top Wear"));
//       actions.click(subMenuItem).perform();

//Click see offer link button
		/*
		 * path="//div[@class='_2GaeWJ']"; WebElement
		 * parent=driver.findElement(By.xpath(path));
		 */		
		
		  // Click next button 
//		path="//a[@id='a-autoid-1']//i[@class='a-icon a-icon-next']"; 		 
//	WebElement seeofferpage=driver.findElement(By.xpath(path)); 		
//		String path1="//div[@class='_offer-faceout-carousel-card_style_badgeContainer__1IyV0']/span[@class='a-size-small _offer-faceout-carousel-card_style_savingsBadge__1spPe']";					
//		$x("//span[@class='a-truncate a-size-base-plus']/span[@class='a-truncate-full a-offscreen']")	
//		String path1="//span[@class='a-truncate a-size-base-plus']/span[@class='a-truncate-full a-offscreen']";	
