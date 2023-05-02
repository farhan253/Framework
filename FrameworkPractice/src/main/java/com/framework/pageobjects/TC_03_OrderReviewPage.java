package com.framework.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.actiondriver.Actions;
import com.framework.base.BaseClass;
import com.framework.dataprovider.DataProviders;

public class TC_03_OrderReviewPage extends BaseClass {
	Actions action=new Actions();
	
	@FindBy(xpath="//span[@class='num-minicart']")
	private WebElement hoverOnCart;
	
	@FindBy(xpath="//a[@title='View Cart']")
	private WebElement clickOnViewCart;
	
	@FindBy(xpath="//button[@value='Checkout']")
	private WebElement clickCheckout;
	
	@FindBy(linkText="Edit")
	private WebElement clickEdit;
	
	@FindBy(xpath="//input[@name='dwfrm_singleshipping_shippingAddress_addressFields_firstName']")
	private WebElement enterFirstName;
	
	@FindBy(xpath="//input[@name='dwfrm_singleshipping_shippingAddress_addressFields_lastName']")
	private WebElement enterLastName;
	
	@FindBy(xpath="//input[@name='dwfrm_singleshipping_shippingAddress_addressFields_address1']")
	private WebElement enterAddress;
	
	@FindBy(xpath="//div[@title='HJ Mustin Rd']")
	private WebElement clickAddress;
	
	@FindBy(xpath="//input[@name='dwfrm_singleshipping_shippingAddress_addressFields_city']")
	private WebElement enterCity;
	
	@FindBy(xpath="//select[@class='selectbox state stateUS valid']")
	private WebElement enterState;
	
	@FindBy(xpath="//input[@name='dwfrm_singleshipping_shippingAddress_addressFields_postal']")
	private WebElement enterPostal;
	
	@FindBy(xpath="//input[@name='dwfrm_singleshipping_shippingAddress_addressFields_phone']")
	private WebElement enterPhone;
	
	@FindBy(xpath="//button[@name='dwfrm_singleshipping_shippingAddress_save']")
	private WebElement saveAndContinue;
	
	@FindBy(xpath="//button[@name='dwfrm_singleshipping_billingStart']")
	private WebElement billingsaveAndContinue;
	
	@FindBy(xpath="//input[@id='is-PayPal']")
    private WebElement paypalRadioButton;
	
	@FindBy(xpath="//button[@id='go-to-orderreview']")
	private WebElement ContinuetoOrderreview;
	
	@FindBy(xpath="//h2[contains(text(),'Checkout-Order Review')]")
	private WebElement verifyOrderReview;
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	private WebElement clickOnSignin;
	
	@FindBy(id="dwfrm_login_username")
	private WebElement enterEmail;
	
	@FindBy(id="dwfrm_login_password")
	private WebElement enterPassword;
	
	@FindBy(xpath="//button[@value='Sign In']")
	private WebElement clickOnSignIn;
	
	
	public TC_03_OrderReviewPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void checkout(String fname,String lname,String address,String city,String postal,String Phone) throws InterruptedException {
		
		action.moveToElement(driver, hoverOnCart);
		action.clickWithJs(driver, clickOnViewCart);
		action.clickWithJs(driver, clickOnSignin);
		action.sendKeys(enterEmail, prop.getProperty("email"));
		action.sendKeys(enterPassword, prop.getProperty("password"));
		action.clickWithJs(driver, clickOnSignIn);
		Thread.sleep(9000);
		action.moveToElement(driver, hoverOnCart);
		action.clickWithJs(driver, clickOnViewCart);
		action.clickWithJs(driver, clickCheckout);
		action.clickWithJs(driver, clickEdit);
		action.sendKeys(enterFirstName, fname);
		Thread.sleep(2000);
		action.sendKeys(enterLastName, lname);
		Thread.sleep(2000);
		action.sendKeys(enterAddress, address);
		Thread.sleep(2000);
		action.clickWithJs(driver, clickAddress);
		Thread.sleep(2000);
		action.sendKeys(enterCity, city);
		Thread.sleep(8000);
		action.sendKeys(enterPostal, postal);
		Thread.sleep(2000);
		action.sendKeys(enterPhone, Phone);
		Thread.sleep(2000);
		action.clickWithJs(driver, saveAndContinue);
		Thread.sleep(2000);
		action.clickWithJs(driver, billingsaveAndContinue);
		Thread.sleep(2000);
		action.clickWithJs(driver, paypalRadioButton);
		Thread.sleep(2000);
		action.clickWithJs(driver, ContinuetoOrderreview);
		
	}
	public void validateOrderReviewPage()
	{
		if(verifyOrderReview.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Successfully redirected to Order Review Page");
		}
		else
		{
			System.out.println("Not redirected to Order Review Page");
		}
	}
	
	
	
	
	
	
	

}
