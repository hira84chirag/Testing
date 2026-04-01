package test;
import java.awt.AWTException;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import Utilities.CommonFun;
import java.util.concurrent.*;
public class Flipkart extends BaseTest{

	@Test()
	public void Menul_Links() throws Exception  {

		// TODO Auto-generated method stub

		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(600));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(800));
		try {
//		String xpath= "//span[@class='_1XjE3T']";
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
		driver.findElement(By.xpath("//span[@class='b3wTlE']")).click();	
		//x("//span[@class='b3wTlE']") String xpath= "a";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		
        String Fashionpath="//div[contains(text(),'Fashion')]";
	     // Locate the element you want to hover over
	        WebElement elementToHover = driver.findElement(By.xpath(Fashionpath)); 
	   
	        // Create an Actions object
	        Actions actions = new Actions(driver);

	        // Perform the mouse hover action
	        actions.moveToElement(elementToHover).perform();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	        CommonFun.scrollme(driver);	    
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	        CommonFun.photo("Flipkart");	
		} catch (NoSuchElementException e) {
			Reporter.log(e.getMessage());
			
		}
	}
}
