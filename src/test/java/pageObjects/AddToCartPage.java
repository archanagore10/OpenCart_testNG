package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends BasePage{
	WebDriver driver;
	
	public AddToCartPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath="//div[@id='cart']")
	WebElement cartItems;
	
	@FindBy(xpath="//p[@class='text-right']/a[1]")
	WebElement viewCart;
	

	@FindBy(xpath="//p[@class='text-right']/a[2]")
	WebElement checkout;
	
	public void ClickCartItems()
	{
		cartItems.click();
	}
	
	public void clickViewCart()
	{
		viewCart.click();
	}
	
	public void clickCheckOut()
	{
		checkout.click();
	}
	
}
