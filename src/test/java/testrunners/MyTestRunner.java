package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/appFeatures/" },
		glue = { "stepdefinations", "appHooks" },
		plugin = {
				"pretty", 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/",
				"rerun:target/failedrerun.txt"
		},
//		tags = "not @Skip",
		monochrome = true
		)

public class MyTestRunner {

}
