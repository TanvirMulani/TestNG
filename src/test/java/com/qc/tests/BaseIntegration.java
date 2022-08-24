package com.qc.tests;

import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.qc.utils.TestUtils;

public class BaseIntegration {
	
	
	
	Properties prop;
	TestUtils test = new TestUtils();
	WebDriver driver;
	WebElement email, pass, submit, logout;
	WebElement rName, rMobile, rEmail, rPass, rSubmit, rLink;
	String tName;
	String PageTitle;
	
	
	public void doSetup() throws IOException {
		prop = test.readProp();
		if (prop.getProperty("browser").equals("chrome")) {
			System.setProperty(prop.getProperty("chromeKey"), prop.getProperty("chromeVal"));
			 driver = new ChromeDriver();
			driver.manage().window().maximize();	
			
		}
		driver.get(prop.getProperty("siteurl"));
		}
	
	@DataProvider
 	public Object[][] logindata() throws IOException{
 		return test.readData("LoginSheet");
		}

	@DataProvider
 	public Object[][] registerdata() throws IOException{
 		return test.readData("RegisterSheet");
		}
	
}