package com.projectName.genericPage;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Masterpage {

	public static WebDriver driver;
	public Properties pro1;
	public Properties pro2;
	public Properties pro3;
	
	// constructor implmentation
	public Masterpage() throws Exception {
		
		// config properties file implementation
		String dir=".\\src\\test\\java\\com\\projectName\\repository\\";
		FileInputStream fis1=new FileInputStream(dir+"config.properties");
		pro1 =new Properties();
		pro1.load(fis1);
	
		// locators properties file implementation
		FileInputStream fis2=new FileInputStream(dir+"locators.properties");
		pro2 =new Properties();
		pro2.load(fis2);
	
		// testdata properties file implementation
		FileInputStream fis3=new FileInputStream(dir+"testdata.properties");
		pro3 =new Properties();
		pro3.load(fis3);
	
	// Lauching Browsers - chrome//firefox/pages
		
		if(pro1.getProperty("browser").equalsIgnoreCase("chorme")) {
			
			System.setProperty(pro1.getProperty("driverPropety"),"*.\\src\\test\\java\\com\\projectName\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}else{
		
			WebDriverManager.chromiumdriver().setup();
			driver=new ChromeDriver();
		
		}
	
		driver.manage().window().maximize();
		
//		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(pro1.getProperty("URL_1"));
	
	
	}
	
	
}
