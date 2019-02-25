package hw6;

import base.hw6.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw6.enums.Checkboxes;
import hw6.enums.Colors;
import hw6.enums.LogsMessages;
import hw6.enums.RadioButtons;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

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

    public ElementsPage() {page(this);}

    public void checkRightSection() {
        rightSection.isDisplayed();
    }

    public void clickOnCheckbox(Checkboxes checkboxes) {
        checkboxesList.get(checkboxes.indexOfCheckbox).click();
    }

    public void checkCheckboxesLogs(Checkboxes checkbox, String status, LogsMessages logsMessages) {
        logsPanel.shouldHave(text(checkbox.value + logsMessages.text + status));
    }

    public void selectRadioButton(RadioButtons radioButtons) {

        radioButtonsList.get(radioButtons.index).click();
    }

    public void checkRadiosLogs(RadioButtons radioButton, LogsMessages logsMessages) {
        logsPanel.shouldHave(text(logsMessages.text + radioButton));
    }

    public void selectColorInDropdown(Colors colors) {
        colorsDropdown.click();
        colorsDropdown.selectOption(colors.indexOfColor);
    }

    public void checkDropdownLogs(Colors colors,LogsMessages logsMessages) {
        logsPanel.shouldHave(text(logsMessages.text + colors.label));
    }
}