package test;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Utilities.CommonFun;

public class Dynamic_xpath extends BaseTest{

	@Test()
	public void Menul_Links() throws Exception  {
			driver.get(prop.getProperty("flipurl"));
			driver.manage().window().maximize();	
	try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
			driver.findElement(By.xpath(prop.getProperty("flip"))).click();	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));		
	        String Fashionpath=prop.getProperty("flipfashion");
	// Locate the element you want to hover over
		    WebElement elementToHover = driver.findElement(By.xpath(Fashionpath));  
	// Create an Actions object
	        Actions actions = new Actions(driver);
	
	// Perform the mouse hover action
	        actions.moveToElement(elementToHover).perform();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
	        CommonFun.scrollme(driver);	    
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
	        CommonFun.photo("Flipkart");	

		} catch (NoSuchElementException e) {
			Reporter.log(e.getMessage());
			
		}
	}
}
