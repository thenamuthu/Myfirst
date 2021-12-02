package com.Freecrm.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Freecrm.pages.Loginpage;
import com.Freecrm.utils.Drivers;
import com.Freecrm.utils.config;

public class Logintest {
 
	
	WebDriver driver;
	Loginpage login;	
	
	@BeforeClass
	public void initialization() {
		
		driver = Drivers.startBroswer(config.browser, config.FreeCRM_URL);
		login = PageFactory.initElements(driver,Loginpage.class);
	}
	
	@Test(priority = 1)
	public void URL() throws IOException {
		login.validateURL();
		Drivers.takesScreenshot("BeforeLogin");
		
	}

	@Test(priority = 2)
	public void Title() {
		login.validateTitle();
	}
	
	@Test(priority = 3)
	public void Logo() {
		login.validateLogo();
	}	
	
	@Test(priority = 4)
	public void login() throws IOException, InterruptedException {
		login.login(config.adminUserName, config.adminPassword);
		Drivers.takesScreenshot("AfterLogin");
	}
	 
	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}
	

}
