package Homeworks.hw3;

import base.SeleniumBase;
import hw3.pageObject.enums.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import hw3.pageObject.HomePage;

// TODO Java Code Convention style
public class TestEpamHomePageWithPageObjects extends SeleniumBase {

    private WebDriver chromeDriver;
    private HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        chromeDriver = new ChromeDriver();
        homePage = PageFactory.initElements(chromeDriver, HomePage.class);
    }
    @BeforeMethod
    public void beforeMethod() {
        chromeDriver.manage().window().maximize();
    }
    @AfterMethod(alwaysRun = true)
    public void afterMethod(){

        //17 Close Browser
        homePage.closeBrowser();
    }
    @Test
    public void  testEpamHomePageWithPageObjects() {

        //1 Open test site by URL
        homePage.open(HomePageData.INDEX_HTML_URL);

        //2 Assert Browser title
        homePage.checkTitle(HomePageData.HOME_PAGE_TITLE);

        //3 Perform login
        homePage.login(Users.PETER);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePage.checkThatUserLoggedIn();

        // Check that user name "PITER CHAILOVSKII" is dispayed in left-top side of screen
        homePage.checkUserName(Users.PETER);

        //5 Assert Browser title
        homePage.checkTitle(HomePageData.HOME_PAGE_TITLE);

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.checkItems(Items.ITEMS);

        //7 Assert that there are 4 images on the Index Page and they are displayed
        homePage.checkImages();

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.checkTextsBelowImages(TextsBelowImages.TEXTS);

        //9 Assert a text of the main headers
        homePage.checkTextsOfTheMainHeader(TextsOfHeaders.TEXTS_OF_HEADERS);

        //10 Assert that there is the iframe in the center of page
        homePage.checkIframe();

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        homePage.switchToIframe();
        homePage.checkEpamLogoInIframe();

        //12 Switch to original window back
        homePage.switchToDefaultPage();

        //13 Assert a text of the sub header
        homePage.checkTextinSubHeader(TextsOfHeaders.TEXTS_OF_HEADERS);

        //14 Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkJdiGithubIsALinkWithProperUrl(JdiUrl.JDI_URL);

        //15 Assert that there is Left Section
        homePage.checkLeftSection();

        //16 Assert that there is Footer
        homePage.checkFooter();
    }
}
