package stepdefinations;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.page.ContactSales;
import com.page.HomePage;
import com.page.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactSalesSteps {

	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private HomePage homepage;
	private ContactSales contactsales;

	@Given("User navigates to Contact Sales page")
	public void user_navigates_to_contact_sales_page() throws InterruptedException {
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		homepage = loginpage.doLogin("Admin", "admin123");
		Thread.sleep(2000);
		homepage.clickAppLogo();
		Thread.sleep(2000);
		contactsales = homepage.goContactSalesPage();
	}

	@When("User fills the form using {string} and rownumber {int}")
	public void user_fills_the_form_using_and_rownumber(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> data = reader.getData("src/test/resources/testdata/DemoData.xlsx", sheetName);
		String name = data.get(rowNumber).get("name");
		String phone = data.get(rowNumber).get("phone");
		String mail = data.get(rowNumber).get("mail");
		String Country = data.get(rowNumber).get("Country");
		String job = data.get(rowNumber).get("job");
		String msg = data.get(rowNumber).get("msg");

		contactsales.fillContactSalesForm(name, phone, mail, Country, job, msg);
	}

	@When("User clicks on Im not robot")
	public void user_clicks_on_im_not_robot() {
		contactsales.clickNotRobotRadioButton();

	}

	@When("User clicks on Submit button")
	public void user_clicks_on_submit_button() throws InterruptedException {
		Thread.sleep(3000);
		contactsales.clickSubmitButton();
	}

	@Then("It shows {string} message to user")
	public void it_shows_message_to_user(String expectedSusscessMsg) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(expectedSusscessMsg, contactsales.getThankYouMessage());
		;
	}

}
