package com.Freecrm.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Freecrm.pages.Contactspage;
import com.Freecrm.pages.Loginpage;
import com.Freecrm.utils.Drivers;
import com.Freecrm.utils.TestUtils;
import com.Freecrm.utils.config;

public class Contactstest {
		
		WebDriver driver;
		Loginpage login;	
		Contactspage contacts;
		TestUtils utils;
		
		@BeforeClass
		public void initialization() {		
			driver = Drivers.startBroswer(config.browser, config.FreeCRM_URL);
			login = PageFactory.initElements(driver,Loginpage.class);
			contacts = PageFactory.initElements(driver, Contactspage.class);	
			utils = PageFactory.initElements(driver, TestUtils.class);
		}
		
		@Test(priority = 1)
		public void login() throws IOException, InterruptedException {
			login.login(config.adminUserName, config.adminPassword);		
		}
		
		@Test(priority = 2)
		public void validateUname() {
		contacts.verifyUsername();
		}
			
		@Test(priority = 3)
		public void createnewcontact() throws InterruptedException {
		contacts.addNewCOntact("Mr.", "Besant", "Technologies", "Selenium", "Friend", "New");	
		} 	
		
		@DataProvider
		public Object[][] cromtestData() throws Throwable {
		Object[][] arrayObject = utils.getTestData("Sheet1");
		return arrayObject;
		}
		
		@Test(priority = 4 , dataProvider ="cromtestData" )
		public void createcontact(String title , String fname, String Lname, String Nname, String cat, String status ) throws InterruptedException {

		contacts.addNewCOntact(title, fname, Lname, Nname, cat, status);
		}
		
		@AfterClass
		public void CloseBrowser() {
			driver.quit();
		}

}
