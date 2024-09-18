package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txt_fstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txt_lstname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_Email;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txt_phone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_password;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txt_Confirm_pass;

	@FindBy(xpath = "//label[normalize-space()='Yes']//input[@name='newsletter']")
	WebElement txt_news_subscribe;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement txt_privacy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement txt_continue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement txt_getConfirm_mgs;

	
	public void setFirstName(String fstname) {
		txt_fstname.sendKeys(fstname);
	}

	public void setLastName(String lstname)
	{
		txt_lstname.sendKeys(lstname);
	}

	public void setEmail(String email) 
	{
		txt_Email.sendKeys(email);
	}

	public void setPhone(String phone)
	{
		txt_phone.sendKeys(phone);
	}

	public void setPassword(String pwd) 
	{
		txt_password.sendKeys(pwd);
	}

	public void setConfirmPassword(String pwd) 
	{
		txt_Confirm_pass.sendKeys(pwd);
	}
	
	public void clickSubscribe() 
	{
		txt_news_subscribe.click();
	}
	
	public void clickPrivacy() 
	{
		txt_privacy.click();
	}
	
	public void clickContinue() 
	{
		txt_continue.click();
	}
	
	public String getConfirmationMessage() 
	{
		try {
			return (txt_getConfirm_mgs.getText());
		}
		catch(Exception e){
			return (e.getMessage());
		}
	}
	
	
}