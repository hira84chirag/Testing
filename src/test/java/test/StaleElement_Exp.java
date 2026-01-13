package test;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
 
public class StaleElement_Exp extends BaseTest {

    @Test
    public void handleStaleElement() {
        //WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.google.fr/");
            driver.manage().window().maximize();

            // Wait for the search box to be present
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(800));
            WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[name='q']")));

            // Refresh the page here to cause the StaleElementReferenceException
            driver.navigate().refresh();

            // Use a loop to handle the stale element gracefully
            boolean staleElementPresent = true;
            int attempts = 0;
            while (staleElementPresent && attempts < 3) { // Try up to 3 times
                try {
                    // Re-locate the element and interact with it
                    ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[name='q']")));
                    ele.sendKeys("Testng" + Keys.ENTER);
                    System.out.println("Search text entered successfully.");
                    staleElementPresent = false; // Exit the loop on success
                } catch (StaleElementReferenceException e) {
                    System.out.println("StaleElementException occurred. Attempting to re-locate element. Attempt " + (attempts + 1));
                    attempts++;
                }
            }
            if (staleElementPresent)   System.out.println("Failed to interact with the element after multiple attempts.");
            
        	}
            catch (NoSuchElementException e) {
                e.getMessage();
            }    
     //   driver.navigate().to("file:///C:/Users/Dell%20Enterprise/eclipse-workspace/Testing/extent-report/MyTestReport.html#");
      //  driver.manage().window().maximize();    
    } 
} 
   
    
    /*
    // The rest of your code can go here
    JavascriptExecutor js = (JavascriptExecutor) driver;
    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'Selenium')]")));
    js.executeScript("arguments[0].scrollIntoView();", element);

    List<WebElement> results = driver.findElements(By.cssSelector("div.g"));
    for (WebElement result : results) {
        try {
            WebElement title = result.findElement(By.tagName("h3"));
            WebElement link = result.findElement(By.tagName("a"));
            System.out.println("Title: " + title.getText());
            System.out.println("Link: " + link.getAttribute("href"));
            System.out.println();
        } 
    }

} 
*/