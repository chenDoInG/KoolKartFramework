package com.koolkart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.driver.DriverHandler;

public class HomePageTest {

	private DriverHandler driver = new DriverHandler();

	@BeforeTest
	public void beforeTest() {
		driver.goToHomePage();
	}

	// Verify Page has What's in section
	@Test
	public void verify_WhatsIn_section_in_HomePage() {
		String header_section = driver.page.findElement(
				By.className("whts-in-text")).getText();
		Assert.assertTrue(header_section.contains("Whats in"),
				"Verified Whats in section");
	}

	// Verify page has Gadget section
	@Test
	public void verify_Gadgets_Sections_in_HomePage() {
		List<WebElement> section_elem = driver.page.findElements(By
				.className("col-block-header"));
		for (WebElement section : section_elem) {
			if (section.getText().contains("Gadgets"))
				Assert.assertTrue(true,
						"Verified Gadgets tab is present in Whats in");
		}
	}

	@Test
	public void Verify_Best_Deal_inHome_Page() {
		if (driver.page.findElement(By.className("tp-deals-head")).getText()
				.contains("Best deal today"))
			Assert.assertTrue(true,
					"Verified Best Deal Section is present on Home Page");
	}

	@AfterTest
	public void afterTest() {
		driver.page.close();
	}

}
