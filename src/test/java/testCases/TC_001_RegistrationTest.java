package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class TC_001_RegistrationTest extends BaseClass{
   
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

		String pass = randomAlphaNumaricGenerate();
		regpage.setPassword(pass);
		regpage.setConfirmPassword(pass);
		
		regpage.clickSubscribe();
		regpage.clickPrivacy();
		regpage.clickContinue();
		String responsemgs = regpage.getConfirmationMessage();

		Assert.assertEquals(responsemgs, "Your Account Has Been Created!");  	
	}

	
	


}
