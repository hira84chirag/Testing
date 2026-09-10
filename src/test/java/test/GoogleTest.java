package test;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class GoogleTest extends BaseTest {

    @Test
    public void verifyTitle() throws Exception {
    	 
    	driver.get(prop.getProperty("Gogleurl"));
    	driver.manage().window().maximize();
    	
		 // 1st element checking     	
/*
    	String xpath="//div[@class='gb_Z gb_0'][1]";
		 driver.findElement(By.xpath(xpath)).click();
		 CommonFun.photo("GoogleTitile");

		 // 2nd element checking		 
		 xpath="//div[@class='gb_Z gb_0'][2]";
		 driver.navigate().back();
		 driver.findElement(By.xpath(xpath)).click();
		 Verifytext(xpath); 
		 CommonFun.photo("GoogleTitile");
		 driver.navigate().back();
*/		 
		 //Google suggestion count Example
		 
		 driver.findElement(By.name("q")).sendKeys("selenium" +Keys.ENTER);		 
		 Thread.sleep(2000);
	//	 driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		 // To get address of all the suggestions
		 String xp = "//span[contains(text(),'selenium')]";
		 List<WebElement> allSuggestions = driver.findElements(By.xpath(xp));
		 // To count number of suggetions
		 int count = allSuggestions.size();
		 System.out.println(count);
		 // To print all the suggestions
		 for (int i = 0; i < count; i++) {
			 WebElement suggestion = allSuggestions.get(i);
		 	 String text = suggestion.getText();
		 	 Reporter.log(text);
		 }
		 // To click on last suggestion
	//	 allSuggestions.get(count - 3).click();
		 driver.navigate().back();
		 Thread.sleep(2000);		 
    }
    public void Verifytext(String xpath) {
    		String s = driver.getTitle();		  
		  if (s.contains("Gmail: Private and secure email at no cost")) {
				 System.out.println("Gmail ACC");
				 } else {
				 System.out.println("Invalid=" + s);
				 }
		  
    }
    
}
