package stepdefinations;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.page.HomePage;
import com.page.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps {

	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage;

	@Given("User has logged in to the application")
	public void user_logged_in_to_the_application(DataTable credTable) throws InterruptedException {
		List<Map<String, String>> credList = credTable.asMaps();
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		homePage = loginpage.doLogin(username, password);
	}

	@Then("User click on application logo")
	public void user_click_on_application_logo() throws InterruptedException {
		Thread.sleep(2000);
		homePage.clickAppLogo();
	}

	@Given("User is on homepage")
	public void user_is_on_homepage() {
		homePage.getHomePageTitle();

	}

	@And("User gets homepage sections")
	public void user_gets_homepage_sections(DataTable sectionTable) {
		List<String> expectedSectionList = sectionTable.asList();
		System.out.println("Expected homepage section list ----> " + expectedSectionList);

		List<String> actualSectionList = homePage.getHomePageSectionList();
		System.out.println("Actual homepage section list ----> " + actualSectionList);

		Assert.assertTrue(expectedSectionList.containsAll(actualSectionList));
	}

	@Then("Homepage section count should be {int}")
	public void homepage_section_count_should_be(Integer count) {
		Assert.assertTrue(homePage.getHomepageSectionsCount() == count);
	}

}
