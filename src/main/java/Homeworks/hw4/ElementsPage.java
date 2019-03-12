package Homeworks.hw4;

import base.hw4.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import Homeworks.hw4.enums.Checkboxes;
import Homeworks.hw4.enums.Colors;
import Homeworks.hw4.enums.LogsMessages;
import Homeworks.hw4.enums.RadioButtons;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

public class ElementsPage extends BasePage {

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

    @FindBy(css = "select.uui-form-element")
    private SelenideElement colorsDropdown;

    @FindBy(css = ".logs")
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

    // TODO This method should be parametrized--FIXED
    public void clickOnCheckbox(Checkboxes checkboxes) {
        checkboxesList.get(checkboxes.indexOfCheckbox).click();
    }

    // TODO This method should be parametrized--REMADE TO ONE METHOD

    public void checkCheckboxesLogs(Checkboxes checkbox, Boolean status, LogsMessages logsMessages) {
        logsPanel.shouldHave(text(checkbox.value + logsMessages.text + status));
    }

    public void selectRadioButton(RadioButtons radioButtons) {

        radioButtonsList.get(radioButtons.index).click();
    }

    public void checkRadiosLogs(RadioButtons radioButton, LogsMessages logsMessages) {
        logsPanel.shouldHave(text(logsMessages.text + radioButton));
    }

    // TODO This method should be parametrized--FIXED
    public void selectColorInDropdown(Colors colors) {
        colorsDropdown.click();
        colorsDropdown.selectOption(colors.indexOfColor);
    }

    public void checkDropdownLogs(Colors colors) {
        logsPanel.shouldHave(text("Colors: value changed to " + colors.label));
    }
}