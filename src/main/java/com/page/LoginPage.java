package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	private By email = By.name("username");
	private By password = By.name("password");
	private By loginButton = By.cssSelector("button.oxd-button");
	private By forgotPwdLink = By.cssSelector("p.orangehrm-login-forgot-header");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public void enterUserName(String username) {
		driver.findElement(email).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickSignInButton() {
		driver.findElement(loginButton).click();
	}

	public HomePage doLogin(String username, String pwd) {
		System.out.println("Login with username: " + username + " & password: " + pwd);
		driver.findElement(email).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		return new HomePage(driver);
	}

}
