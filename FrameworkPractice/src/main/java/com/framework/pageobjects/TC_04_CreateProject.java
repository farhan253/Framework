package com.framework.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.actiondriver.Actions;
import com.framework.base.BaseClass;

public class TC_04_CreateProject extends BaseClass {

	Actions action=new Actions();
	
	@FindBy(xpath="//button[@class='btn account-btn']")
	private WebElement hover;
	
	@FindBy(xpath="//a[@title='My Projects']")
	private WebElement myProject;
	
	@FindBy(id="dwfrm_login_username")
	private WebElement enterEmail;
	
	@FindBy(id="dwfrm_login_password")
	private WebElement enterPassword;
	
	@FindBy(xpath="//button[@value='Sign In']")
	private WebElement clickOnSignIn;
	
	@FindBy(xpath="//h4[@class='myProjectsHeading py-3 ']")
	private WebElement clickOnMyProjects;
	
	@FindBy(xpath="//*[contains(text(),'Create a Project')]")
	private WebElement clickOnAddProject;
	
	@FindBy(xpath="//input[@id='dwfrm_projectmanager_projectName']")
	private WebElement enterProjectName;
	
	@FindBy(xpath="//div[@class='newRoomFields']//input[@id='dwfrm_projectmanager_roomName']")
	private WebElement enterRoomName;
	
	@FindBy(xpath="//button[@title='Create Project']")
	private WebElement clickOnCreateProjectButton;
	
	public TC_04_CreateProject()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createProjectPage(String projectname,String roomname)
	{
		action.moveToElement(driver, hover);
		action.clickWithJs(driver, myProject);
		
	    action.sendKeys(enterEmail, prop.getProperty("email"));
		action.sendKeys(enterPassword, prop.getProperty("password"));
		action.clickWithJs(driver, clickOnSignIn);
		
		action.clickWithJs(driver, clickOnMyProjects);
		action.explicitWaitClick(driver, clickOnAddProject);
		action.clickWithJs(driver, clickOnAddProject);
		
		action.sendKeys(enterProjectName, projectname);
		action.sendKeys(enterRoomName, roomname);
		action.clickWithJs(driver, clickOnCreateProjectButton);
		
		
		
	}
	
	
	
	
	
}
