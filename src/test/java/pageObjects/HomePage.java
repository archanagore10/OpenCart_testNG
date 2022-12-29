package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//ul[@class='list-inline']/li[2]/a")
	WebElement myAccount;
	
	@FindBy(linkText = "Register")
	WebElement registerbutton;
	
	@FindBy(linkText="Login")
	WebElement loginLink;
	
	
	public void clickMyAccount()
	{
		myAccount.click();
	}
	
	public void clickRegister()
	{
		registerbutton.click();
	}
	
	public void clickLogin()
	{
		loginLink.click();
	}
}
