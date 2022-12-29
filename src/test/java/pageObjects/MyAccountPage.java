package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	WebDriver driver;
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	//@FindBy(xpath="//h2[text()='My Account']")
	@FindBy(xpath="//div[@id='content']/h2[1]")
	WebElement myacc;
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	
	public boolean verify_myAccount()
	{
		try
		{
		return (myacc.isDisplayed());
		} 
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void click_logout()
	{
		logout.click();
	}

}
