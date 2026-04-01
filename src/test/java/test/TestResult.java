package test;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestResult {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
        WebDriver driver = new InternetExplorerDriver();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		
        driver.manage().window().maximize(); 

        driver.navigate().to("file:///C:/Users/Dell%20Enterprise/eclipse-workspace/Testing/extent-report/MyTestReport.html#");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("file:///C:/Users/Dell%20Enterprise/eclipse-workspace/Testing/test-output/emailable-report.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
        
        driver.switchTo().window(tabs.get(1));


	}

}
