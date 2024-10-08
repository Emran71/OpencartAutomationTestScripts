package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_001_RegistrationTest extends BaseClass{

	@Test
	public void Reg_test()
	{  
		logger.info(".........Starting TC_001.......");
		HomePage hp = new HomePage(driver);
		hp.clickmyAccount();
		logger.info(".......Clicked On My account link......");
		hp.clickregisterMenu();
		logger.info(".....Clicked On Register link........");

		try
		{
		RegistrationPage regpage = new RegistrationPage(driver);

		regpage.setFirstName(randomCharacterGenerate().toUpperCase());
		logger.info(".........Inputed first name.......");
		regpage.setLastName(randomCharacterGenerate().toUpperCase());
		logger.info(".........Inputed second name.......");
		regpage.setEmail(randomCharacterGenerate()+"@gmail.com");
		logger.info(".........Inputed email name.......");
		regpage.setPhone(randomNumberGenerate());
		logger.info(".........Inputed Mobile Number.......");

		String pass = randomAlphaNumaricGenerate();
		regpage.setPassword(pass);
		regpage.setConfirmPassword(pass);
		logger.info(".........Inputing Password.......");

		regpage.clickSubscribe();
		regpage.clickPrivacy();
		regpage.clickContinue();
		logger.info(".........Validating Expected Message.......");
		String responsemgs = regpage.getConfirmationMessage();

		Assert.assertEquals(responsemgs, "Your Account Has Been Created!");
		} 
		catch(Exception e)
		{
			logger.error("......Failed Test....");
			logger.debug("....Debug logs.....");
			Assert.fail();
		}
		logger.info(".........Finished TC_001.......");
	}

}
