package stepdefinations;

import org.junit.Assert;

import com.page.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private static String title;
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());

	@Given("User is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver()
				.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginpage.getLoginPageTitle();
		System.out.println("Page title is: " + title);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertTrue(expectedTitleName.contains(title));
	}

	@Then("Forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(loginpage.isForgotPwdLinkExist());
	}

	@When("User enters username {string}")
	public void user_enters_username(String username) throws InterruptedException {
		Thread.sleep(3000);
		loginpage.enterUserName(username);
	}

	@When("User enters password {string}")
	public void user_enters_password(String password) {
		loginpage.enterPassword(password);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		loginpage.clickSignInButton();
	}

}
