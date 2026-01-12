package Utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

interface Waitelement{
	void webelementwait(WebElement ele);
	void webelewaitNext(WebDriver driver,WebElement ele);
	public static final WebDriver driver = null;
	default void simplewait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

	}
}
public class Expwait implements Waitelement {
	
	private WebElement ele;
	public Expwait(WebElement ele) {
		this.ele=ele;
	}	
	@Override
	public void webelementwait(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	@Override
	public void webelewaitNext(WebDriver driver,WebElement ele) {
		FluentWait<WebDriver> wait = new FluentWait<>(driver)
	                .withTimeout(Duration.ofMillis(50))
	                .pollingEvery(Duration.ofMillis(500))
	                .ignoring(NoSuchElementException.class);
		ele.click();
	}
	
 	 
//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(2));
//	WebElement pass= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Secured')]"))));

	/*
	 * WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
	 * wait.until(ExpectedConditions.visibilityOf(ele));
	 * wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
	 */
	
}

