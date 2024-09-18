package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class TC_001_RegistrationTest {

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

	@Test
	public void Reg_test()
	{
		HomePage hp = new HomePage(driver);
		hp.myAccount();
		hp.registerMenu();

		RegistrationPage regpage = new RegistrationPage(driver);
		regpage.setFirstName(randomCharacterGenerate().toUpperCase());
		regpage.setLastName(randomCharacterGenerate().toUpperCase());
		regpage.setEmail(randomCharacterGenerate()+"@gmail.com");
		regpage.setPhone(randomNumberGenerate());

		String pass = randomNumberGenerate();
		regpage.setPassword(pass);
		regpage.setConfirmPassword(pass);
		
		regpage.clickSubscribe();
		regpage.clickPrivacy();
		regpage.clickContinue();
		String responsemgs = regpage.getConfirmationMessage();

		Assert.assertEquals(responsemgs, "Your Account Has Been Created!");  	
	}

	
	String randomCharacterGenerate() 
	{
		String characters = RandomStringUtils.randomAlphabetic(6);
		return characters;
	}
     
	
	String randomNumberGenerate() 
	{
		String number = RandomStringUtils.randomNumeric(11);
		return number;
	}

	
	String randomAlphaNumaricGenerate() 
	{
		String alphanumeric = RandomStringUtils.randomAlphanumeric(10);
		return alphanumeric;
	}


}
