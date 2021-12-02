package com.Freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.Freecrm.utils.Drivers;

public class Companiespage {


	@FindBy(xpath = "//a[@title='Companies']")
	WebElement companies;
	
	@FindBy(xpath = "//a[contains(text(),'New Company')]")
	WebElement NewCompany;
	
	@FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
	WebElement Username;	
	
	@FindBy(id = "company_name")
	WebElement companyname;
	
	@FindBy(xpath="//input[@name='industry']")
	WebElement companyindustry;
	
	@FindBy(name = "status")
	WebElement companystatus;
	
	
	@FindBy(name = "category")
	WebElement companycategory;
        
    @FindBy(name = "priority")
	WebElement companypriority;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save' and @class='button']")	
	WebElement savebutton;
	
	@FindBy(name = "mainpanel")
	WebElement frame;
	
	public void verifyUsername() {
		
		Drivers.switchframe(frame);
		
		String Uname = Drivers.waitForElementVisibility(Username).getText();
		
		System.out.println(Uname);
	}

     public void addNewcompany(String company, String industry, String status, String category, String priority) throws InterruptedException {
		
		Actions act = new Actions(Drivers.driver);
		
		act.moveToElement(companies).build().perform();
		
		Drivers.waitForElementVisibility(NewCompany).click();


        Drivers.waitFor(companyname).sendKeys(company);

        Drivers.waitFor(companyindustry).sendKeys(industry);

        Select status1= new Select(Drivers.waitFor(companystatus));
		
		status1.selectByVisibleText(status);
               
        Select category1= new Select(Drivers.waitFor(companycategory));
		
		category1.selectByVisibleText(category);

        Select priority1= new Select(Drivers.waitFor(companypriority));
		
		priority1.selectByVisibleText(priority);
        
        act.moveToElement(savebutton).build().perform();
		
		act.click(savebutton).build().perform();

                }	
}

