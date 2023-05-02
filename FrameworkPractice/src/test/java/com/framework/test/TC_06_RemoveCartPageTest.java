package com.framework.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.base.BaseClass;
import com.framework.pageobjects.TC_01_LoginPage;
import com.framework.pageobjects.TC_06_RemoveCartPage;

public class TC_06_RemoveCartPageTest extends BaseClass {
	TC_01_LoginPage login;
	TC_06_RemoveCartPage remove;
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
    @Test(priority=5)
    public void removeCartTest()
    {
    	login=new TC_01_LoginPage();
    	login.loginpage(prop.getProperty("email"),prop.getProperty("password"));
    	remove=new TC_06_RemoveCartPage();
    	remove.removeCart();
    	remove.validateRemoveCart();
    }

}
