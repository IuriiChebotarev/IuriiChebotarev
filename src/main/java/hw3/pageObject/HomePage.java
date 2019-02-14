package hw3.pageObject;

import hw3.pageObject.enums.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage {

    @FindBy(css = "[id='user-icon']")
    private WebElement userIcon;

    @FindBy(css = "[id='name']")
    private WebElement login;

    @FindBy(css = "[id='password']")
    private WebElement password;

    @FindBy(css = "[id='login-button']")
    private WebElement submit;

    @FindBy(css = "[id='user-name']")
    private WebElement userName;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> benefitTxt;

    @FindBy(css = ".main-title.text-center")
    private WebElement mainTitle;

    @FindBy(css = ".main-txt.text-center")
    private WebElement textCenter;

    @FindBy(css = "[id='iframe']")
    private WebElement iframe;

    @FindBy(css = "[id='epam_logo']")
    private  WebElement epamLogo;

    @FindBy(css = "a[href='https://github.com/epam/JDI']")
    private WebElement link;

    @FindBy(css = "#mCSB_1")
    private WebElement leftSection;

    @FindBy(css = ".footer-content.overflow")
    private WebElement footer;

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 > li")
    private List<WebElement> navigationBar;

    private WebDriver chromeDriver;

    public HomePage(WebDriver driver) {

        this.chromeDriver = driver;
    }
    public void open(){
        chromeDriver.navigate().to(HomePageData.HOME_PAGE_DATA.url);
    }

    public void checkTitle(){
        assertEquals(chromeDriver.getTitle(), HomePageData.HOME_PAGE_DATA.title);
    }

    public void login(Users user){
        userIcon.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
    }

    public void checkThatUserLoggedIn(){
        assertTrue(userName.isDisplayed());
    }

    public void checkUserName(Users user) {
        assertEquals(userName.getText(), user.name);
    }

    public void checkItems(List<String> Items) {
        // TODO What is purpose of searching here elements???--FIXED
        for (int i = 0; i < navigationBar.size(); i ++) {
            assertEquals(navigationBar.get(i).getText(), Items.get(i));
        }
    }

    public void checkImages() {
        // TODO What is purpose of searching here elements???--FIXED
        for (WebElement benefitIcon : benefitIcons) {
            assertTrue(benefitIcon.isDisplayed());
        }
    }

    public void checkBenefitTexts(List<String> benefitTexts) {
        for (int i = 0; i < benefitTxt.size(); i ++) {
            assertEquals(benefitTxt.get(i).getText(), benefitTexts.get(i));
        }
    }

    // TODO I suppose this method could be parametrized--FIXED
    public void checkMainHeaderTitle(TextsOfHeaders textsOfHeaders) {
        assertEquals(mainTitle.getText(), textsOfHeaders.toString());
    }

    public void checkMainHeaderText(TextsOfHeaders textsOfHeaders) {
        assertEquals(textCenter.getText(), textsOfHeaders.toString());
    }

    public void checkIframe() {
        assertTrue(iframe.isDisplayed());
    }

    public void switchToIframe(){
        chromeDriver.switchTo().frame(iframe);
    }

    public void checkEpamLogoInIframe(){
        assertTrue(epamLogo.isDisplayed());
    }

    public void switchToDefaultPage(){
        chromeDriver.switchTo().defaultContent();
    }
    // TODO missing empty line
    public void checkSubHeaderText(TextsOfHeaders textsOfHeaders) {
        assertTrue(link.isDisplayed());
        assertEquals(link.getText(), textsOfHeaders.toString());
    }

    public void checkJdiUrl(JdiLink JdiLink) {
        assertEquals(link.getAttribute("href"), JdiLink.jdiLink);
    }

    public void checkLeftSection() {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkFooter() {
        assertTrue(footer.isDisplayed());
    }

    public  void closeBrowser() {
        chromeDriver.close();
    }
}

