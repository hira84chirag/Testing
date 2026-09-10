package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JobTest extends BaseTest {
	
	@Test()
	public void check() throws Exception {
		driver.close();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/@Cinematic_dhaval");
        
		
		String s1 = new String("hello");
		String s2 = "hello";
		String s3 = s1.intern();

		System.out.println(s1 == s2);
		System.out.println(s2 == s3);
				
		//driver.quit();
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
