package com.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;

	private By logo = By.cssSelector("div.oxd-brand-banner");
	private By homepage_sections = By.cssSelector("div.collapse ul li a.nav-link-hed");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAppLogo() {
		driver.findElement(logo).click();
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public int getHomepageSectionsCount() {
		return driver.findElements(homepage_sections).size();
	}

	public List<String> getHomePageSectionList() {
		List<String> accSecList = new ArrayList<>();
		List<WebElement> homepageSectionList = driver.findElements(homepage_sections);
		for (WebElement list : homepageSectionList) {
			System.out.println(list.getText());
			accSecList.add(list.getText());
		}
		return accSecList;
	}

}
