package testCase;

import static org.testng.Assert.fail; 

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationForm extends BaseClass{
	
	@Test(groups= {"Master","Regression"}) 
	public void Test_AccountRegistration()
	{
		logger.info("***************starting TC_001_AccountRegistrationTest*************");
		try //try catch block is to avoid termination if something goes wrong
		{
		HomePage homepage=new HomePage(driver);
		
		logger.info("clicking on My Account link");
		homepage.clickMyAccount();
		
		logger.info("clicking on register link");
		homepage.clickRegister();
		
		AccountRegistrationPage acc_register=new AccountRegistrationPage(driver);
		
		logger.info("providing customer details");
		acc_register.setFirstName(randomString().toUpperCase());
		acc_register.setLastName(randomString().toUpperCase());
		
		acc_register.setphoneNumber(randomNumber());
		acc_register.setEmail(randomString()+"@gmail.com");
		
	//	acc_register.setPassword(randomAlphaNumeric());     //generates two alphanumeric strings
	//	acc_register.setConfirmPasssword(randomAlphaNumeric());
		
		String password=randomAlphaNumeric();
		acc_register.setPassword(password);
		acc_register.setConfirmPasssword(password);
		
		//acc_register.setConfirmPasssword("abc");//to fail the test case and see warn log
		
		acc_register.clickPrivacyPolicy();
		
		logger.info("clicking on continue button");
		acc_register.clickContinueBtn();
		
		String confirmMasg=acc_register.confirmationMsg();
		
		logger.info("verifying customer registration");
		
		if(confirmMasg.equals("Your Account Has Been Created!"))
		{
			logger.info("test passed..........");
			Assert.assertTrue(true);
		}
		
		else
		{
			logger.warn("customer registration is not successful");
			logger.info("test failed..........");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			Assert.fail(); //will fail test case 
		}
		
		logger.info("***************Finished TC_001_AccountRegistrationTest*************");
	}

}
