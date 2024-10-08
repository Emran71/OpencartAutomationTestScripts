package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	@Test
	public void loginTest()
	{
		logger.info(".................Test Starting................");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickmyAccount();
			hp.clickregisterLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			MyAccountPage mcp = new MyAccountPage(driver);
			boolean tergetpage = mcp.myAccountText();

			Assert.assertTrue(tergetpage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
}
