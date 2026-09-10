package test;

import javax.xml.stream.XMLReporter;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderTest extends BaseTest{
	public String browser="";
  @Test (dataProvider = "dp")
    public void LoginParameter(String brwowser,String url) throws InterruptedException {	
	  	
	  switch (brwowser) {
	    case "urlfb":
	        System.out.println(brwowser);
	        driver.get(url);
	        break; // Stops execution and exits the switch block safely
	        
	    case "google":
	        System.out.println(brwowser);
	        driver.get(url);
	        break;
	        
	    case "hotmail":
	        System.out.println(brwowser);
	        driver.get(url);
	        break;
	        
	    default:
	        System.out.println(brwowser);
	        driver.get(url);
	        break;
	}
	
	}

  @DataProvider  
  public String[][] dp() {
    return new String[][] {
      new String[] { "urlfb", "https://www.facebook.com" },   
      new String[] { "google", "http://www.google.com" }, 
      new String[] { "newtab", "chrome://newtab" }, 
      new String[] { "hotmail", "http://www.hotmail.com" }, 
     
    };
  }
}
