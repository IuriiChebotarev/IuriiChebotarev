package hw3.pageObject;

import hw3.pageObject.enums.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
// TODO Remove unused imports// TODO Java Code Convention
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

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 > li")
    private WebElement items;

    @FindBy(css = "[class='icons-benefit icon-practise']")
    private WebElement iconPractise;

    @FindBy(css = "[class='icons-benefit icon-custom']")
    private WebElement iconCustom;

    @FindBy(css = "[class='icons-benefit icon-multi']")
    private WebElement iconMulti;

    @FindBy(css = "[class='icons-benefit icon-base']")
    private WebElement iconBase;

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

    private WebDriver chromeDriver;

    public HomePage(WebDriver driver) {

        this.chromeDriver = driver;
    }
    public void open(){

        chromeDriver.navigate().to(HomePageData.HOME_PAGE_DATA.url);
    }

    public void checkTitle(){
        // TODO Is it required use .toString?
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
        // TODO please make unique method
        List<WebElement> navigationBar = chromeDriver.findElements(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 > li"));

        for (int i = 0; i < navigationBar.size(); i ++) {
            assertEquals(navigationBar.get(i).getText(), Items.get(i));
        }
    }

    public void checkImages() {
        List<WebElement> benefitIcons = chromeDriver.findElements(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 > li"));

        for (WebElement benefitIcon : benefitIcons) {
            assertTrue(benefitIcon.isDisplayed());
        }
    }

    public void checkMainHeaderTitle() {

        assertEquals(mainTitle.getText(), TextsOfHeaders.MAIN_HEADER_TITLE.toString());
    }

    public void checkMainHeaderText() {

        assertEquals(textCenter.getText(), TextsOfHeaders.MAIN_HEADER_TEXT.toString());
    }

    public void checkIframe() {
        assertTrue(iframe.isDisplayed());
    }

    public void switchToIframe(){
        //TODO ???
        chromeDriver.switchTo().frame(iframe);
    }

    public void checkEpamLogoInIframe(){
        assertTrue(epamLogo.isDisplayed());
    }

    public void switchToDefaultPage(){
        chromeDriver.switchTo().defaultContent();
    }
    // TODO methods name
    public void checkSubHeaderText(TextsOfHeaders textsOfHeaders) {
         // TODO ???
        assertTrue(link.isDisplayed());
        assertEquals(link.getText(), textsOfHeaders.toString());
    }

    public void checkJdiUrl() {
        // TODO ???
        assertEquals(link.getAttribute("href"), HomePageData.HOME_PAGE_DATA.jdiUrl);
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

