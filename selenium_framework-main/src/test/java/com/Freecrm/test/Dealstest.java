package com.Freecrm.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Freecrm.pages.Dealspage;
import com.Freecrm.pages.Loginpage;
import com.Freecrm.utils.Drivers;
import com.Freecrm.utils.TestUtils;
import com.Freecrm.utils.config;

public class Dealstest {
            
	WebDriver driver;
	Loginpage login;	
	TestUtils utils;
	Dealspage deals;
	
	@BeforeClass
	public void initialization() {		
		driver = Drivers.startBroswer(config.browser, config.FreeCRM_URL);
		login = PageFactory.initElements(driver,Loginpage.class);
		deals = PageFactory.initElements(driver, Dealspage.class);	
		utils = PageFactory.initElements(driver, TestUtils.class);
	}
	
	@Test(priority = 1)
	public void login() throws IOException, InterruptedException {
		login.login(config.adminUserName, config.adminPassword);		
	}
	
	@Test(priority = 2)
	public void validateUname() {
	deals.verifyUsername();
	}
	
	@Test(priority = 3)
	public void createNewDeal() throws InterruptedException {
	deals.addNewDeal( "electronics", "blackfridayDeals","DellLaptop",  "New", "Existing Customer");
	} 	
     
	@DataProvider
	public Object[][] cromtestData() throws Throwable {
	Object[][] arrayObject = utils.getTestData("Sheet2");
	return arrayObject;
	}
	
	@Test(priority = 4 , dataProvider ="cromtestData" )
	public void createNewDeal(String title, String identifier , String product, String type, String source ) throws InterruptedException {

	deals.addNewDeal(title, identifier, product, type,source );
	}
	
	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}


}
