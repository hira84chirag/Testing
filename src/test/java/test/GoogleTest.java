package test;


import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.CommonFun;
import test.BaseTest;

public class GoogleTest extends BaseTest {

    @Test
    public void verifyTitle() throws AWTException {
    	driver.get(prop.getProperty("fburl"));
        String title = driver.getTitle();
        Assert.assertEquals(title, "Facebook – log in or sign up");
        System.out.println("Page Title is: " + title);
        CommonFun.photo("photo2");
    }
}
