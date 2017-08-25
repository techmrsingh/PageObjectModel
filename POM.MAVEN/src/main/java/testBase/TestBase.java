package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.WebConsole.Formatter;

import excelReader.*;

public class TestBase {

	
	public WebDriver driver;
	public String url="http://automationpractice.com/index.php";
	String browser="firefox";
	public static final Logger log=Logger.getLogger(TestBase.class.getName());
	Excel_Reader excel;
	
	public void init(){
		
		selectBrowser(browser);
		gerUrl(url);
		String log4jConfPath="log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}

	public void selectBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"/driver/geckodriver" );
			log.info("creating object of browser");
			driver=new FirefoxDriver();
		}
		
	}

	public void gerUrl(String url)
	{
		log.info("navigating to "+ url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}

	
	public String[][] getData(String excelName,String sheetName)
	{
		String Path=System.getProperty("user.dir")+"src/main/java/data/"+excelName;
		excel=new Excel_Reader(Path);
		String data[][]=excel.getDataFromSheet(sheetName,excelName);
		return data;
	}
	
	
	public void getScreenShot(String name) throws IOException
	{
		Calendar calender=Calendar.getInstance();
		SimpleDateFormat formater=new SimpleDateFormat("DD_MM_YY_hh_mm_ss");
		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			String reportDirectory=new File(System.getProperty("user.dir")).getAbsolutePath() + "src/main/java/Screenshot/";
			File destFile=new File((String)reportDirectory+ name +"_" + formater.format(calender.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destFile);
			
			Reporter.log("<a href='"+destFile.getAbsolutePath()+"'> <img src='"+destFile.getAbsolutePath()+"' heigth='100' widhth='100'/> </a>");
		} catch (Exception e) {
			System.out.println("Error in Screenshot Generation");
			e.printStackTrace();
		}
		
	}

	
	
}
