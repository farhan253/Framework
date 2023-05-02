package com.framework.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.base.BaseClass;
import com.framework.dataprovider.DataProviders;
import com.framework.pageobjects.TC_01_LoginPage;
import com.framework.pageobjects.TC_04_CreateProject;

public class TC_04_CreateProjectPageTest extends BaseClass {

	TC_01_LoginPage login;
	TC_04_CreateProject project;
	
	@BeforeMethod(groups={"smoke"})
    public void launchBrowser()
		{
			BaseClass.invokeBrowser();
		}
   @AfterMethod(groups={"smoke"})
   public void CloseBrowser()
	    {
	    	BaseClass.closeBrowser();
	    }
   @Test(groups="smoke",priority=3,dataProvider = "myProject", dataProviderClass = DataProviders.class)
   public void createProjectTest(String projectname,String roomname)
   {
	   project=new TC_04_CreateProject();
	   project.createProjectPage(projectname, roomname);
   }
}
