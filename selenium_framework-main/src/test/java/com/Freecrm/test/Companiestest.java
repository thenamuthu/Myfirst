package com.Freecrm.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Freecrm.pages.Companiespage;
import com.Freecrm.pages.Loginpage;
import com.Freecrm.utils.Drivers;
import com.Freecrm.utils.TestUtils;
import com.Freecrm.utils.config;

public class Companiestest {
              
	WebDriver driver;
	Loginpage login;	
	Companiespage companies;
	TestUtils utils;
	
	@BeforeClass
	public void initialization() {		
		driver = Drivers.startBroswer(config.browser, config.FreeCRM_URL);
		login = PageFactory.initElements(driver,Loginpage.class);
		companies = PageFactory.initElements(driver, Companiespage.class);	
		utils = PageFactory.initElements(driver, TestUtils.class);
	}
	
	@Test(priority = 1)
	public void login() throws IOException, InterruptedException {
		login.login(config.adminUserName, config.adminPassword);		
	}
	
	@Test(priority = 2)
	public void validateUname() {
	companies.verifyUsername();
	}
		
	@Test(priority = 3)
	public void createnewcontact() throws InterruptedException {
	companies.addNewcompany("abcd", "chemical", "Active", "Client", "Low");	
	} 	
	
	@DataProvider
	public Object[][] cromtestData() throws Throwable {
	Object[][] arrayObject = utils.getTestData("Sheet3");
	return arrayObject;
	}
	
	@Test(priority = 4 , dataProvider ="cromtestData" )
	public void createcompanies(String company , String industry, String status, String category, String priority ) throws InterruptedException {
    companies.addNewcompany(company, industry, status, category, priority);
	}
	
	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}

}


