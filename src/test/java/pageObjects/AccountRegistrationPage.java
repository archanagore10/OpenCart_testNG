package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountRegistrationPage extends BasePage{
	
	WebDriver driver;
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="input-firstname")
	WebElement firstName;
	
	@FindBy(id="input-lastname")
	WebElement lastName;
	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-telephone")
	WebElement phoneNumber;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(id="input-confirm")
	WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement privacyPolicy;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement continueButton;
	
	
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement verifyMsg;
	
	
	public void setFirstName(String fname)
	{
		firstName.sendKeys(fname);
	}

	public void setLastName(String lname)
	{
		lastName.sendKeys(lname);
	}
	
	public void setEmail(String mail)
	{
		email.sendKeys(mail);
	}
	
	public void setphoneNumber(String tel)
	{
		phoneNumber.sendKeys(tel);
	}
	
	public void setPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void setConfirmPasssword(String cpass)
	{
		confirmPassword.sendKeys(cpass);
	}
	
	public void clickPrivacyPolicy()
	{
		privacyPolicy.click();
	}
	
	public void clickContinueBtn()
	{
		continueButton.click();
	}
	
	public String confirmationMsg()
	{
		return verifyMsg.getText();
	}
}
