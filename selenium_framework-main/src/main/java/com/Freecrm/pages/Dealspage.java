package com.Freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.Freecrm.utils.Drivers;

public class Dealspage {
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement deals;
	
	@FindBy(xpath = "//a[contains(text(),'New Deal')]")
	WebElement NewDeal;
	
	@FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
	WebElement Username;	
	
	@FindBy(id = "title")
	WebElement DealsTitle;
	
	@FindBy(xpath="//input[@name='identifier']")
	WebElement Dealsidentifier;
	
	@FindBy(id = "product_id")
	WebElement Dealsproduct;
	
	
	@FindBy(name = "type")
	WebElement Dealstype;
	
	@FindBy(name = "source")
	WebElement Dealssource;
	
	@FindBy(xpath = "//input[@type='submit' and @value ='Save and Create Another']")	
	WebElement saveandcreate;
	
	@FindBy(name = "mainpanel")
	WebElement frame;

       public void verifyUsername() {
		
		Drivers.switchframe(frame);
		
		String Uname = Drivers.waitForElementVisibility(Username).getText();
		
		System.out.println(Uname);
	}

	public void addNewDeal(String title, String identifier , String product, String type, String source) throws InterruptedException {
		
		Actions act = new Actions(Drivers.driver);
		
		act.moveToElement(deals).build().perform();
		
		Drivers.waitForElementVisibility(NewDeal).click();
                 
        Drivers.waitFor(DealsTitle).sendKeys(title);
		
		Drivers.waitFor(Dealsidentifier).sendKeys(identifier);
                 
        Select product1 = new Select(Drivers.waitFor(Dealsproduct));
		
		product1.selectByVisibleText(product);

		Select type1= new Select(Drivers.waitFor(Dealstype));
		
		type1.selectByVisibleText(type);
		
        Select source1= new Select(Drivers.waitFor(Dealssource));
		
		source1.selectByVisibleText(source);
		
		act.moveToElement(saveandcreate).build().perform();
		
		act.click(saveandcreate).build().perform();	
		
		}

	
		
	}





