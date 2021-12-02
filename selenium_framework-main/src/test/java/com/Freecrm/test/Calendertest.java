package com.Freecrm.test;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Freecrm.pages.Calenderpage;
import com.Freecrm.pages.Loginpage;
import com.Freecrm.utils.Drivers;
import com.Freecrm.utils.TestUtils;
import com.Freecrm.utils.config;

public class Calendertest {
	
	WebDriver driver;
	Loginpage login;	
	Calenderpage calender;
	TestUtils utils;
	
	@BeforeClass
	public void initialization() {		
		driver = Drivers.startBroswer(config.browser, config.FreeCRM_URL);
		login = PageFactory.initElements(driver,Loginpage.class);
		calender = PageFactory.initElements(driver, Calenderpage.class);	
		utils = PageFactory.initElements(driver, TestUtils.class);
	}
	
	@Test(priority = 1)
	public void login() throws IOException, InterruptedException {
		login.login(config.adminUserName, config.adminPassword);		
	}
	
	@Test(priority = 2)
	public void validateUname() {
	calender.verifyUsername();
	}
		
	@Test(priority = 3)
	public void createnewcalender() throws InterruptedException {
	calender.addNewcalender("xyz","Critical" );
	} 	
	
	@DataProvider
	public Object[][] cromtestData() throws Throwable {
	Object[][] arrayObject = utils.getTestData("Sheet4");
	return arrayObject;
	}
	
	@Test(priority = 4 , dataProvider ="cromtestData" )
	public void createcalender(String title , String category ) throws InterruptedException {
    calender.addNewcalender(title, category);
	}
	
	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}


}
