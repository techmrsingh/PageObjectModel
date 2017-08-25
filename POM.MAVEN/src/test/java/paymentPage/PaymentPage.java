package paymentPage;

import org.junit.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import testBase.TestBase;

public class PaymentPage extends TestBase{
	
	@BeforeClass
	public void setup()
	{
		init();
	}
	
	@Test(groups="sanity")
	public void payment()
	{
		log.info("------------------Starting  Payment_Dummy Test Started-------------------");
		System.out.println("inside");
	}

	
	@AfterClass
	public void endTest()
	{
		driver.close();
		
	}
}
