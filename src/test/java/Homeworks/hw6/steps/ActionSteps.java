package Homeworks.hw6.steps;

import cucumber.api.java.en.When;
import hw6.ElementsPage;
import hw6.HomePage;
import static hw6.enums.Checkboxes.getCheckbox;
import static hw6.enums.Colors.getColor;
import static hw6.enums.RadioButtons.getRadiobutton;
import static hw6.enums.ServiceDropDown.getServiceDropdownItem;
import static hw6.enums.Users.*;

public class ActionSteps {

    @When("^I login as user '([^\"]*)' with password '([^\"]*)'$")
    public void iLoginAsUser(String login, String password) {
        new HomePage().login(getLogin(login),getPassword(password));
    }

    @When("^I click on \"Service\" subcategory in the header$")
    public void iClickOnServiceDropDown() {
        new HomePage().clickOnServiceDropdownInHeader();
    }

    @When("^I click on \"Service\" subcategory in the left menu$")
    public void iClickOnSubcategoryInTheLeftMenu() {
        new HomePage().clickOnServiceDropdownInLeftMenu();
    }

    @When("^I open '([^\"]*)' page through \"Service\" drop-down list in header$")
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



}
