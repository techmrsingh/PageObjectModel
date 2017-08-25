package homePage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import UIActions.homePage;
import testBase.TestBase;

public class TC001_VerifyLoginWithInvalidCredentials extends TestBase{

	public static final Logger log=Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());

 	
	homePage homepage;
	
	@BeforeTest(groups="Regression")
	public void setUp()
	{
		init();
		
	}
	
	@Test(groups="Regression")
	
	public void verifyLoginWithInvalidCredentials() throws InterruptedException, IOException
	{
		log.info("------------------Starting  verifyLoginWithInvalidCredentials Test-------------------");
		homepage=new homePage(driver);
		homepage.logintoApplication("TEST","123");
		getScreenShot("verifyLoginWithInvalidCredentials");
		Assert.assertEquals(homepage.getInvalidLoginText(),"Invalid email address." );
		log.info("------------------Finished verifyLoginWithInvalidCredentials Test-------------------");
	}

	@AfterTest(groups="Regression")
	public void endTest()
	{
		driver.close();
	}
}
