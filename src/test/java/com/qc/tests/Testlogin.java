package com.qc.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Testlogin extends BaseIntegration {
	
	@BeforeSuite
	public void dosetup() throws IOException {
		doSetup();
	}
	
	@BeforeMethod
	public void locator() {
		email = driver.findElement(By.id("email"));
		email.clear();
		pass = driver.findElement(By.id("password"));
		pass.clear();
		submit = driver.findElement(By.id("submit"));
	}
	
	@Test(dataProvider = "logindata")
	public void dologin(String testName, String uName, String uPass) {
		tName = testName;
		email.sendKeys(uName);
		pass.sendKeys(uPass);
		submit.click();
	}
	
	@AfterMethod
	  public void verifyresult() throws InterruptedException { 
		Thread.sleep(2000);
		String actualresult = driver.getTitle();
		if (tName.equals("Both are Valid")) {
			Assert.assertEquals(actualresult, "Queue Codes | Dashboard");
			
			dologout();
			
		}else {
			Assert.assertEquals(actualresult, "Queue Codes | Log in");
		}
	}
	
	 public void dologout() {
			logout = driver.findElement(By.id("hlogout"));
			logout.click();
		}
	 @AfterSuite
		public void teardown() {
			driver.close();
	}
}
