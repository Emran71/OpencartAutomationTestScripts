package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement my_account_test;

	public boolean myAccountText()
	{
		try {
			return (my_account_test.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
