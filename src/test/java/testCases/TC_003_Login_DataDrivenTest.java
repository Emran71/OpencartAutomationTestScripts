package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_Login_DataDrivenTest extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verifyLoginDDT(String email, String password, String status)
	{

		logger.info("************Starting TC_003_Login_DataDrivenTest Test***********");
		try 
		{
			HomePage hp = new HomePage(driver);
			hp.clickmyAccount();
			hp.clickRegisterLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin();

			MyAccountPage map = new MyAccountPage(driver);
			boolean tergetpage = map.myAccountTextDisplay();
            //System.out.println(tergetpage);
			if(status.equalsIgnoreCase("Valid"))
			{
				if(tergetpage==true)
				{
					map.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);;
				}
			}
			
			else if(status.equalsIgnoreCase("Invalid"))
			{
				if(tergetpage==true)
				{
					map.clickLogout();
					Assert.assertTrue(false);;
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e)
		{
           Assert.fail();
		}
      
		logger.info("*********Finished The TC_003_Login_DataDrivenTest Test*********");
	}
}
