package com.framework.test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.base.BaseClass;
import com.framework.dataprovider.DataProviders;
import com.framework.pageobjects.TC_02_AddToCartPage;
import com.framework.pageobjects.TC_01_LoginPage;

public class TC_02_AddToCartPageTest extends BaseClass{

	TC_01_LoginPage login;
	TC_02_AddToCartPage cart;
	@BeforeMethod
    public void launchBrowser()
		{
			BaseClass.invokeBrowser();
		}
   @AfterMethod
   public void CloseBrowser()
	    {
	    	BaseClass.closeBrowser();
	    }

	@Test(priority=1,dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void addCartTest(String email,String password) throws InterruptedException
	{
		login=new TC_01_LoginPage();
		login.loginpage(email, password);
		cart=new TC_02_AddToCartPage();
		cart.addCartTest();
		cart.addcartValidation();
	}
}
