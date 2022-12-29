package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass{
	
	@Test(dataProvider="loginData", dataProviderClass=DataProviders.class, groups="datadriven")	//dataprovider method is in seperate package so need to provide class
	public void test_loginDDt(String email, String password, String exp_result)
	{
		logger.info("*******starting TC_003_LoginDataDrivenTest**********");
		try
		{
		
		HomePage homepage=new HomePage(driver);
		 
		logger.info("clicking on my account");
		homepage.clickMyAccount();
		
		logger.info("clicking on login");
		homepage.clickLogin();
		
		LoginPage loginpage=new LoginPage(driver);
		
		logger.info("entering email id");
		loginpage.setEmail(email);
		
		logger.info("entering password");
		loginpage.setPassword(password);
			
		logger.info("clicking on login button");
		loginpage.click_loginButton();
		
		//is MyAccount label present
		
		MyAccountPage myacc=new MyAccountPage(driver);
		
		logger.info("verifying MyAccount label on my account page");
		boolean targetPage=myacc.verify_myAccount();
		
		System.out.println("value of exp_result is:"+exp_result);
		System.out.println("target page:"+targetPage);
		
		if(exp_result.equals("valid"))
		{
			logger.info("validating valid data");
			if(targetPage==true)
			{
				myacc.click_logout();	//need to logout when login is successful
				Assert.assertTrue(true);
			}
			else
			{ 
				Assert.fail();
			}
		}
		
		if(exp_result.equals("invalid"))
		{
			logger.info("validating invalid data");
			if(targetPage==true)
			{
				myacc.click_logout();
				Assert.fail();
			}
			else
			{
				logger.info("validating invalid data");
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("************finished TC_003_LoginDataDrivenTest*****************");
	}
		

	}


