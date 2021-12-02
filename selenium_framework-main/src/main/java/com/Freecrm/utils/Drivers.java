package com.Freecrm.utils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class Drivers  {

   

	public static WebDriver driver;

	public static WebDriverWait wait;

	public static WebDriver startBroswer(String browserName, String url) {

		switch (browserName) {

		case "firefox":

		System.setProperty("webdriver.gecko.driver",

		"C://Users//senth//eclipse-workspace//FrameworkSample//Drivers//geckodriver.exe");

		 driver = new FirefoxDriver();

		break;

		case "chrome":

		System.setProperty("webdriver.chrome.driver",

			"C://Users//senth//eclipse-workspace//FrameworkSample//Drivers//chromedriver.exe");

		driver = new ChromeDriver();

		break;

		case "edge":

		System.setProperty("webdriver.edge.driver",
		        "C://Users//senth//eclipse-workspace//FrameworkSample//Drivers//msedgedriver.exe");

		driver = new EdgeDriver();

		break;
		}
      
		driver.get(url);

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(config.Implicitly_wait,TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(config.Page_Load_TimeOut,TimeUnit.SECONDS);

		return driver;
	}
	
	public static WebElement waitFor(WebElement element) {

		wait = new WebDriverWait(driver, config.wait_for_element);
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(element));
		} 
		
		catch (TimeoutException ex) {
			return null;
		}

	}

	public static WebElement waitForElementVisibility(WebElement element) {

		wait = new WebDriverWait(driver, config.wait_for_element);
		try {
			return wait.until(ExpectedConditions.visibilityOf(element));
		} 
		catch (TimeoutException ex) {
			return null;
		}
	}
	
	public static void takesScreenshot(String file) throws IOException {
		
	TakesScreenshot scrShot =((TakesScreenshot)driver);
		
	File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);	
		
	String path = "C:/Users/senth/eclipse-workspace/FrameworkSample/Screenshots/" + file + ".jpg";
		
	File DestFile= new File(path);
		
	FileUtils.copyFile(SrcFile,DestFile);
	}
	

	public static void switchframe(WebElement element)
	{
		driver.switchTo().frame("mainpanel");
	}
}








