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
import com.framework.pageobjects.TC_01_LoginPage;

public class TC_01_LoginPageTest extends BaseClass {

	TC_01_LoginPage login;
	
	
    @BeforeMethod(groups={"smoke"})
	public void launchBrowser()
	{
		BaseClass.invokeBrowser();
	}
    @AfterMethod(groups={"smoke"})
    public void CloseBrowser()
    {
    	BaseClass.closeBrowser();
    }
	@Test(groups="smoke",priority=0,dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void LoginTest(String email,String password) throws InterruptedException
	{
		login=new TC_01_LoginPage();
		login.loginpage(email, password);
		login.validateLogin();
	}
}
