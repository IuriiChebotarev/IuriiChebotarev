package hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.Checkboxes;
import hw4.enums.Colors;
import hw4.enums.RadioButtons;
import org.openqa.selenium.support.FindBy;

public class ElementsPage {

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxesList;

    @FindBy(css = ".label-radio")
    private ElementsCollection radioButtonsList;

    @FindBy(css = "select.uui-form-element")
    private ElementsCollection dropdownList;

    @FindBy(css = "p")
    private ElementsCollection buttonesList;

    @FindBy(css = ".right-fix-panel")
    private SelenideElement rightSection;

    @FindBy(css = "#mCSB_1")
    private SelenideElement leftSection;

    @FindBy(css = ".label-checkbox:nth-child(1) > input[type=checkbox]")
    private SelenideElement waterCheckbox;

    @FindBy(css = ".label-checkbox:nth-child(3) > input[type=checkbox]")
    private SelenideElement windCheckbox;

    @FindBy(css = ".label-radio:nth-child(4)")
    private SelenideElement selenRadio;

    @FindBy(css = "select.uui-form-element")
    private SelenideElement colorsDropdown;

    @FindBy(css = ".panel-body-list.logs > li")
    private SelenideElement logsPanel;

    public void checkDifferentPageElements() {
        checkboxesList.shouldHaveSize(4);
        radioButtonsList.shouldHaveSize(4);
        dropdownList.shouldHaveSize(1);
        buttonesList.shouldHaveSize(2);
    }

    public void checkRightSection() {
        rightSection.isDisplayed();
    }

    public void checkLeftSection() {
        leftSection.isDisplayed();
    }

    // TODO This method should be parametrized
    public void clickOnWaterCheckbox() {
        waterCheckbox.click();
    }

    // TODO This method should be parametrized
    public void clickOnWindCheckbox() {
        windCheckbox.click();
    }

    public void checkCheckboxesLogs(Checkboxes checkbox, Boolean status) {
        logsPanel.shouldHave(Condition.text(checkbox.value + ": condition changed to " + status));
    }

    public void selectSelenRadio() {
        selenRadio.click();
    }

    public void checkRadiosLogs(RadioButtons radioButton) {
        logsPanel.shouldHave(Condition.text("metal: value changed to " + radioButton));
    }

    // TODO This method should be parametrized
    public void selectYellowInDropdown() {
        colorsDropdown.click();
        colorsDropdown.selectOption("Yellow");
    }

    public void checkDropdownLogs(Colors colors) {
        logsPanel.shouldHave(Condition.text("Colors: value changed to " + colors.label));
    }
}