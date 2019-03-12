package Homeworks.hw6.steps;

import cucumber.api.java.en.When;
import Homeworks.hw6.ElementsPage;
import Homeworks.hw6.HomePage;
import Homeworks.hw6.UserTablePage;
import Homeworks.hw6.enums.UsersInTable;
import static Homeworks.hw6.enums.Checkboxes.getCheckbox;
import static Homeworks.hw6.enums.Colors.getColor;
import static Homeworks.hw6.enums.HeaderItems.getNavigationItem;
import static Homeworks.hw6.enums.ItemsInLeftMenu.getItemInLeftMenu;
import static Homeworks.hw6.enums.RadioButtons.getRadiobutton;
import static Homeworks.hw6.enums.ServiceDropDown.getServiceDropdownItem;
import static Homeworks.hw6.enums.Users.*;

public class ActionSteps {

    // TODO Why do you decide send pair username and password instead of enum user?--FIXED
    @When("^I login as user ([^\"]*)$")
    public void iLoginAsUser(String users) {
        new HomePage().login(getUserName(users));
    }

    // TODO Why is menu item hardcoded?--FIXED
    @When("^I click on ([^\"]*) button in Header$")
    public void iClickOnServiceDropDown(String navigationItem) {

        new HomePage().clickOnItemInHeader(getNavigationItem(navigationItem));
    }

    // TODO Why is "Service" hardcoded?--FIXED
    @When("^I click on ([^\"]*) subcategory in the left menu$")
    public void iClickOnSubcategoryInTheLeftMenu(String itemInLeftMenu) {
        new HomePage().clickOnItemInLeftMenu(getItemInLeftMenu(itemInLeftMenu));
    }

    @When("^I open ([^\"]*) page from 'Service' dropdown$")
    public void iOpenPageThroughDropDownListInHeader(String item) {
        new HomePage().selectPageInServiceDropdown(getServiceDropdownItem(item));
    }

    @When("I click on checkbox: ([^\"]*)$")
    public void iSelectCheckbox(String checkbox) {
        new ElementsPage().clickOnCheckbox(getCheckbox(checkbox));
    }

    @When("^I select ([^\"]*) radiobutton$")
    public void iSelectRadiobutton(String radiobuttonName) {
        new ElementsPage().selectRadioButton(getRadiobutton(radiobuttonName));
    }

    @When("^I select ([^\"]*) in drop-down list$")
    public void iSelectInDropDownList(String color) {
        new ElementsPage().selectColorInDropdown(getColor(color));
    }

    // TODO What does 'And' means? Do not use 'And'. Mark step definitions as 'Given', 'When' or 'Then'
    // TODO Why user name is hardcoded?--FIXED
    @When("^I select 'vip' checkbox for ([^\"]*)$")
    public void iSelectVipCheckboxForUser(String user) {
        new UserTablePage().selectCheckbox(UsersInTable.getUserInTable(user));
    }

    @When("^I click on dropdown in column Type for user ([^\"]*)$")
    public void iClickOnDropdownInColumnTypeForUserRoman(String user) {
        new UserTablePage().openDropdownList(UsersInTable.getUserInTable(user));
    }





}
