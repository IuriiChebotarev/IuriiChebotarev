package hw6;

import base.hw6.BasePage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import hw3.pageObject.enums.TextsOfHeaders;
import hw6.enums.HomePageData;
import hw6.enums.Users;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static hw6.enums.Users.getUserName;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage extends BasePage {

    @FindBy(css = "#user-icon")
    private SelenideElement userIcon;

    @FindBy(css = "#name")
    private SelenideElement loginField;

    @FindBy(css = "#password")
    private SelenideElement passwordField;

    @FindBy(css = "#login-button")
    private SelenideElement submit;

    @FindBy(css = "title")
    private SelenideElement title;

    @FindBy(css = "#user-name")
    private SelenideElement displayedUserName;

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 > li")
    private List<WebElement> navigationBar;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> benefitTxt;

    @FindBy(css = ".main-title.text-center")
    private WebElement mainTitle;

    @FindBy(css = ".main-txt.text-center")
    private WebElement textCenter;

    public HomePage() {
        page(this);
    }

    public void open(HomePageData homePageData) {
        Selenide.open(homePageData.url);
    }

    public void checkTitle(HomePageData homePageData) {

        assertEquals(getWebDriver().getTitle(), homePageData.title);
    }

    public void checkTitleOfPage(String title) {

        assertEquals(getWebDriver().getTitle(), title);
    }

    public void login(Users users) {
        userIcon.click();
        loginField.sendKeys(users.login);
        passwordField.sendKeys(users.password);
        submit.click();
    }

    public void loginAs(Users users) {
        userIcon.click();
        loginField.sendKeys(users.login);
        passwordField.sendKeys(users.password);
        submit.click();
    }

    public void checkUsername(Users users) {
        displayedUserName.shouldHave(text(users.username));
    }

    public void checkUserByUserName(String username) {
        assertEquals(displayedUserName.getText(), getUserName(username).username);
    }

    public void checkItems(List<String> Items) {
        for (int i = 0; i < navigationBar.size(); i ++) {
            assertEquals(navigationBar.get(i).getText(), Items.get(i));
        }
    }

    public void checkImages() {
        for (WebElement benefitIcon : benefitIcons) {
            assertTrue(benefitIcon.isDisplayed());
        }
    }

    public void checkBenefitTexts(List<String> benefitTexts) {
        for (int i = 0; i < benefitTxt.size(); i ++) {
            assertEquals(benefitTxt.get(i).getText(), benefitTexts.get(i));
        }
    }

    public void checkMainHeaderTitle(TextsOfHeaders textsOfHeaders) {
        assertEquals(mainTitle.getText(), textsOfHeaders.toString());
    }

    public void checkMainHeaderText(TextsOfHeaders textsOfHeaders) {
        assertEquals(textCenter.getText(), textsOfHeaders.toString());
    }
}




