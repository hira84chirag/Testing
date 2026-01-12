package test;

import org.openqa.selenium.By;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

public class FluentWaitExample {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        // Create a FluentWait instance
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(2000)) // Total timeout
            .pollingEvery(Duration.ofSeconds(100)) // Polling interval
            .ignoring(NoSuchElementException.class); // Ignore this exception

        try {
            // Wait until the element is present and displayed
            WebElement element = wait.until(d -> {
                WebElement el = d.findElement(By.cssSelector("textarea[name='q']"));
                driver.navigate().refresh();
                if (el.isDisplayed()) {
                    return el;

                }
                return null;
            });

            System.out.println("Element found and is displayed!");
            // Perform actions on the element
            element.click();

        } catch (Exception e) {
            System.err.println("Element was not found or an error occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}