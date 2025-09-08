package test;


import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

public class GoogleTest extends BaseTest {

    @Test
    public void verifyTitle() {
    	driver.get(prop.getProperty("fburl"));
        String title = driver.getTitle();
        Assert.assertEquals(title, "Facebook – log in or sign up");
        System.out.println("Page Title is: " + title);
    }
}
