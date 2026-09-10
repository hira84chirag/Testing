package test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Utilities.CommonFun;

public class Exa_Checkbox extends BaseTest {
	
@Test
public  void Testcheckbox()  throws Exception {
		
	driver.get(prop.getProperty("demoqa"));
	driver.manage().window().maximize();
	// Scroll the page here	

	// Expand tree and click
	String treepath=prop.getProperty("expandtree");
	CommonFun.Clickbutton(driver, treepath);
	// count element and print
	List<WebElement> w = driver.findElements(By.xpath("//div[@role='treeitem']"));
	System.out.println("Total=" + w.size());
	// Click Home 
	treepath=prop.getProperty("Homechbox");
	driver.findElement(By.xpath(treepath)).click();
	for(int i=0;i<w.size();i++){
		 if (i<1)	w.get(i).click();
		 System.out.println(w.get(i).getText());
			Reporter.log(w.get(i).getText());
			w.get(i).click();
		}

		CommonFun.photo("demoqa");
	}

}
