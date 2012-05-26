package com.koolkart.pages;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.driver.DriverHandler;

public class FeedbackPage {

	private DriverHandler driver = new DriverHandler();

	/*
	 * Great to have you as a part of the Koolkart community ! Thanks for
	 * helping making it better.
	 */
	@Test
	public void submitFeedback_Test() {
		driver.page.findElement(By.id("contactable_inner")).click();
		driver.page.findElement(By.id("name")).sendKeys(
				"This is an auto-generated text as part of my test");
		driver.page
				.findElement(By.id("message"))
				.sendKeys(
						"Sample Feedback: This part of the application is not accesible.");
		// driver.findElement(By.className("submit")).submit();
	}

	@BeforeTest
	public void beforeTest() {
		driver.goToPage("index.htm");
	}

	@AfterTest
	public void afterTest() {
		driver.page.close();
	}

}
