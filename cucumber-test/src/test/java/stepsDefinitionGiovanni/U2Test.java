package stepsDefinitionGiovanni;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FeatureFilesGiovanni/U2RobotInteraction",
				publish = true,
				glue = {"stepsDefinitionGiovanni"},
				plugin = {"pretty"}
				)

public class U2Test {
}
