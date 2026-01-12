package Pom;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Reporter;

import Utilities.Expwait;


public class Obj_RediffValidation {
	
	// Define variable Findby Method
		@CacheLookup
		@FindBy(css="#login1")
		WebElement uname1;
		
		@CacheLookup
		@FindBy(xpath="//span[@id='div_login_error']")
		WebElement msgval;
		
		@CacheLookup
		@FindBy(css = "#password") 
		WebElement pwd1;
		
		@CacheLookup
		@FindBy(xpath  = "//button[starts-with(text(),'Log In')]") 
		WebElement signbtn1;
	
	By uname=By.cssSelector("#login1");
	By pwd=By.cssSelector("#password");
	By signbtn=By.name("proceed");

	public static WebDriver driver;
	
	public Obj_RediffValidation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void teardown() {
		driver.quit();
	}
	
	public void enteruname(String username) {
		driver.findElement(uname).sendKeys(username);		
	}
	public void enterpwd(String password) {
		driver.findElement(pwd).sendKeys(password);
	}
	public void clicksignbtn() {		
		// wait for element
		Expwait obj= new Expwait(signbtn1);
		obj.webelementwait(signbtn1);	
		// click sign in button
		signbtn1.click();
	}
	
	public void LoginValidationmsg() {
		String str=msgval.getText();
		Reporter.log("valdiation message =" + str); 		
	}
	
	
	public void getvalue() {
		
	// Get value FindBy Method.	
	 String user=uname1.getAttribute("value");
	 String pass=pwd1.getAttribute("value");
	 String sign=signbtn1.getText();
	 Reporter.log("Username = "+user);
	 Reporter.log("Password = "+pass);
	 Reporter.log("button name = "+sign);	
	}
	
}
