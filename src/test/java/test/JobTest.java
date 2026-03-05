package test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JobTest {
	
	
	
	@Ignore
	@Test()
	public void check() throws Exception {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
//		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://www.paytm.com");
	
	}
	
	@Test
	public void a2() {
		System.out.println("This Hello a2 test method");
	}
	
	@Test
	public void a1() {
		System.out.println("This Hello a1 test method");
	}
	
	@BeforeMethod
	public void b() {
		System.out.println("Hello before test method");
	}

	@BeforeSuite
	public void c() {
		System.out.println("Hello before suite method");
	}

	@BeforeMethod
	public void d() {
		System.out.println("Hello before method method");
	}
	@BeforeClass
	public void e() {
		System.out.println("Hello before class method");
	}

	@AfterTest
	public void ef() {
		System.out.println("Hello After Test method");
	}
	
	
	@AfterTest
	public void ea() {
		System.out.println("Hello After class method");
	}
	
	@AfterMethod
	public void da() {
		System.out.println("Hello After method method");
	}

	@AfterSuite
	public void ca() {
		System.out.println("Hello After suite method");
	}

}
