package hw5;

import base.hw4.BasePage;
import base.hw5.BasePageJenkins;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.HomePageData;
import hw4.enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;

public class HomePageJenkins extends BasePageJenkins {

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

    @Step
    public void open(HomePageData homePageData) {
        Selenide.open(homePageData.url);
    }

    @Step
    public void checkTitle(HomePageData homePageData) {
        title.shouldHave(attribute("text", homePageData.title));
    }

    @Step
    public void login(Users users) {
        userIcon.click();
        login.sendKeys(users.login);
        password.sendKeys(users.password);
        submit.click();
    }

    @Step
    public void checkUsername(Users users) {
        userName.shouldHave(text(users.username));
    }
}

