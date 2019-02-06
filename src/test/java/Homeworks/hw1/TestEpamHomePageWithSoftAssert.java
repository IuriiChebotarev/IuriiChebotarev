package Homeworks.hw1;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestEpamHomePageWithSoftAssert extends SeleniumBase {
    private WebDriver chromeDriver;
    private SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void beforeMethod() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
    }

    @Test
    public void testEpamHomePageWithSoftAssert() {

        //1 Open test site by URL
        chromeDriver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        softAssert.assertEquals(chromeDriver.getTitle(), "Home Page");

        //3 Perform login
        chromeDriver.findElement(By.cssSelector("[id='user-icon']")).click();
        chromeDriver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        chromeDriver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        chromeDriver.findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined

        chromeDriver.findElement(By.cssSelector("#user-name")).isDisplayed();
        // Check that user name "PITER CHAILOVSKII" is dispayed in left-top side of screen
        softAssert.assertEquals(chromeDriver.findElement(By.cssSelector("#user-name")).getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        softAssert.assertEquals(chromeDriver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement homePage= chromeDriver.findElement(By.cssSelector("[href='index.html']"));
        homePage.isDisplayed();
        softAssert.assertEquals(homePage.getText(), "HOME");
        WebElement contactForm=chromeDriver.findElement(By.cssSelector("[href='contacts.html']"));
        contactForm.isDisplayed();
        softAssert.assertEquals(contactForm.getText(), "CONTACT FORM");
        WebElement service=chromeDriver.findElement(By.cssSelector("[data-toggle='dropdown']"));
        service.isDisplayed();
        softAssert.assertEquals(service.getText(), "SERVICE");
        WebElement metalsAndColors=chromeDriver.findElement(By.cssSelector("[href='metals-colors.html']"));
        metalsAndColors.isDisplayed();
        softAssert.assertEquals(metalsAndColors.getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertTrue(chromeDriver.findElement(By.cssSelector(".icons-benefit.icon-practise")).isDisplayed());
        softAssert.assertTrue(chromeDriver.findElement(By.cssSelector(".icons-benefit.icon-custom")).isDisplayed());
        softAssert.assertTrue(chromeDriver.findElement(By.cssSelector(".icons-benefit.icon-multi")).isDisplayed());
        softAssert.assertTrue(chromeDriver.findElement(By.cssSelector(".icons-benefit.icon-base")).isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssert.assertEquals(chromeDriver.findElement(By.cssSelector("div.col-sm-3:nth-child(1)")).getText(), "To include good practices\nand ideas from successful\nEPAM project");
        softAssert.assertEquals(chromeDriver.findElement(By.cssSelector("div.col-sm-3:nth-child(2)")).getText(), "To be flexible and\ncustomizable");
        softAssert.assertEquals(chromeDriver.findElement(By.cssSelector("div.col-sm-3:nth-child(3)")).getText(), "To be multiplatform");
        softAssert.assertEquals(chromeDriver.findElement(By.cssSelector("div.col-sm-3:nth-child(4)")).getText(), "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        //9 Assert a text of the main headers
        softAssert.assertEquals((chromeDriver.findElement(By.cssSelector(".main-title.text-center"))).getText(), "EPAM FRAMEWORK WISHES…");
        chromeDriver.findElement(By.cssSelector(".main-title.text-center")).isDisplayed();
        softAssert.assertEquals((chromeDriver.findElement(By.cssSelector(".main-txt.text-center"))).getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
        chromeDriver.findElement(By.cssSelector(".main-txt.text-center")).isDisplayed();

        //10 Assert that there is the iframe in the center of page
        softAssert.assertTrue(chromeDriver.findElement(By.cssSelector("#iframe")).isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        WebElement iFrame = chromeDriver.findElement(By.cssSelector("#iframe"));
        chromeDriver.switchTo().frame(iFrame);
        softAssert.assertTrue(chromeDriver.findElement(By.cssSelector("#epam_logo")).isDisplayed());

        //12 Switch to original window back
        chromeDriver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement subHeader=chromeDriver.findElement(By.cssSelector("a[href='https://github.com/epam/JDI']"));
        softAssert.assertTrue(subHeader.isDisplayed());
        softAssert.assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        WebElement jdiGithub=chromeDriver.findElement(By.cssSelector("a[href='https://github.com/epam/JDI']"));
        softAssert.assertEquals(jdiGithub.getAttribute("ui"), "link");
        softAssert.assertEquals(jdiGithub.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        softAssert.assertTrue(chromeDriver.findElement(By.cssSelector("#mCSB_1")).isDisplayed());

        //16 Assert that there is Footer
        softAssert.assertTrue(chromeDriver.findElement(By.cssSelector(".footer-content.overflow")).isDisplayed());
    }
        //17 Close Browser

    @AfterMethod
    public void afterMethod() {
        chromeDriver.close();
    }
}



