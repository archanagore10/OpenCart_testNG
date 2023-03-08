package testCase;

import pageObjects.SearchPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseClass;
import pageObjects.AddToCartPage;
import pageObjects.HomePage;

public class TC_005_AddToCartTest extends BaseClass{
	
	@Test
	public void test_addToCart()
	{
		logger.info("***************starting TC_005_AddToCartTest**********");
		try
		{
			HomePage homepage=new HomePage(driver);
			
			logger.info("entering product name to search");
			homepage.enterProductName("iPhone");
			//homepage.enterProductName("macbook");
			
			logger.info("clicking on search button");
			homepage.clickSearchButton();
			
		SearchPage searchpage=new SearchPage(driver);
	
		if(searchpage.isProductExists("iPhone"))
		//	if(searchpage.isProductExists("macbook"))
		{
			
		logger.info("clicking on the searched product");
		
		searchpage.clickProduct("iPhone");
		//searchpage.clickProduct("macbook");
		
		logger.info("entering quantity");
		searchpage.enterQuantity("2");
		
		logger.info("clicking on add to cart button");
		searchpage.clickAddToCart();
		}
		Assert.assertEquals(searchpage.confirmationMessage(), true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***************ending TC_005_AddToCartTest**********");
		
	}

}
