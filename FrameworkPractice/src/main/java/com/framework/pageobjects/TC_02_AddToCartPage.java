package com.framework.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.actiondriver.Actions;
import com.framework.base.BaseClass;

public class TC_02_AddToCartPage extends BaseClass{
	
	Actions action=new Actions();
	
	@FindBy(xpath="//span[@title='Décor']")
	private WebElement hoverOnDecors;
	
	@FindBy(xpath="//a[@title='Outdoor Umbrellas']")
	private WebElement clickOutdoorUmbrellas;
	
	@FindBy(xpath="//img[@data-src='https://images.lumens.com/is/image/Lumens/CALP443183?$Lumens.com-PRP-large$']")
	private WebElement selectItem;
	
	@FindBy(xpath="//input[@name='Quantity']")
	private WebElement enterQuantity;
	
	@FindBy(xpath="//button[@id='add-to-cart']")
	private WebElement clickAddToCartButton;
	
	@FindBy(xpath="//div[contains(text(),'Added to Your Cart')]")
	private WebElement addtocartsuccess;
	
	public TC_02_AddToCartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addCartTest() throws InterruptedException
	{
		action.moveToElement(driver, hoverOnDecors);
		Thread.sleep(2000);
		action.clickWithJs(driver, clickOutdoorUmbrellas);
		action.explicitWaitClick(driver, selectItem);
		action.scrollByVisibilityOfElement(driver, selectItem);
		action.clickWithJs(driver, selectItem);
		Thread.sleep(2000);
		action.sendKeys(enterQuantity, "3");
		Thread.sleep(5000);
		action.clickWithJs(driver, clickAddToCartButton);
		
	}
	public void addcartValidation()
	{
		if(addtocartsuccess.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Added to cart successfully");
		}else
		{
			System.out.println("Not added to cart successfully");
		}
	}
	
	
	

}
