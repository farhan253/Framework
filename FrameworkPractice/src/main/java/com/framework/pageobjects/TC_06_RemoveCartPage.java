package com.framework.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.actiondriver.Actions;
import com.framework.base.BaseClass;

public class TC_06_RemoveCartPage extends BaseClass{
	
Actions action=new Actions();
	
	@FindBy(xpath="//span[@class='num-minicart']")
	private WebElement hoverOnCart;
	
	@FindBy(xpath="//a[@title='View Cart']")
	private WebElement clickOnViewCart;
	
	@FindBy(xpath="//span[contains(text(),'Remove')]")
	private WebElement removecart;
	
	@FindBy(xpath="//h1[text()='Your cart is empty']")
	private WebElement validateRemoveCart;
	
	public TC_06_RemoveCartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void removeCart()
	{
		action.moveToElement(driver, hoverOnCart);
		action.explicitWaitClick(driver, clickOnViewCart);
		action.clickWithJs(driver, clickOnViewCart);
		action.explicitWaitClick(driver, removecart);
		action.clickWithJs(driver, removecart);
		
		
	}
	public void validateRemoveCart()
	{
		Assert.assertTrue(validateRemoveCart.isDisplayed());
		System.out.println("Successfully removed item");
	}

}
