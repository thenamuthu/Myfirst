package com.Freecrm.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Freecrm.pages.Calenderpage;
import com.Freecrm.pages.Companiespage;
import com.Freecrm.pages.Contactspage;
import com.Freecrm.pages.Dealspage;
import com.Freecrm.pages.Loginpage;
import com.Freecrm.pages.Taskpage;
import com.Freecrm.utils.Drivers;
import com.Freecrm.utils.TestUtils;
import com.Freecrm.utils.config;

public class Admintest {

	WebDriver driver;
	Loginpage login;
	Companiespage companies;
	Taskpage task;
	Calenderpage calender;
	Contactspage contacts;
	Dealspage deals;
	TestUtils utils;
	
	@BeforeClass
	public void initialization() {		
		driver = Drivers.startBroswer(config.browser, config.FreeCRM_URL);
		login = PageFactory.initElements(driver,Loginpage.class);
		task = PageFactory.initElements(driver, Taskpage.class);
		contacts = PageFactory.initElements(driver, Contactspage.class);
		deals = PageFactory.initElements(driver, Dealspage.class);
		calender = PageFactory.initElements(driver, Calenderpage.class);
		companies = PageFactory.initElements(driver, Companiespage.class);
		utils = PageFactory.initElements(driver, TestUtils.class);
		
		calender = PageFactory.initElements(driver, Calenderpage.class);
	}
	
	@Test(priority = 1)
	public void login() throws IOException, InterruptedException {
		login.login(config.adminUserName, config.adminPassword);		
	}
	
	@Test(priority = 2)
	public void validateUname() {
	task.verifyUsername();
	}
	
	@DataProvider
	public Object[][] cromtestData2() throws Throwable {
	Object[][] arrayObject = utils.getTestData("Sheet5");
	return arrayObject;
	}
	
	@Test(priority = 4 , dataProvider ="cromtestData2" )
	public void createtask(String title , String type,String priority ) throws InterruptedException {
    task.addNewtask(title, type,priority);
	}
	
	@DataProvider
	public Object[][] cromtestData1() throws Throwable {
	Object[][] arrayObject = utils.getTestData("Sheet4");
	return arrayObject;
	}
	
	@Test(priority = 4 , dataProvider ="cromtestData1" )
	public void createcalender(String title , String category ) throws InterruptedException {
    calender.addNewcalender(title, category);
	}
	
	@DataProvider
	public Object[][] cromtestData3() throws Throwable {
	Object[][] arrayObject = utils.getTestData("Sheet3");
	return arrayObject;
	}
	
	@Test(priority = 4 , dataProvider ="cromtestData3" )
	public void createcompanies(String company , String industry, String status, String category, String priority ) throws InterruptedException {
    companies.addNewcompany(company, industry, status, category, priority);
	}
	
	@DataProvider
	public Object[][] cromtestData4() throws Throwable {
	Object[][] arrayObject = utils.getTestData("Sheet1");
	return arrayObject;
	}
	
	@Test(priority = 4 , dataProvider ="cromtestData4" )
	public void createcontact(String title , String fname, String Lname, String Nname, String cat, String status ) throws InterruptedException {

	contacts.addNewCOntact(title, fname, Lname, Nname, cat, status);
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
