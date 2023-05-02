package com.framework.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.actiondriver.Actions;
import com.framework.base.BaseClass;

public class TC_05_VerifyLogo extends BaseClass {
	
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
	
	@FindBy(xpath="//a[@class='logo-link lu-sprite']")
	private WebElement verifyLogo;
	
	public TC_05_VerifyLogo()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifyLogo(String email,String password)
	{

		action.moveToElement(driver, hover);
		action.clickWithJs(driver, clickSignIn);
		action.sendKeys(enterEmail, email);
		action.sendKeys(enterPassword, password);
		action.clickWithJs(driver, clickOnSignIn);
	}
	public void validateLogo()
	{
		if(verifyLogo.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("successfully verified logo");
		}else
		{
			System.out.println("Logo not verified");
		}
	}

}
