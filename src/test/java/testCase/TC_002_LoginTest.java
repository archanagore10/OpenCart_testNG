package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	 
	@Test(groups={"Sanity","Master"})
	public void test_Login() 
	{
		logger.info("************starting TC_002_login_test*****************");
		
		try
		{
		HomePage homepage=new HomePage(driver);
		
		logger.info("clicking on my account");
		homepage.clickMyAccount();
		
		logger.info("clicking on login");
		homepage.clickLogin();
		
		LoginPage loginpage=new LoginPage(driver);
		logger.info("enetring email id");
		//loginpage.setEmail(p.getProperty("email"));		
		loginpage.setEmail(rb.getString("email"));
		
		logger.info("entering password");
		loginpage.setPassword(rb.getString("password"));
		//loginpage.setPassword(rb.getString("xyz"));	//for testing failed test cases. purposefully failed
		//loginpage.setPassword(p.getProperty("password"));
		
		logger.info("clicking on login button");
		loginpage.click_loginButton();
		
		//is MyAccount label present
		
		MyAccountPage myacc=new MyAccountPage(driver);
		
		logger.info("verifying MyAccount label on my account page");
		boolean targetPage=myacc.verify_myAccount();
		
		Assert.assertEquals(targetPage,true);	
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("************finished TC_002_login_test*****************");
	}
		

}
