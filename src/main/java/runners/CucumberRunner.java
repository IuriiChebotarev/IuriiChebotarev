package runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.close;

@CucumberOptions(features = "classpath:hw6", glue = "classpath:Homeworks.hw6.steps")

public class CucumberRunner extends AbstractTestNGCucumberTests {

    @BeforeMethod()
    public void driverSetUp() {
        Configuration.startMaximized = true;

    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

}
