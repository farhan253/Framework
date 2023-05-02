package com.framework.actiondriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.base.BaseClass;

public class Actions extends BaseClass {

	
	public boolean moveToElement(WebDriver driver,WebElement element)
	{
		boolean flag=false;
		try {
			
			org.openqa.selenium.interactions.Actions act=new org.openqa.selenium.interactions.Actions(driver);
			act.moveToElement(element).build().perform();
			flag=true;
		} catch (Exception e) {
			flag=false;
		}finally
		{
			if(flag=true)
			{
				System.out.println("MouseHover is performed successfully");
			}else
			{
				System.out.println("MouseHover is not performed");
			}
		}
		return flag;
	}
	
	public boolean clickWithJs(WebDriver driver, WebElement element)
	{
		boolean flag=false;
		try {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", element);
			flag=true;
		} catch (Exception e) {
			flag=false;
		}finally
		{
			if(flag=true)
			{
				System.out.println("Click action is performed successsfully");
			}else
			{
				System.out.println("click action is not performed");
			}
		}
		return flag;
	}
	
	
	
	public boolean sendKeys(WebElement ele, String text) {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			// logger.info("Entered text :"+text);
			flag = true;
		} catch (Exception e) {
			System.out.println("Location Not found");
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully entered value");
			} else {
				System.out.println("Unable to enter value");
			}

		}
		return flag;
	}
	
	public boolean explicitWait(WebDriver driver, WebElement element) {
		boolean flag=false;
		try {
			WebDriverWait wait=new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element));
			flag=true;
		} catch (Exception e) {
			flag=false;
		}
		return flag;
	}
	public boolean explicitWaitClick(WebDriver driver, WebElement element) {
		boolean flag=false;
		try {
			WebDriverWait wait=new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			flag=true;
		} catch (Exception e) {
			flag=false;
		}
		return flag;
	}
	
	public void scrollByVisibilityOfElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public boolean selectByValue(WebElement element,String value)
	{
		boolean flag=false;
		try {
			Select s=new Select(element);
			s.selectByValue(value);
			flag=true;
			
			
		} catch (Exception e) {
			flag=false;
		}finally
		{
			if(flag=true)
			{
				System.out.println("Value is selected");
			}else
			{
				System.out.println("value is not selected");
			}
		}
		return true;
		
	}
	
	public boolean selectByIndex(WebElement element,String Index)
	{
		boolean flag=false;
		try {
			Select s=new Select(element);
			s.selectByValue(Index);
			flag=true;
			
			
		} catch (Exception e) {
			flag=false;
		}finally
		{
			if(flag=true)
			{
				System.out.println("Index value is selected");
			}else
			{
				System.out.println("Index value is not selected");
			}
		}
		return true;
		
	}
	public String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = "C:\\Users\\2267344\\eclipse-workspace\\FrameworkPractice\\ScreenShots"+".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
				+ dateName + ".png";
		return newImageString;
	}
}
