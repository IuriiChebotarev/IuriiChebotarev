package hw4;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.HomePageData;
import hw4.enums.Users;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import static com.codeborne.selenide.Condition.*;

public class HomePage {

    @FindBy(css = "#user-icon")
    private SelenideElement userIcon;

    @FindBy(css = "#name")
    private SelenideElement login;

    @FindBy(css = "#password")
    private SelenideElement password;

    @FindBy(css = "#login-button")
    private SelenideElement submit;

    @FindBy(css = "title")
    private SelenideElement title;

    @FindBy(css = "#user-name")
    private SelenideElement userName;

    @FindBy(css = ".dropdown")
    private SelenideElement serviceDropdownInHeader;

    @FindBy(css = "dropdown-menu > li")
    private List<SelenideElement> serviceDropdownItemsInHeader;

    @FindBy(css = ".menu-title")
    private SelenideElement serviceDropdownInLeftMenu;

    @FindBy(css = "sub > li")
    private List<SelenideElement> serviceDropdownItemsInLeftMenu;

    @FindBy(css = ".dropdown-menu > li:nth-child(7)")
    private SelenideElement elementsPageItem;

    @FindBy(css = ".dropdown-menu > li:nth-child(2)")
    private SelenideElement datesPageItem;

    public void open(HomePageData homePageData) {
        Selenide.open(homePageData.url);
    }

    public void checkTitle(HomePageData homePageData) {
        title.shouldHave(attribute("text", homePageData.title));
    }

    public void login(Users users) {
        userIcon.click();
        login.sendKeys(users.login);
        password.sendKeys(users.password);
        submit.click();
    }

    public void checkUsername(Users users) {
        userName.shouldHave(text(users.username));
    }

    public void checkServiceDropdownListInHeader(List<String> serviceDropdownItems) {
        serviceDropdownInHeader.click();

        for (int i = 0; i < serviceDropdownItemsInHeader.size(); i++) {
            serviceDropdownItemsInHeader.get(i).shouldHave(text(serviceDropdownItems.get(i)));
        }
    }

    public void checkServiceDropdownListInLeftMenu(List<String> serviceDropdownItems) {
        serviceDropdownInLeftMenu.click();

        for (int i = 0; i < serviceDropdownItemsInLeftMenu.size(); i++) {
            serviceDropdownItemsInLeftMenu.get(i).shouldHave(text(serviceDropdownItems.get(i)));
        }
    }

    // TODO This method should be parametrized
    public void openDifferentElementsPage() {
        serviceDropdownInHeader.click();
        elementsPageItem.click();
    }

    // TODO This method should be parametrized
    public void openDatesPage() {
        serviceDropdownInHeader.click();
        datesPageItem.click();
    }
}