package com.Freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.Freecrm.utils.Drivers;

public class Calenderpage {
           
	    @FindBy(xpath = "//a[@title='Calendar']")
		WebElement calender;
		
		@FindBy(xpath = "//a[@title='New Event']")
		WebElement NewEvents;
		
		@FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
		WebElement Username;	
		
		@FindBy(id = "title")
		WebElement calendertitle;
		
		 @FindBy(xpath="//select[@name='assigned_to_user_id_src']")
	     WebElement AssignedTo; 
	        
	     @FindBy(xpath="//input[@value='==ADD==>']")
	     WebElement Add;   
		
		@FindBy(xpath="//select[@name='category']")
		WebElement cate;
		

		@FindBy(xpath = "//input[@type='submit' and @value='Save' and @class='button']")	
		WebElement savebutton;
		
		@FindBy(name = "mainpanel")
		WebElement frame;
		
		public void verifyUsername() {
			
			Drivers.switchframe(frame);
			
			String Uname = Drivers.waitForElementVisibility(Username).getText();
			
			System.out.println(Uname);
		}

	     public void addNewcalender(String title, String category) throws InterruptedException {
			
			Actions act = new Actions(Drivers.driver);
			
			act.moveToElement(calender).build().perform();
			
			Drivers.waitForElementVisibility(NewEvents).click();


	        Drivers.waitFor(calendertitle).sendKeys(title);
	        
	        Actions act1 = new Actions(Drivers.driver);
	        
            act1.moveToElement(AssignedTo).build().perform();
     
            Drivers.waitForElementVisibility(Add).click();

	        Select cate1= new Select(Drivers.waitFor(cate));
			
			cate1.selectByVisibleText(category);
	               

	        
	        act1.moveToElement(savebutton).build().perform();
			
			act1.click(savebutton).build().perform();

	                }	
}
