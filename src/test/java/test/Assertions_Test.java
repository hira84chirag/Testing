package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions_Test {
@Test
public void SoftAss() {
	SoftAssert soft=new SoftAssert();
	soft.assertEquals(false,true);
	System.out.println("This is soft Assertion");
	soft.assertAll();
}	
@Test	
public void HardAssert() {
	Assert.assertEquals(false,true);
	System.out.println("This is Hard Assertion");
	
}	
	
}
