package test;


import org.testng.annotations.Test;

public class MyTest {

    @Test(dataProvider = "dp", dataProviderClass = DataProviderTest.class)
    public void testLogin(String browser, String url) {
        // Your test logic here
        System.out.println("browser name: " + browser + " and url: " + url);
        // Assertions go here
    }
}