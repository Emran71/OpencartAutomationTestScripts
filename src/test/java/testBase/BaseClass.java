package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	

	@BeforeClass
	@Parameters({"OS","browser"})
	public void setupBrowser(String os, String br)
	{   
		logger = LogManager.getLogger(this.getClass());
		
		
		switch(br.toLowerCase()) {
		case "chrome": driver= new ChromeDriver();break;
		case "firefox": driver= new FirefoxDriver();break;
		default: System.out.println("Invalid browser"); return;
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void closetest()
	{
		driver.quit();
	}
	
 
	public String randomCharacterGenerate() 
	{
		String characters = RandomStringUtils.randomAlphabetic(6);
		return characters;
	}
     
	
	public String randomNumberGenerate() 
	{
		String number = RandomStringUtils.randomNumeric(11);
		return number;
	}

	
	public String randomAlphaNumaricGenerate() 
	{
		String alphanumeric = RandomStringUtils.randomAlphanumeric(10);
		return alphanumeric;
	}
}
