package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;

	private By logo = By.cssSelector("div.oxd-brand-banner");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAppLogo() {
		driver.findElement(logo).click();
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}

}
