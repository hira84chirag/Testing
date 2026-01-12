package Pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Obj_Edureka {
	public static WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath ="//span[@data-gi-action='Login']")
	WebElement HomePageLogin1;
	
	@FindBy(xpath ="//button[starts-with(text(),'Log')]")
	WebElement Loginbtn1;

	@FindBy(xpath ="//input[@name='email']")
	WebElement enterEmail;

	@FindBy(xpath ="//input[@name='password']")
	WebElement enterPass;

	@FindBy(xpath ="//p[contains(text(),'Mandatory email address')]")
	WebElement emailmsg;

	@FindBy(xpath ="//input[@name='password']")
	WebElement passmsg;
	
	@FindBy(xpath ="//p[contains(text(),'Sign In Failed.')]")
	WebElement validationmsg;

	
	By HomePageLogin=By.xpath("//button[contains(text(),'Log')]");
	By Loginbtn=By.xpath("//button[starts-with(text(),'LOG')]");
	// get email message from web elements

	String path;
	public Obj_Edureka(WebDriver driver) {
		this.driver=driver;
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		}
	public void clickHomepageLogin() {
    //    wait.until(ExpectedConditions.elementToBeClickable(HomePageLogin1)).click();		
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(800));
 		wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLogin));
        //  HomePageLogin1.click();
	}

	public void clickLoginbtn() {
		String xpath=	"//button[starts-with(text(),'Log')]";
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(300));		  
	//	WebElement elewait=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));			
	//	elewait.click();
		
      Loginbtn1.click();
	}

	public void getLoginValue() {

		WebDriverWait wait5 = new WebDriverWait(driver,Duration.ofSeconds(300));
	    wait5.until(ExpectedConditions.elementToBeClickable(Loginbtn)).click();

	    
		WebElement loginButton = driver.findElement(Loginbtn);
		loginButton.click();
		
		System.out.println(emailmsg.getText());		
		System.out.println("|----|"+ emailmsg.getText());
		
		enterEmail.sendKeys("jsktestingraja@edureka.com");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(300));
	    wait.until(ExpectedConditions.elementToBeClickable(Loginbtn)).click();
		System.out.println("|----|"+ passmsg.getText());

		enterPass.sendKeys("edurekatesting");		
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(300));
	    wait1.until(ExpectedConditions.elementToBeClickable(Loginbtn)).click();	

		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(300));

	//	System.out.println("|Finally----|"+ validationmsg.getText());
	}
	
	public void teardown() {
		driver.quit();
	}
}

/*
//@CacheLookup


By Loginbtn1=By.xpath("//button[starts-with(text(),'LOG')]");



*/