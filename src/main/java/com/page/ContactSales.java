package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactSales {
	
	private WebDriver driver;
	
	private By fullName = By.id("Form_getForm_FullName");
	private By phoneNumber = By.id("Form_getForm_Contact");
	private By email = By.id("Form_getForm_Email");
	private By country = By.id("Form_getForm_Country");
	private By jobTitle = By.id("Form_getForm_JobTitle");
	private By message = By.id("Form_getForm_Comment");
	private By radioButton = By.cssSelector("div.rc-anchor-center-item span div:nth-child(2)");
//	private By radioButton = By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]");
	private By submitButton = By.id("Form_getForm_action_submitForm");
	private By thankYouMessage = By.cssSelector("div.thank-page-info h1");
	
	public ContactSales(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fillContactSalesForm(String name, String phone, String mail,String Country, String job, String msg) {
		driver.findElement(fullName).sendKeys(name);
		driver.findElement(phoneNumber).sendKeys(phone);
		driver.findElement(email).sendKeys(mail);
		Select select = new Select(driver.findElement(country));
		select.selectByValue(Country);
		driver.findElement(jobTitle).sendKeys(job);
		driver.findElement(message).sendKeys(msg);
	}
	
	public void clickNotRobotRadioButton() {
//		driver.switchTo().frame("a-xf00pdivej2o");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(radioButton)).click();
//		driver.findElement(radioButton).click();
	}
	
	public void clickSubmitButton() {
		driver.findElement(submitButton).click();
	}

	public String getThankYouMessage() {
		return driver.findElement(thankYouMessage).getText();
	}
}
