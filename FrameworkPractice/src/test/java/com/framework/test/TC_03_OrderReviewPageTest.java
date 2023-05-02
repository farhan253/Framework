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
import com.framework.pageobjects.TC_03_OrderReviewPage;

public class TC_03_OrderReviewPageTest extends BaseClass {

	TC_01_LoginPage login;
	TC_03_OrderReviewPage order;
	
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
	
	
	
	
	@Test(priority=2,dataProvider = "shipping address", dataProviderClass = DataProviders.class)
	public void orderReviewTest(String fname,String lname,String address,String city,String postal,String Phone) throws InterruptedException
	{
	
		Thread.sleep(5000);
		order=new TC_03_OrderReviewPage();
		order.checkout(fname, lname, address, city, postal, Phone);
		order.validateOrderReviewPage();
	}
}
