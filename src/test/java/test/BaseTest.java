package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseTest {
	
	static WebDriver driver;
	
	public void setupBrowser(String browser, String url) {
		
		if(browser.equalsIgnoreCase("chrome")) 
			{
			
			 // Create ChromeOptions and add incognito argument
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-extensions");
	        options.addArguments("--incognito");
			driver = new ChromeDriver(options);

			}
		else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if(browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else if(browser.equalsIgnoreCase("safari"))
			driver = new SafariDriver();
		else {
			System.out.println("valid browser is not provided, hence quitting the automation run");
			System.exit(0);
		}
			
		if(url!="")
			driver.get(url);
		else
			driver.get("about:blank");
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void navigatetourl(String url) {
		driver.get(url);
	}
	public void quit() {
		driver.quit();
	}

}



