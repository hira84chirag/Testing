package test;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestNG4 {
	@Test
	public void a() {
		System.out.println("This Hello A test method");
	}
	@Test(enabled = false)
	public void b() {
		System.out.println("This Hello B test method");
	}
	@Test(enabled = true)
	public void c() {
		System.out.println("This Hello C test method");
	}
	@Test(invocationCount = 2)
	public void d() {
		System.out.println("This Hello D test method");
	}
	
	@Test(invocationCount = 0)
	public void e() {
		System.out.println("This Hello E test method");
	}
	
	@Test()
	public void f() {
		System.out.println("This Hello F test method");
		throw new SkipException("skipping F test method");
	}

}
