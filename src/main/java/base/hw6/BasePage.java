package base.hw6;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw6.enums.ServiceDropDown;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public abstract class BasePage {

    @FindBy(css = ".dropdown")
    private SelenideElement serviceDropdownInHeader;

    @FindBy(css = ".dropdown-menu > li")
    private ElementsCollection serviceDropdownItemsInHeader;

    @FindBy(css = "dropdown-menu > li")
    private ElementsCollection serviceDropdownItemsLabelsInHeader;

    @FindBy(css = ".menu-title")
    private SelenideElement serviceDropdownInLeftMenu;

    @FindBy(css = "sub > li")
    private ElementsCollection serviceDropdownItemsInLeftMenu;

    @FindBy(css = ".right-fix-panel")
    private SelenideElement rightSection;

    public BasePage() {
        page(this);
    }

    public void clickOnServiceDropdownInHeader() {
        serviceDropdownInHeader.click();
    }

    public void checkServiceDropdownListInHeader(List<String> serviceDropdownItems) {
        for (int i = 0; i < serviceDropdownItemsLabelsInHeader.size(); i++) {
            serviceDropdownItemsLabelsInHeader.get(i).shouldHave(text(serviceDropdownItems.get(i)));
        }
    }

    public void clickOnServiceDropdownInLeftMenu() {
        serviceDropdownInLeftMenu.click();
    }

    public void checkServiceDropdownListInLeftMenu(List<String> serviceDropdownItems) {
        for (int i = 0; i < serviceDropdownItemsInLeftMenu.size(); i++) {
            serviceDropdownItemsInLeftMenu.get(i).shouldHave(text(serviceDropdownItems.get(i)));
        }
    }

    public void selectPageInServiceDropdown(ServiceDropDown serviceDropDown) {
        serviceDropdownInHeader.click();
        serviceDropdownItemsInHeader.get(serviceDropDown.index).click();
    }

    public void checkRightSection() {
        rightSection.isDisplayed();
    }
}
