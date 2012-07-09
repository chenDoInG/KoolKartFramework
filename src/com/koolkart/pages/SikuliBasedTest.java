package com.koolkart.pages;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.driver.DriverHandler;

public class SikuliBasedTest {
	private DriverHandler driver = new DriverHandler();

	Screen s;

	// This test requires an image to be placed in a certain location for successful run.
	
	@Test
	public void facebook_Login_Verification() throws InterruptedException {
		try {
			s.doubleClick("imgs/fbconnect.png", 0);
			s.type("xyz@abc.com");

		} catch (FindFailed e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	@BeforeTest
	public void beforeTest() {
		driver.goToHomePage();
		s = new Screen();
	}

	@AfterTest
	public void afterTest() {
		driver.page.close();
	}

}
