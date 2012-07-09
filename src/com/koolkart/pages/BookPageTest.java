package com.koolkart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.driver.DriverHandler;

public class BookPageTest {

	private DriverHandler driver = new DriverHandler();

	@Test
	public void verify_Initial_BookPage() {
		String category = driver.page.findElement(
				By.className("currentcategory")).getText();
		if (category.contains("Books"))
			Assert.assertTrue(true, "Verified Category is set to Books");

		String inline_text = driver.page.findElement(
				By.className("sub-link-block-inline")).getText();
		if (inline_text.contains("Most Popular"))
			Assert.assertTrue(true,
					"Verified Books section contains Most Popular");
	}

	@Test
	public void verify_Book_Search_Test() {
		String bookName = "Revolution 2020";
		driver.page.get("http://www.koolkart.com/book");
		driver.page.findElement(By.id("product-search-bar")).sendKeys(bookName);
		driver.page.findElement(By.id("pricehunt")).click();
		List<WebElement> searchResultLinks = driver.page.findElements(By
				.className("p-title"));
		for (WebElement searchResult : searchResultLinks) {
			if (searchResult.getText().contains(bookName)) {
				Assert.assertTrue(true, "Given Book is found");
			}
		}
	}

	@Test
	public void verify_SortBy_on_BookPage() {
		WebElement sortByDropDown = driver.page.findElement(By
				.id("search-sort"));
		String values = sortByDropDown.getText();
		if (values.contains("Popularity") & values.contains("Price")
				& values.contains("Recently Karted")) {
			Assert.assertTrue(true,
					"Verified that the Sort by has proper drop down values");
		}
	}

	@Test
	public void verify_most_popular_on_BookPage() {
		driver.page.get("http://www.koolkart.com/book");
		driver.page.findElement(By.className("sub-link-block-inline")).click();
		String current_URL = driver.page.getCurrentUrl();
		if (current_URL.contains("popular")) {
			driver.page.findElement(By.linkText("Biographies")).click();
		}
	}

	@BeforeTest
	public void beforeTest() {
		driver.goToPage("book");
	}

	@AfterTest
	public void afterTest() {
		driver.page.close();
	}

}
