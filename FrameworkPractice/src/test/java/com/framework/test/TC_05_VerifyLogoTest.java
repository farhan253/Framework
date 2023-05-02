package com.framework.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.base.BaseClass;
import com.framework.dataprovider.DataProviders;
import com.framework.pageobjects.TC_01_LoginPage;
import com.framework.pageobjects.TC_05_VerifyLogo;

public class TC_05_VerifyLogoTest extends BaseClass {
	

TC_05_VerifyLogo logo;
	
	
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
	@Test(groups="smoke",priority=4,dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void LoginTest(String email,String password) throws InterruptedException
	{
		
		logo=new TC_05_VerifyLogo();
		logo.verifyLogo(email, password);
		logo.validateLogo();
	}

}
