package hw3.pageObject;

import hw3.pageObject.enums.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
// TODO Remove unused imports
// TODO Java Code Convention
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

    @FindBy(css = "[href='index.html']")
    private WebElement homeItem;

    @FindBy(css = "[href='contacts.html']")
    private WebElement contactFormItem;

    @FindBy(css = "[data-toggle='dropdown']")
    private WebElement serviceItem;

    @FindBy(css = "[href='metals-colors.html']")
    private WebElement metalsAndcolorsItem;

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
    private WebElement subHeaderLink;

    @FindBy(css = "a[target='_blank']")
    private WebElement blank;

    @FindBy(css = "#mCSB_1")
    private WebElement leftSection;

    @FindBy(css = ".footer-content.overflow")
    private WebElement footer;

    private WebDriver chromeDriver;

    public HomePage(WebDriver driver) {
        this.chromeDriver = driver;
    }
    public void open(HomePageData url){
        chromeDriver.navigate().to(url.toString());
    }

    public void checkTitle(HomePageData title){
        // TODO Is it required use .toString?
        assertEquals(chromeDriver.getTitle(), title.toString());
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

    public void checkItems(Items items) {
        // TODO please make unique method
        assertTrue(homeItem.isDisplayed());
        assertEquals(homeItem.getText(), items.home);
        assertTrue(contactFormItem.isDisplayed());
        assertEquals(contactFormItem.getText(), items.contactForm);
        assertTrue(serviceItem.isDisplayed());
        assertEquals(serviceItem.getText(), items.service);
        assertTrue(metalsAndcolorsItem.isDisplayed());
        assertEquals(metalsAndcolorsItem.getText(), items.metalsAndColors);
    }
    public void checkImages (){
        // TODO please make it for the one check
        assertTrue(iconPractise.isDisplayed());
        assertTrue(iconCustom.isDisplayed());
        assertTrue(iconMulti.isDisplayed());
        assertTrue(iconBase.isDisplayed());
    }

    public void checkTextsBelowImages (TextsBelowImages texts) {
        assertEquals(chromeDriver.findElement(By.cssSelector("div.col-sm-3:nth-child(1)")).getText(), texts.firstText);
        assertEquals(chromeDriver.findElement(By.cssSelector("div.col-sm-3:nth-child(2)")).getText(), texts.secondText);
        assertEquals(chromeDriver.findElement(By.cssSelector("div.col-sm-3:nth-child(3)")).getText(), texts.thirdText);
        assertEquals(chromeDriver.findElement(By.cssSelector("div.col-sm-3:nth-child(4)")).getText(), texts.fourthText);
    }

    public void checkTextsOfTheMainHeader(TextsOfHeaders textsOfHeaders) {
        assertEquals(mainTitle.getText(), textsOfHeaders.firstText);
        assertTrue(mainTitle.isDisplayed());
        assertEquals(textCenter.getText(), textsOfHeaders.secondText);
        assertTrue(textCenter.isDisplayed());
    }

    public void checkIframe() {
        assertTrue(iframe.isDisplayed());
    }

    public void switchToIframe(){
        WebElement iFrame = iframe; // TODO ???
        chromeDriver.switchTo().frame(iFrame);
    }

    public void checkEpamLogoInIframe(){
        assertTrue(epamLogo.isDisplayed());
    }

    public void switchToDefaultPage(){
        chromeDriver.switchTo().defaultContent();
    }
    // TODO methods name
    public void checkTextinSubHeader(TextsOfHeaders textsOfHeaders) {
        WebElement subHeader = subHeaderLink; // TODO ???
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), textsOfHeaders.thirdText);
    }

    public void checkJdiGithubIsALinkWithProperUrl(JdiUrl url) {
        WebElement jdiGithub = subHeaderLink;// TODO ???
        assertEquals(jdiGithub.getAttribute("ui"), "link");
        assertEquals(jdiGithub.getAttribute("href"), url.url);
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

