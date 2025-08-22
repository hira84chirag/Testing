package test;

import org.testng.annotations.Test;

import javax.xml.stream.XMLReporter;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class DataProviderTest {
  @Test (dataProvider = "dp")
  
  public void validLogin(String brwowser,String url) {		
		Reporter.log("Browser ="+  brwowser);
		Reporter.log("Passowrd =" + url); 		
		
	}

  @DataProvider  
  public String[][] dp() {
    return new String[][] {
      new String[] { "chrome", "https://www.facebook.com" },
//      new String[] { "urlfb", "url" },    
    };
  }
}
