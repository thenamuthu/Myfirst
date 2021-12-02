package com.Freecrm.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Freecrm.pages.Loginpage;
import com.Freecrm.pages.Taskpage;
import com.Freecrm.utils.Drivers;
import com.Freecrm.utils.TestUtils;
import com.Freecrm.utils.config;

public class Tasktest {
            
	WebDriver driver;
	Loginpage login;	
	Taskpage task;
	TestUtils utils;
	
	@BeforeClass
	public void initialization() {		
		driver = Drivers.startBroswer(config.browser, config.FreeCRM_URL);
		login = PageFactory.initElements(driver,Loginpage.class);
		task = PageFactory.initElements(driver, Taskpage.class);	
		utils = PageFactory.initElements(driver, TestUtils.class);
	}
	
	@Test(priority = 1)
	public void login() throws IOException, InterruptedException {
		login.login(config.adminUserName, config.adminPassword);		
	}
	
	@Test(priority = 2)
	public void validateUname() {
	task.verifyUsername();
	}
		
	@Test(priority = 3)
	public void createnewtask() throws InterruptedException {
	task.addNewtask("rajini","Email","High" );
	} 	
	
	@DataProvider
	public Object[][] cromtestData() throws Throwable {
	Object[][] arrayObject = utils.getTestData("Sheet5");
	return arrayObject;
	}
	
	@Test(priority = 4 , dataProvider ="cromtestData" )
	public void createtask(String title , String type,String priority ) throws InterruptedException {
    task.addNewtask(title, type,priority);
	}
	
	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}

}
