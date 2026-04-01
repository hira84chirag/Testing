package test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkin extends BaseTest{
	
	public static void main(String[] args) throws IOException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.crowdanalytix.com/#home");
        
        WebElement webElement = getWebElement(driver, "home");
        int i = 1;
        while (webElement == null && i < 4) {
            webElement = getWebElement(driver, "home");
            System.out.println("calling");
            i++;
        }
        System.out.println(webElement.getTagName());
        System.out.println("End");
        driver.close();
    }

    public static WebElement getWebElement(WebDriver driver, String id) {
        WebElement myDynamicElement = null;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		myDynamicElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));           
		return myDynamicElement;
    }

}
