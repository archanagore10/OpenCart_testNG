package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_004_SearchProduct extends BaseClass{
	@Test
	public void test_search()
	{
		logger.info("*********starting TC_004_SearchProduct****************");
		try
		{
		HomePage homepage=new HomePage(driver);
		
		logger.info("entering product name to search");
		//homepage.enterProductName("iphone");
		homepage.enterProductName("macbook");
		
		logger.info("clicking on search button");
		homepage.clickSearchButton();
		
		SearchPage searchpage=new SearchPage(driver);
		
		logger.info("checking if searched product exists");
		//searchpage.isProductExists("iphone");
		searchpage.isProductExists("macbook");
		Assert.assertEquals(searchpage.isProductExists("MacBook"),true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*********Ending TC_004_SearchProduct****************");
	}

}
