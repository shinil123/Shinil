package student;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExecution 
{
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before suite");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before test");
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before class");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before method");
	}
	@Test
	public void test()
	{
		System.out.println("Sample");
	}
	@Test
	public void test1()
	{
		System.out.println("Sample1");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After method");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("After class");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("After test");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After suite");
	}
}
