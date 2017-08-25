package UIActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import homePage.TC001_VerifyLoginWithInvalidCredentials;
import testBase.TestBase;

public class homePage extends TestBase{

	public static final Logger log=Logger.getLogger(homePage.class.getName());

	
	WebDriver driver;
	@FindBy(xpath=".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;
	
	@FindBy(xpath=".//*[@id='email']")
	WebElement loginEmailAddress;
	
	@FindBy(xpath=".//*[@id='email']")
	WebElement loginPassword;
	
	
	@FindBy(xpath=".//*[@id='SubmitLogin']")
	WebElement submitButton;
	
	@FindBy(xpath=".//*[@id='center_column']/div[1]/ol/li")
	WebElement authenticationFailed;

	
	
	public homePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	
	}
	
	
	public void logintoApplication(String emailaddress,String password){
		
		signIn.click();
		log.info("clicked on the object and now signing in ");
		loginEmailAddress.sendKeys(emailaddress);
		log.info("Entered Email Address ");
		loginPassword.sendKeys(password);
		log.info("Entered Password");
		submitButton.click();
		log.info("Clicked on Submit Button ");

	}
	
	public String getInvalidLoginText()
	{
		return authenticationFailed.getText();
	}
	
	
}
