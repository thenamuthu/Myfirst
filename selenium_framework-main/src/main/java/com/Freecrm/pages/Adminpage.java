package com.Freecrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.Freecrm.utils.Drivers;
import com.Freecrm.utils.config;

public class Adminpage {
    
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
	 @FindBy(xpath = "//a[@title='Calendar']")
		WebElement calender;
		
		@FindBy(xpath = "//a[@title='New Event']")
		WebElement NewEvents;
		
		@FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
		WebElement Username1;	
		
		@FindBy(id = "title")
		WebElement calendertitle;
		
		 @FindBy(xpath="//select[@name='assigned_to_user_id_src']")
	     WebElement AssignedTo; 
	        
	     @FindBy(xpath="//input[@value='==ADD==>']")
	     WebElement Add;   
		
		@FindBy(xpath="//select[@name='category']")
		WebElement cate;
		

		@FindBy(xpath = "//input[@type='submit' and @value='Save' and @class='button']")	
		WebElement savebuton;
		
		@FindBy(name = "mainpanel")
		WebElement frame1;
		
		public void verifyUsername1() {
			
			Drivers.switchframe(frame1);
			
			String Uname = Drivers.waitForElementVisibility(Username1).getText();
			
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
	     @FindBy(xpath = "//a[@title='Companies']")
	 	WebElement companies;
	 	
	 	@FindBy(xpath = "//a[contains(text(),'New Company')]")
	 	WebElement NewCompany;
	 	
	 	@FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
	 	WebElement Username2;	
	 	
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
	 	WebElement savebutton1;
	 	
	 	@FindBy(name = "mainpanel")
	 	WebElement frame11;
	 	
	 	public void verifyUsername2() {
	 		
	 		Drivers.switchframe(frame1);
	 		
	 		String Uname = Drivers.waitForElementVisibility(Username2).getText();
	 		
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
	      @FindBy(xpath = "//a[contains(text(),'Contacts')]")
	  	WebElement contact;
	  	
	  	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	  	WebElement NewContact;
	  	
	  	@FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
	  	WebElement Username3;	
	  	
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
	  	WebElement frame2;
	  	
	  	public void verifyUsername3() {
	  		
	  		Drivers.switchframe(frame1);
	  		
	  		String Uname = Drivers.waitForElementVisibility(Username3).getText();
	  		
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

	  @FindBy(xpath = "//a[contains(text(),'Deals')]")
		WebElement deals;
		
		@FindBy(xpath = "//a[contains(text(),'New Deal')]")
		WebElement NewDeal;
		
		@FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
		WebElement Username4;	
		
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
		WebElement frame3;

	       public void verifyUsername4() {
			
			Drivers.switchframe(frame1);
			
			String Uname = Drivers.waitForElementVisibility(Username4).getText();
			
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
		@FindBy(xpath = "//a[@title='Tasks']")
		WebElement tasks;
		
		@FindBy(xpath = "//a[@title='New Task']")
		WebElement NewTask;
		
		@FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
		WebElement Username5;	
		
		@FindBy(id = "title")
		WebElement TaskTitle;
		
		@FindBy(xpath="//select[@name='task_type']")
		WebElement Tasktype;
		
		@FindBy(xpath = "//select[@name='priority']")
		WebElement TaskPriority;
		
		@FindBy(xpath = "//input[@type='submit' and @value='Save' and @class='button']")	
		WebElement savebutton;
		
		@FindBy(name = "mainpanel")
		WebElement frame5;

	       public void verifyUsername5() {
			
			Drivers.switchframe(frame5);
			
			String Uname = Drivers.waitForElementVisibility(Username5).getText();
			
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
