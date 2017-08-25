package homePage;

import org.junit.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import UIActions.homePage;
import testBase.TestBase;

public class TC003_VerifyLoginMultipleInput extends TestBase{
	
	homePage homepage;
	
	@DataProvider(name="loginTestData")
	public String[][]  getTestData()
	{
		String[][] testRecords = getData("TestData.xls","loginTestData");
		return testRecords;
		
	}
	
	
	
	@BeforeClass
	public void setup()
	{
		init();
	}
	
	@Test (groups="sanity")
	public void TestLogin()
	{
		log.info("------------------Starting  TC003_VerifyLoginMultipleInput Test-------------------");
		homepage = new homePage(driver);
		//homepage.logintoApplication(emailaddress, password);
		log.info("------------------Finished  TC003_VerifyLoginMultipleInput Test-------------------");

	}
	
	@AfterClass
	public void endTest()
	{
		driver.close();
		
	}
	
}
