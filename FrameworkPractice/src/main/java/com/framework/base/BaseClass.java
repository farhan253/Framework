package com.framework.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.framework.utilities.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static  Properties prop;
	
	public BaseClass()
	{
		
		try {
			
			
			FileInputStream fi=new FileInputStream("C:\\Users\\2267344\\eclipse-workspace\\FrameworkPractice\\configurations\\config.properties");
             prop=new Properties();
			prop.load(fi);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	@BeforeSuite(groups= {"smoke"})
	public void beforeSuite()
	{
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
	}
	@AfterSuite(groups= {"smoke"})
	public void afterSuite()
	{
		ExtentManager.endReport();
	}
	public static void invokeBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	public static void closeBrowser()
	{
		driver.close();
	}

}
