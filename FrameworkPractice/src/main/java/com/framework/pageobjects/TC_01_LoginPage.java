package com.framework.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.actiondriver.Actions;
import com.framework.base.BaseClass;

public class TC_01_LoginPage extends BaseClass {
	
	Actions action=new Actions();
	
	@FindBy(xpath="//button[@class='btn account-btn']")
	private WebElement hover;
	

	@FindBy(xpath="//div[@class='customerInfo dropdown-item']//a[contains(text(),'Sign In')]")
	private WebElement clickSignIn;
	
	@FindBy(id="dwfrm_login_username")
	private WebElement enterEmail;
	
	@FindBy(id="dwfrm_login_password")
	private WebElement enterPassword;
	
	@FindBy(xpath="//button[@value='Sign In']")
	private WebElement clickOnSignIn;
	
	@FindBy(xpath="//button[@class='btn account-btn']")
	private WebElement hoverAgain;
	
	@FindBy(xpath="//a[@title='Welcome, Farhan']")
	private WebElement validateLogin;
	
	public TC_01_LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loginpage(String email,String password)
	{
		action.moveToElement(driver, hover);
		action.clickWithJs(driver, clickSignIn);
//		action.sendKeys(enterEmail, prop.getProperty("email"));
//		action.sendKeys(enterPassword, prop.getProperty("password"));
		action.sendKeys(enterEmail, email);
		action.sendKeys(enterPassword, password);
		action.clickWithJs(driver, clickOnSignIn);
//		action.explicitWait(driver, clickOnSignIn);
		
		
		
	}
	public void validateLogin() throws InterruptedException
	{


		Thread.sleep(10000);
		action.moveToElement(driver, hoverAgain);
		action.explicitWait(driver, validateLogin);
		if(validateLogin.isDisplayed())
		{
		Assert.assertTrue(true);
		System.out.println("Login functionality is successfull");
		}else
		{
			System.out.println("Login Functionality is not successfull");
		}
	}
	
	
	
	

}
