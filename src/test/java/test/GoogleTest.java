package test;


import org.testng.annotations.Test;
import test.BaseTest;

public class GoogleTest extends BaseTest {

    @Test
    public void verifyTitle() {
    	driver.get("http://www.facebook.com");
        String title = driver.getTitle();
        System.out.println("Page Title is: " + title);
    }
}
