package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import utilities.Driver;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-report.html", "json:target/report.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@google",
        dryRun = false
)

public class Runner {

    @AfterClass
    public static void flush(){
        Driver.quitDriver();
    }

}
