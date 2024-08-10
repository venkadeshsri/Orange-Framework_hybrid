package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.Orange_homepage_1;

public class Orange_homepg_testCase extends BaseTest {

	Orange_homepage_1 homepg;

	@BeforeMethod
	public void browsersetup() throws IOException {
		base_init();
		homepg = new Orange_homepage_1();

	}

	@Test(priority = 1)
	public void logo_testing() 
	{
		boolean logodisplaying = homepg.logo_test();
		System.out.println("Is logo displaying : " + logodisplaying);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		assertEquals(logodisplaying, false);
	}

	@Test(priority = 2, groups = "Regression")
	public void login_test() 
	{
		String result = homepg.login_errcheck1();
		assertEquals(result, "true");
		System.out.println("Error message displaying for User name & Pwd : " + result);
	}

	@Test(priority = 3, groups = "Regression")
	public void login_test1() 
	{
		boolean result = homepg.login_errcheck2();
		System.out.println("Error message displaying for Password : " + result);
		assertEquals(result, true);
	}

	@Test(priority = 4, groups = "Regression")
	public void login_test2() 
	{
		boolean result = homepg.login_errcheck3();
		System.out.println("Error message displaying for Username : " + result);
		assertEquals(result, true);
	}

	@AfterMethod
	public void close() {
		 driver.close();
	}
}


