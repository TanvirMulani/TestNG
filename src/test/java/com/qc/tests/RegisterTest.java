package com.qc.tests;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RegisterTest extends BaseIntegration {
	
	@BeforeSuite
	public void dosetup() throws IOException {
		doSetup();
	}

	public void GoToRegisterPage() {
		PageTitle = driver.getTitle();
		if (PageTitle.equals("Queue Codes | Log in")) {
			rLink = driver.findElement(By.linkText("Register a new membership"));
			rLink.click();
		}
		
	}
	@BeforeMethod
	public void xpath() {
		GoToRegisterPage();
		rName = driver.findElement(By.id("name"));
		rName.clear();
		
		rMobile = driver.findElement(By.id("mobile"));
		rMobile.clear();
		
		rEmail = driver.findElement(By.id("email"));
		rEmail.clear();
		
		rPass = driver.findElement(By.id("password"));
		rPass.clear();
		
		rSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
	
		
	}
	
	@Test(dataProvider = "registerdata")
	public void doRegister(String testName, String uName, String uMobile, String uEmail, String uPass ) {
		tName = testName;
		rName.sendKeys(uName);
		rMobile.sendKeys(uMobile);
		rEmail.sendKeys(uEmail);
		rPass.sendKeys(uPass);
		rSubmit.click();	
	}
	
	@AfterMethod
	public void doAssert() throws InterruptedException {
		if (tName.equals("all fields are valid")) {
			Alert alt = driver.switchTo().alert();
		Assert.assertEquals(alt.getText(), "User registered successfully.");
		alt.accept();
		}
		Thread.sleep(2000);
	}
	@AfterSuite
	public void teardown() {
		driver.close();
}
}
