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
import java.util.ArrayList;
import java.util.List;

// TODO Java Code Convention style
public class EpamHomePageWithPageObjects extends SeleniumBase {

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
        homePage.open();

        //2 Assert Browser title
        homePage.checkTitle();

        //3 Perform login
        homePage.login(Users.PETER);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePage.checkThatUserLoggedIn();

        // Check that user name "PITER CHAILOVSKII" is dispayed in left-top side of screen
        homePage.checkUserName(Users.PETER);

        //5 Assert Browser title
        homePage.checkTitle();

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<String> itemsWithTexts = new ArrayList<String>();
        itemsWithTexts.add(ItemsWithTexts.HOME.ItemText);
        itemsWithTexts.add(ItemsWithTexts.CONTACT_FORM.ItemText);
        itemsWithTexts.add(ItemsWithTexts.SERVICE.ItemText);
        itemsWithTexts.add(ItemsWithTexts.METALS_COLORS.ItemText);

        homePage.checkItems(itemsWithTexts);

        //7 Assert that there are 4 images on the Index Page and they are displayed
        homePage.checkImages();

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> imagesTexts = new ArrayList<String>();
        imagesTexts.add(TextsBelowImages.FIRST_ICON_TEXT.ImagesText);
        imagesTexts.add(TextsBelowImages.SECOND_ICON_TEXT.ImagesText);
        imagesTexts.add(TextsBelowImages.THIRD_ICON_TEXT.ImagesText);
        imagesTexts.add(TextsBelowImages.FOURTH_ICON_TEXT.ImagesText);

        //9 Assert a text of the main headers
        homePage.checkMainHeaderTitle();
        homePage.checkMainHeaderText();

        //10 Assert that there is the iframe in the center of page
        homePage.checkIframe();

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        homePage.switchToIframe();
        homePage.checkEpamLogoInIframe();

        //12 Switch to original window back
        homePage.switchToDefaultPage();

        //13 Assert a text of the sub header
        homePage.checkSubHeaderText(TextsOfHeaders.SUB_HEADER_TEXT);

        //14 Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkJdiUrl();

        //15 Assert that there is Left Section
        homePage.checkLeftSection();

        //16 Assert that there is Footer
        homePage.checkFooter();
    }
}
