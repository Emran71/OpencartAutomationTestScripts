package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public WebDriver driver;

	@BeforeClass
	public void setupBrowser()
	{
		driver= new ChromeDriver();
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
