package com.Freecrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Freecrm.utils.Drivers;
import com.Freecrm.utils.config;



public class Loginpage {

@FindBy(name ="username")
WebElement uname;
	
@FindBy(name ="password")
WebElement password;	
	
@FindBy(xpath ="//input[@class='btn btn-small']")
WebElement submit;
	
@FindBy(xpath = "//a[@class='navbar-brand']//img[@class='img-responsive']")
WebElement logo;
	
public void validateURL() {
		
String current_URL = Drivers.driver.getCurrentUrl();
		
String expected_URL = config.FreeCRM_URL;
		
Assert.assertEquals(current_URL, expected_URL);		
}	

public void validateTitle() {
		
String title = Drivers.driver.getTitle();
		
System.out.println(title);
}	
	
public void login(String username , String pwd) throws IOException, InterruptedException {
		
Drivers.waitFor(uname).sendKeys(username);		
				
Drivers.waitFor(password).sendKeys(pwd);
		
Drivers.waitFor(submit).click();		
}
	
public void validateLogo() {
		
boolean CRMLogo = Drivers.waitForElementVisibility(logo).isDisplayed();

Assert.assertTrue(CRMLogo);  

}
}
