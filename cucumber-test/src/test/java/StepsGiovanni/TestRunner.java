package StepsGiovanni;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/GiovanniFeaturesFiles/U2RobotInteraction",
				publish = true,
				glue = {"StepsGiovanni"},
				plugin = {"pretty"}
				)

public class TestRunner {
	
}
