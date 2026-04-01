package Utilities;

import java.awt.AWTException;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.awt.Dimension;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
public class CommonFun_bkp {
	
	public static int count=0;
	WebDriver driver;
	public CommonFun_bkp(WebDriver driver) {
		this.driver=driver;	
	}
	public static void ClickonElement(WebDriver driver, WebElement e){
 		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOf(e));
		wait.until(ExpectedConditions.elementToBeClickable(e)).click();
	}
	public static void ClickWebElement(WebDriver driver, By abc){
 		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(100));
 		wait.until(ExpectedConditions.visibilityOfElementLocated(abc));
		wait.until(ExpectedConditions.presenceOfElementLocated(abc)); 
		wait.until(ExpectedConditions.alertIsPresent());
		
		driver.findElement(abc).click();
	}
	public static void BtnClick(WebDriver driver,WebElement obj)
	{
		obj.click();
	}

	public static void waitForElement(WebDriver driver, String Webele){
		WebElement elewait=driver.findElement(By.xpath(Webele));
 		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOf(elewait));
		wait.until(ExpectedConditions.elementToBeClickable(elewait)).click();
	}

	// Wait for Element	
	public static void WaitExpt(WebDriver driver,String xpath) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));		  
		WebElement text=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));			
	}

	public static void waitImplicit(WebDriver driver,int num){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));

	}

	public static void CreateImage(WebDriver driver,String fileName)  {
        try {
	        long currentTimeMillis = System.currentTimeMillis();        	        
	        // Define the destination file path like "D:/screenshot.png";
	        String filestr=System.getProperty("user.dir") +"\\test-output\\Screenshot\\";
	        fileName=filestr + fileName + currentTimeMillis+ ".jpg";
	        // Take a screenshot and store it as a file
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);	        
	        // Copy the screenshot to the destination file
	        FileUtils.copyFile(screenshot, new File(fileName));
        	System.out.println("Screenshot saved at: " + fileName );
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        } finally {
            // Close the browser

        }
    }
	public static String Snap(WebDriver driver,String name)  
	{
		String path= System.getProperty("user.dir") +"\\test-output\\Screenshot\\";
		try{			
		//Unique DateTimestamp code		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		long timestamp = System.currentTimeMillis();	        
  //      System.out.println(name+sdf.format(timestamp));
        name = name+"_"+ sdf.format(timestamp);
       
        
		//Screenshot code
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(src, new File(path + name + ".jpg"));
		
		}catch (Exception e) { 
			e.printStackTrace();
			//return false;
		}		
		return path+name+".jpg";
	}
	public static void waitThread(int number) throws Exception {
		Thread.sleep(number);
	}
	
	
	// Wait for click createlink
		public static void Clickbutton(WebDriver driver,String xpath) {
			//xpath="//span[contains(text(),'Create account')]";
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));		  
			WebElement elewait=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));			
			elewait.click();

		}

	
	public static void scrollpage(WebDriver driver, String xpath) throws Exception {
		// Scroll by Pixels
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll to a specific element (like Footer or any section)
        WebElement footer = driver.findElement(By.xpath(xpath));
        js.executeScript("arguments[0].scrollIntoView(true);", footer);
      //  Thread.sleep(2000);
        int j=0;
        js.executeScript("window.scrollBy(700, 1500)");

		/*
		 * for (int i = 200; j <= last; i += 100) { j=i+100;
		 * js.executeScript("window.scrollBy(" +i+"," + j + ");"); Thread.sleep(1000);
		 * // Adjust speed }
		 */ 
	}
	public static void getText(WebDriver driver, String str) {
		WebElement eleText=driver.findElement(By.xpath(str));
		System.out.println(eleText.getText());
	}
	public static void photo(String filename) throws AWTException {
		 
		 Robot robot = new Robot();
		 //robot = null;
	try {
		Dimension dimvar= Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect = new Rectangle(dimvar);
		Thread.sleep(1000);
		BufferedImage bufferedImage =robot.createScreenCapture(rect);
		// Create a file name
		String Path = System.getProperty("user.dir")+"//test-output//Screenshot//"+filename+System.currentTimeMillis() + ".jpg";;
		
		File destinationFile = new File(Path);	
		ImageIO.write(bufferedImage, "jpeg", destinationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void CountLinks(WebDriver driver,String xpath) {	
		
		List <WebElement> links =  driver.findElements(By.xpath(xpath));
	//	 List<WebElement> links = driver.findElements(By.xpath("//img[@class='_46-i img']")); 
		count=	links.size();
		System.out.println("total size="+  links.size());
			Reporter.log("count begin start Total links=" +  links.size());
		 for (WebElement element : links) {
             String linkText = element.getText();
             String url = element.getAttribute("href");

             if (url != null && !url.isEmpty()) {
            	 if (count >5) {
            	 try {
     	            URL urltest = new URL(url);
     	            HttpURLConnection httpURLConnect = (HttpURLConnection) urltest.openConnection();
     	            httpURLConnect.setConnectTimeout(3000);
     	            httpURLConnect.connect();
     	            int responseCode = httpURLConnect.getResponseCode();
                 	
                 		if (httpURLConnect.getResponseCode() >= 400) {            	
     	            	Reporter.log(url +" HTTP code: "+responseCode +"="+ httpURLConnect.getResponseMessage());
     	            	//Reporter.log(url + " is a broken link.");
     	            	count++;
     	            	} else {
     	            	Reporter.log("URL :" + url );
     	            	}
                 	
     	        } catch (Exception e) {
     	            // This catch block handles exceptions like MalformedURLException or IOExceptions
     	        	Reporter.log(url + " is a broken link due to an exception: " + e.getMessage());
     	        }
            	 }else {
            		 break;
            	 }
            	 
             }
    		 
         }
			
	}

	public static void BrokenLinks(WebDriver driver,String tagename) {	
		List <WebElement> links =  driver.findElements(By.tagName(tagename));
	//	 List<WebElement> links = driver.findElements(By.xpath("//img[@class='_46-i img']")); 
		 Reporter.log("Total links=" + links.size());
		 
		 for (WebElement element : links) {
             String linkText = element.getText().trim();
             String url = element.getAttribute("href");

             if (url != null && !url.isEmpty()) {
                // Reporter.log("Text: " + linkText + " - Link: " + url);
                 checkBrokenLink(url);
      
             }
    		 
         }
		


	}
	 public static void checkBrokenLink(String linkUrl) {
	
	        try {
	            URL url = new URL(linkUrl);
	            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
	            httpURLConnect.setConnectTimeout(3000);
	            httpURLConnect.connect();
	            int responseCode = httpURLConnect.getResponseCode();
            	
            		if (httpURLConnect.getResponseCode() >= 400) {            	
	            	Reporter.log(linkUrl + " is a broken link." +" HTTP status code: "+responseCode+"=" + httpURLConnect.getResponseMessage());
	            	
	            	} else {
	            	Reporter.log("URL :" + linkUrl );
	            	}
            	
	        } catch (Exception e) {
	            // This catch block handles exceptions like MalformedURLException or IOExceptions
	        	Reporter.log(linkUrl + " is a broken link due to an exception: " + e.getMessage());
	        }
	    }

}
