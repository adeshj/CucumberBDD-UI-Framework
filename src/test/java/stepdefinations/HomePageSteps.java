package stepdefinations;

import java.util.List;
import java.util.Map;

import com.page.HomePage;
import com.page.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps {
	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage;
	
	@Given("User has logged in to the application")
	public void user_logged_in_to_the_application(DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> credList = dataTable.asMaps();
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		homePage = loginpage.doLogin(username, password);
	}

	@Then("User click on application logo")
	public void user_click_on_application_logo() throws InterruptedException {
		Thread.sleep(3000);
		homePage.clickAppLogo();
	}

	@Given("User is on homepage")
	public void user_is_on_homepage() {
		homePage.getHomePageTitle();

	}

}
