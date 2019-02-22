package Homeworks.hw6.steps;

import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;
import static hw6.enums.HomePageData.HOME_PAGE_DATA;

public class NavigationSteps {
    //1
    @Given("^I am on \"Home Page\"$")
    public void iOpenHomePage() {
        open(HOME_PAGE_DATA.url);

    }
}
