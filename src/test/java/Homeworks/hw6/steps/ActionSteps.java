package Homeworks.hw6.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import hw6.ElementsPage;
import hw6.HomePage;
import hw6.UserTablePage;
import hw6.enums.UsersInTable;

import static hw6.enums.Checkboxes.getCheckbox;
import static hw6.enums.Colors.getColor;
import static hw6.enums.RadioButtons.getRadiobutton;
import static hw6.enums.ServiceDropDown.getServiceDropdownItem;
import static hw6.enums.Users.*;

public class ActionSteps {

    @When("^I login with login '([^\"]*)' and password '([^\"]*)'$")
    public void iLoginAsUser(String login, String password) {
        new HomePage().login(getLogin(login),(getPassword(password)));
    }

    @When("^I click on \"Service\" button in Header$")
    public void iClickOnServiceDropDown() {
        new HomePage().clickOnServiceDropdownInHeader();
    }

    @When("^I click on \"Service\" subcategory in the left menu$")
    public void iClickOnSubcategoryInTheLeftMenu() {
        new HomePage().clickOnServiceDropdownInLeftMenu();
    }

    @And("^I open '([^\"]*)' page from 'Service' dropdown$")
    public void iOpenPageThroughDropDownListInHeader(String item) {
        new HomePage().selectPageInServiceDropdown(getServiceDropdownItem(item));
    }

    @When("I click on checkbox: '([^\"]*)'$")
    public void iSelectCheckbox(String checkbox) {
        new ElementsPage().clickOnCheckbox(getCheckbox(checkbox));
    }

    @When("^I select '([^\"]*)' radiobutton$")
    public void iSelectRadiobutton(String radiobuttonName) {
        new ElementsPage().selectRadioButton(getRadiobutton(radiobuttonName));
    }

    @When("^I select '([^\"]*)' in drop-down list$")
    public void iSelectInDropDownList(String color) {
        new ElementsPage().selectColorInDropdown(getColor(color));
    }

    @And("^I login as user \"Piter Chailovskii\"$")
    public void iLoginAsPiterChailovskii() {
        new HomePage().loginAs(PETER);
    }

    @When("^I select 'vip' checkbox for '([^\"]*)'$")
    public void iSelectVipCheckboxForUser(String user) {
        new UserTablePage().selectCheckbox(UsersInTable.getUserInTable(user));
    }

    @When("^I click on dropdown in column Type for user '([^\"]*)'$")
    public void iClickOnDropdownInColumnTypeForUserRoman(String user) {
        new UserTablePage().openDropdownList(UsersInTable.getUserInTable(user));
    }





}
