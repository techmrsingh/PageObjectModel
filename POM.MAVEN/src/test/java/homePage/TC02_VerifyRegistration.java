package homePage;

import org.testng.annotations.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import testBase.TestBase;

public class TC02_VerifyRegistration extends TestBase {
	
	@BeforeClass
	public void setup()
	{
		init();
	}
	
	@Test
	public void testLogin()
	{
		log.info("------------------Starting  Registration Test-------------------");
	}
	
	@AfterClass
	public void endTest()
	{
		driver.quit();
		
	}
	
	
}
