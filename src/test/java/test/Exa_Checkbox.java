package test;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Utilities.CommonFun;
import org.openqa.selenium.By;

public class Exa_Checkbox extends BaseTest {
	
@Test
public  void Testcheckbox()  throws Exception {
		
	driver.get(prop.getProperty("demoqa"));
	// Scroll the page here	
	CommonFun.scrollpage(driver,"//div[@id='Ad.Plus-970x250-2']");	

	// Expand tree and click
	String treepath="//span[@class='rc-tree-switcher rc-tree-switcher_close']";
	CommonFun.Clickbutton(driver, treepath);
	// count element and print
	List<WebElement> w = driver.findElements(By.xpath("//div[@role='treeitem']"));
	System.out.println("Total=" + w.size());

	for(int i=0;i<w.size();i++){
		 if (i<1)	w.get(i).click();
		 System.out.println(w.get(i).getText());
			Reporter.log(w.get(i).getText());
		}
	}
	
}
