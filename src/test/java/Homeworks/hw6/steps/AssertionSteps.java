package Homeworks.hw6.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import Homeworks.hw6.ElementsPage;
import Homeworks.hw6.HomePage;
import Homeworks.hw6.UserTablePage;
import static Homeworks.hw3.pageObject.enums.TextsOfHeaders.MAIN_HEADER_TEXT;
import static Homeworks.hw3.pageObject.enums.TextsOfHeaders.MAIN_HEADER_TITLE;
import static Homeworks.hw6.enums.HeaderItems.getHeaderItemsList;
import static Homeworks.hw6.enums.Checkboxes.getCheckbox;
import static Homeworks.hw6.enums.Colors.getColor;
import static Homeworks.hw6.enums.HomePageData.getHomePage;
import static Homeworks.hw6.enums.LogsMessages.getLogMessage;
import static Homeworks.hw6.enums.RadioButtons.getRadiobutton;


public class AssertionSteps {

    // TODO Why is title hardcoded?--FIXED
    @Then("^Browser title is ([^\"]*)")
    public void checkBrowserTitle(String title) {

        new HomePage().checkTitle(getHomePage(title));
    }

    // TODO Why is user name hardcoded?--FIXED
    @Then("^User name is ([^\"]*)$")
    public void checkUserName(String username) {
       new HomePage().checkUserByUserName(username);
    }

    // TODO What does "all required elements" mean?--FIXED
    @Then("Page contains: 4 pictures, 4 texts under them, 2 texts above - headline and description$")
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

    @Then("Page contains right section")
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

    // TODO What does 'And' means? Do not use 'And'. Mark step definitions as 'Given', 'When' or 'Then'
    // TODO Why number is hardcoded?--FIXED
    @Then("^(.+) NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void numbertypeDropdownsAreDisplayedOnUsersTableOnUserTablePage(int amount) {
        new UserTablePage().checkAmountOfDropdowns(amount);
    }

    // TODO What does 'And' means? Do not use 'And'. Mark step definitions as 'Given', 'When' or 'Then'
    // TODO Why number is hardcoded?--FIXED
    @Then("^(.+)User names are displayed on Users Table on User Table Page$")
    public void userNamesAreDisplayedOnUsersTableOnUserTablePage(int amount) {

        new UserTablePage().checkAmountOfUsernames(amount);
    }

    // TODO What does 'And' means? Do not use 'And'. Mark step definitions as 'Given', 'When' or 'Then'
    // TODO Why number is hardcoded?--FIXED
    @Then("^(.+) Description images are displayed on Users Table on User Table Page$")
    public void descriptionImagesAreDisplayedOnUsersTableOnUserTablePage(int amount) {
        new UserTablePage().checkAmountOfUserImages(amount);
    }

    // TODO What does 'And' means? Do not use 'And'. Mark step definitions as 'Given', 'When' or 'Then'
    // TODO Why number is hardcoded?--FIXED
    @Then("^(.+) Description texts under images are displayed on Users Table on User Table Page$")
    public void descriptionTextsUnderImagesAreDisplayedOnUsersTableOnUserTablePage(int amount) {
        new UserTablePage().checkAmountOfUserDescriptions(amount);
    }

    // TODO What does 'And' means? Do not use 'And'. Mark step definitions as 'Given', 'When' or 'Then'
    // TODO Why number is hardcoded?--FIXED
    @Then("^(.+) checkboxes are displayed on Users Table on User Table Page$")
    public void checkboxesAreDisplayedOnUsersTableOnUserTablePage(int amount) {

        new UserTablePage().checkAmountOfCheckboxes(amount);
    }

    @Then("^User table contains following values:$")
    public void userTableContainsFollowingValues(DataTable usersTable) {
        new UserTablePage().checkUsersTable(usersTable);
    }

    @Then("^(.+) log row has '([^\"]*)''([^\"]*)' text in log section$")
    public void logRowHasTextInLogSection(int amount, String logMessage, String status)  {
        new UserTablePage().checkLogs(getLogMessage(logMessage), status, amount);
    }

    @Then("^droplist contains values$")
    public void droplistContainsValues(DataTable userRolesList) {
        new UserTablePage().checkUserRolesInDropdown(userRolesList.asList(String.class));
    }
}








