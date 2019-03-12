package Homeworks.hw5;

import base.hw5.BasePageJenkins;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import Homeworks.hw4.enums.Checkboxes;
import Homeworks.hw4.enums.Colors;
import Homeworks.hw4.enums.LogsMessages;
import Homeworks.hw4.enums.RadioButtons;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

public class ElementsPageJenkins extends BasePageJenkins {

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

    @Step
    public void checkDifferentPageElements() {
        checkboxesList.shouldHaveSize(4);
        radioButtonsList.shouldHaveSize(4);
        dropdownList.shouldHaveSize(1);
        buttonesList.shouldHaveSize(2);
    }

    @Step
    public void checkRightSection() {
        rightSection.isDisplayed();
    }

    @Step
    public void checkLeftSection() {
        leftSection.isDisplayed();
    }

    @Step
    public void clickOnCheckbox(Checkboxes checkboxes) {
        checkboxesList.get(checkboxes.indexOfCheckbox).click();
    }

    @Step
    public void checkCheckboxesLogs(Checkboxes checkbox, Boolean status, LogsMessages logsMessages) {
        logsPanel.shouldHave(text(checkbox.value + logsMessages.text + status));
    }

    @Step
    public void selectRadioButton(RadioButtons radioButtons) {

        radioButtonsList.get(radioButtons.index).click();
    }

    @Step
    public void checkRadiosLogs(RadioButtons radioButton, LogsMessages logsMessages) {
        logsPanel.shouldHave(text(logsMessages.text + radioButton));
    }

    @Step
    public void selectColorInDropdown(Colors colors) {
        colorsDropdown.click();
        colorsDropdown.selectOption(colors.indexOfColor);
    }

    @Step
    public void checkDropdownLogs(Colors colors) {
        logsPanel.shouldHave(text("Colors: value changed to " + colors.label));
    }
}