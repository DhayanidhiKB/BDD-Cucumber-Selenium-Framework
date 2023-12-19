package testRunner;




import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions
        (
                features=".//feature/Login.feature",
                glue="stepDefinitions",
                dryRun = false,
                monochrome = true,
                plugin = {"html:target/cucumber.html"}

        )
public class TestRunner {

}