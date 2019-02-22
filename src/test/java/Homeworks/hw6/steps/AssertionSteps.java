package Homeworks.hw6.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import hw6.ElementsPage;
import hw6.HomePage;
import static hw3.pageObject.enums.ItemsWithTexts.getHeaderItemsList;
import static hw3.pageObject.enums.TextsOfHeaders.MAIN_HEADER_TEXT;
import static hw3.pageObject.enums.TextsOfHeaders.MAIN_HEADER_TITLE;
import static hw6.enums.Checkboxes.getCheckbox;
import static hw6.enums.Colors.getColor;
import static hw6.enums.HomePageData.HOME_PAGE_DATA;
import static hw6.enums.LogsMessages.getLogMessage;
import static hw6.enums.RadioButtons.getRadiobutton;
import static hw6.enums.Users.PETER;

public class AssertionSteps {

    @Then("^Browser title is \"Home Page\"$")
    public void checkBrowserTitle() {
       new HomePage().checkTitle(HOME_PAGE_DATA);
    }

    @Then("^User name is \"PITER CHAILOVSKII\"$")
    public void checkUserName() {
       new HomePage().checkUsername(PETER);
    }

    @And("Page contains all required elements")
    public void checkRequiredElementsOnPage(){
        new HomePage().checkItems(getHeaderItemsList());
        new HomePage().checkImages();
        new HomePage().checkMainHeaderTitle(MAIN_HEADER_TITLE);
        new HomePage().checkMainHeaderText(MAIN_HEADER_TEXT);
    }

    @Then("Service drop-down list in header contains options:")
    public void serviceDropDownListContainsOptions(DataTable headerItems) {
        new HomePage().checkServiceDropdownListInHeader(headerItems.asList(String.class));
    }

    @Then("Service drop-down list in left menu contains options:")
    public void serviceDropDownListInLeftMenuContainsOptions(DataTable leftmenuItems) {
        new HomePage().checkServiceDropdownListInLeftMenu(leftmenuItems.asList(String.class));
    }

    @Then("Page contains left section")
    public void pageContainsLeftSection() {
        new ElementsPage().checkServiceDropdownListInLeftMenu(getHeaderItemsList());
    }

    @And("Page contains right section")
    public void pageContainsRightSection() {
        new ElementsPage().checkRightSection();
    }

    @Then("^Corresponding log appears according to selected checkbox: '([^\"]*)''([^\"]*)''([^\"]*)'$")
    public void correspondingLogAppearsAccordingToSelectedCheckboxes(String checkbox, String logMessage, String status) {
        new ElementsPage().checkCheckboxesLogs(getCheckbox(checkbox), status, getLogMessage(logMessage));
    }

    @Then("^Corresponding log appears according to selected radiobutton: '([^\"]*)''([^\"]*)'$")
    public void correspondingLogAppearsAccordingToSelectedRadiobutton(String logMessage, String radiobutton) {
        new ElementsPage().checkRadiosLogs(getRadiobutton(radiobutton), getLogMessage(logMessage));
    }

    @Then("^Corresponding log appears according to selected option in drop-down list: '([^\"]*)''([^\"]*)'$")
    public void correspondingLogAppearsAccordingToSelectedOptionInDropDownList(String logMessage, String color) {
        new ElementsPage().checkDropdownLogs(getColor(color), getLogMessage(logMessage));
    }

    @Then("^'([^\"]*)\' page is opened$")
    public void pageIsOpened(String title) {
        new HomePage().checkTitleOfPage(title);
    }



}

