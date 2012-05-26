package com.framework.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverHandler {
	public WebDriver page;

	public DriverHandler() {
		page = new FirefoxDriver();
	}
	
	public WebDriver goToHomePage()
	{
		page.navigate().to("http://www.koolkart.com");
		return page;
	}
	
	public WebDriver goToPage(String pageName)
	{
		page.navigate().to("http://www.koolkart.com"+ "/" +pageName);
		return page;
	}
	
	public WebDriver waitFor(String element_Id) throws InterruptedException
	{
		while (page.findElement(By.id(element_Id)).isDisplayed()) {
			Thread.sleep(3000);
		}
		return page;
	}
}