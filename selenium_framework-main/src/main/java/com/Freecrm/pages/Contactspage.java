package com.Freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.Freecrm.utils.Drivers;

public class Contactspage {
	

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contact;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement NewContact;
	
	@FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
	WebElement Username;	
	
	@FindBy(name = "title")
	WebElement contactTitle;
	
	@FindBy(name = "first_name")
	WebElement contactfname;
	
	@FindBy(name = "surname")
	WebElement contactlname;
	
	@FindBy(name = "category")
	WebElement contactcategory;
	
	@FindBy(name = "status")
	WebElement contactStatus;
	
	@FindBy(name = "nickname")
	WebElement contactNickname;
	
	@FindBy(xpath = "//input[@type='submit' and @value ='Save']")	
	WebElement savebtn;
	
	@FindBy(name = "mainpanel")
	WebElement frame;
	
	public void verifyUsername() {
		
		Drivers.switchframe(frame);
		
		String Uname = Drivers.waitForElementVisibility(Username).getText();
		
		System.out.println(Uname);
	}

public void addNewCOntact(String title, String fname, String Lname, String Nname, String   cat, String status) throws InterruptedException {
		
		Actions act = new Actions(Drivers.driver);
		
		act.moveToElement(contact).build().perform();
		
		Drivers.waitForElementVisibility(NewContact).click();	
		
		Select title1= new Select(Drivers.waitFor(contactTitle));
		
		title1.selectByVisibleText(title);
		
		Drivers.waitFor(contactfname).sendKeys(fname);
		
		Drivers.waitFor(contactlname).sendKeys(Lname);
		
		Drivers.waitFor(contactNickname).sendKeys(Nname);
		
		Select category= new Select(Drivers.waitFor(contactcategory));
		
		category.selectByVisibleText(cat);
		
		Select contstatus= new Select(Drivers.waitFor(contactStatus));
		
		contstatus.selectByVisibleText(status);	
		
		act.moveToElement(savebtn).build().perform();
		
		act.click(savebtn).build().perform();	
		
		}



}
