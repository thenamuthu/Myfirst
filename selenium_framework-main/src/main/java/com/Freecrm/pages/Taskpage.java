package com.Freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.Freecrm.utils.Drivers;

public class Taskpage {
             
	@FindBy(xpath = "//a[@title='Tasks']")
	WebElement tasks;
	
	@FindBy(xpath = "//a[@title='New Task']")
	WebElement NewTask;
	
	@FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
	WebElement Username;	
	
	@FindBy(id = "title")
	WebElement TaskTitle;
	
	@FindBy(xpath="//select[@name='task_type']")
	WebElement Tasktype;
	
	@FindBy(xpath = "//select[@name='priority']")
	WebElement TaskPriority;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save' and @class='button']")	
	WebElement savebutton;
	
	@FindBy(name = "mainpanel")
	WebElement frame;

       public void verifyUsername() {
		
		Drivers.switchframe(frame);
		
		String Uname = Drivers.waitForElementVisibility(Username).getText();
		
		System.out.println(Uname);
	}

	public void addNewtask(String title, String type , String priority) throws InterruptedException {
		
		Actions act = new Actions(Drivers.driver);
		
		act.moveToElement(tasks).build().perform();

                                     Drivers.waitForElementVisibility(NewTask).click();
                            
                                     Drivers.waitFor(TaskTitle).sendKeys(title);

                                     Select type1= new Select(Drivers.waitFor(Tasktype));
		
		                             type1.selectByVisibleText(type);

                                     Select priority1= new Select(Drivers.waitFor(TaskPriority));
		
		                             priority1.selectByVisibleText(priority);

                                       act.moveToElement(savebutton).build().perform();
		
		act.click(savebutton).build().perform();

                }

	
		
	}





