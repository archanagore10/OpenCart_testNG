package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
	
	WebDriver driver;
	public SearchPage(WebDriver driver)
	{
		super(driver);
		
	}

	@FindBy(xpath="//*[@id='content']/div[3]//img")
	List<WebElement> searchedProducts;
			
	//@FindBy(name="quantity")
	//WebElement quantity;
	@FindBy(xpath="//input[@id='input-quantity']")
	WebElement quantity;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement addtoCart;
		
	@FindBy(xpath="//div[contains(text(),'Success: You have added ')]")
	WebElement confirm_msg;
	
	//checking if searched product is available
	public boolean isProductExists(String productName)
	{
		boolean flag=false;
		for(WebElement product:searchedProducts)
		{
			if(product.getAttribute("title").equals(productName))
			{
				flag=true;
				break;
			}
			
		}
		return flag;
	}
	
	//clicking on the product 
	public void clickProduct(String productName)
	{
		for(WebElement product:searchedProducts)
		{				
			if(product.getAttribute("title").equals(productName))
			{
				product.click();
			}
		}
	
	}
	
	public void enterQuantity(String qty)
	{
		quantity.clear();
		quantity.sendKeys(qty);
	}
	
	public void clickAddToCart()
	{
		addtoCart.click();
	}
	
	public boolean confirmationMessage()
	{
		try 
		{
		return confirm_msg.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
