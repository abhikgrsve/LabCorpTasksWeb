package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@io.cucumber.junit.CucumberOptions(
    features = "src/test/resources/Features/BrowseLabcorpCareers.feature",
    glue = "steps",
    plugin = {"pretty", "html:target/cucumber-reports"}
)

public class TestRunner {

}
