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
	
	@FindBy(name="search")
	WebElement searchBox;

	@FindBy(xpath="//span/button")
	WebElement search_Button;


	
	
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
	
	public void enterProductName(String product)
	{
		searchBox.clear();
		searchBox.sendKeys(product);
	}

	public void clickSearchButton()
	{
		search_Button.click();
	}
}
