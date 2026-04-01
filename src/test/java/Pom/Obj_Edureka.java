package Pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonFun;

public class Obj_Edureka {
	public static WebDriver driver;

	

	@FindBy(xpath ="//input[@name='email']")
	WebElement enterEmail;

	@FindBy(xpath ="//input[@name='password']")
	WebElement enterPass;

	@FindBy(xpath ="//p[contains(text(),'Mandatory email address')]")
	WebElement emailmsg;

	@FindBy(xpath ="//p[contains(text(),'Mandatory password')]")
	WebElement passmsg;
	
	@FindBy(xpath ="//p[contains(text(),'Sign In Failed.')]")
	WebElement validationmsg;
	
	
	By HomePageLogin=By.xpath("//button[contains(text(),'Log')]");
	By Loginbtn=By.xpath("//button[starts-with(text(),'LOG')]");
	
	// get email message from web elements

//	String path;
	
	public Obj_Edureka(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
	}
	
	public void waitforHomepageLogin() {
		CommonFun.waitForElement(driver, "//button[contains(text(),'Log')]"); 		
	}

	public void clickLoginbtn() {
		CommonFun.ClickWebElement(driver, HomePageLogin);
	}

	public void getLoginValue() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));				
		CommonFun.ClickWebElement(driver, Loginbtn);
		System.out.println(emailmsg.getText());		
		System.out.println("email message="+ emailmsg.getText());
		enterEmail.sendKeys("jsktestingraja@edureka.com");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		CommonFun.ClickWebElement(driver, Loginbtn);
	    System.out.println("password message="+ passmsg.getText());

		enterPass.sendKeys("edurekatesting");		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		CommonFun.ClickWebElement(driver, Loginbtn);
		System.out.println("message="+ validationmsg.getText());
		
		
	}
	
	
}

