package test;
import org.testng.Reporter;
import com.deque.html.axecore.providers.FileAxeScriptProvider;
// import com.deque.html.axecore.AXE;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;

import Utilities.CommonFun;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import java.io.FileNotFoundException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class AccessibilityTest extends BaseTest {
	@Ignore
	@Test
    public  void AccessibilityCheck() throws FileNotFoundException {
		SoftAssert soft=new SoftAssert();
        // Step 1: Initialize WebDriver
		
		driver.get(prop.getProperty("Atkinsurl"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
        try {
            // Step 2: Open a webpage
  //          driver.get("https://www.atkinsrealis.com/en/about");
            driver.manage().window().maximize();
        	
            String acceptbtn="//button[contains(text(),'Accept all cookies')]";
            CommonFun.WaitExpt(driver, acceptbtn);

            // Step 3: Load the axe.min.js script
            URL axeScriptUrl = AccessibilityTest.class.getResource("/axe.min.js");
       //     File axeScript = new File(axeScriptUrl.toURI());
            AxeBuilder builder = new AxeBuilder();
            // Step 4: Run Axe accessibility checks
            JavascriptExecutor js = (JavascriptExecutor) driver;
        //    Results results = new AXE.Builder(driver, axeScript).analyze();
        //    Results results= new AXE.Builder(driver, axeScriptUrl);           
            String timeoutFilePath = "src/test/resources/axe.min.js";       	 
        	FileAxeScriptProvider axeScriptProvider = new FileAxeScriptProvider(timeoutFilePath);        	 
        	builder.setAxeScriptProvider(axeScriptProvider);        	 
        	Results results = builder.analyze(driver);        	 
        	List<Rule> violations = results.getViolations();
            
            // Step 5: Check for accessibility violations
            if (results.getViolations().size() == 0) {
            	Reporter.log("No accessibility violations found!");
            } else {
            	Reporter.log("Accessibility Violations:");

                // Print details of violations
            //    List<Rule> violations = results.getViolations();
                for (Rule violation : violations) {
                   Reporter.log("Violation ID: " + violation.getId());
                   Reporter.log("Description: " + violation.getDescription());
                   Reporter.log("Impact: " + violation.getImpact());
                   Reporter.log("Elements:");
                    violation.getNodes().forEach(node -> Reporter.log(" - " + node.getTarget()));
                }
            }

        	} catch (Exception e) {
            e.printStackTrace();
        	} 
        soft.assertAll();
      }
}
