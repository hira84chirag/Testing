package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.investis.testing.Base;

public class BaseTest extends Base{
	
	static WebDriver driver;
	String browser="chrome", url="";
	
	@BeforeClass
	public void setUp() {
		loadPropertiesFile();	
		//browser=prop.getProperty("browser");
		driver=intilizeBrowserAndOpenApplication(browser);	
		//Thread.sleep(1000);
	}
	
	
	public void navigatetourl(String url) {
		driver.get(url);
	}
	
	public void quit() {
		driver.quit();
	}

	@AfterClass
	 public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	            System.out.println("Browser closed");
	        }
	  }
	
	
}



/*
 
 		if(browser.equalsIgnoreCase("chrome")) 
			{
	//		System.setProperty("webdriver.chrome.driver", "C:/Program Files/Google/Chrome/Application/chrome.exe");
			 // Create ChromeOptions and add incognito argument
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-extensions");
	        options.addArguments("--incognito");
			driver = new ChromeDriver(options);
			driver.get("http://www.google.com/");
			System.out.println("Browser launched and navigated to site");
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

*/