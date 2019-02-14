package Homeworks.hw2.ex2;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

// TODO Same as in AllRegressionAndSmokeTestsSimultaneously
public class AllRegressionTests extends SeleniumBase {

    private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        // TODO It will be better create instance of the Chrome here and add it to ThreadLocal
        WebDriver driver = new ChromeDriver();
        drivers.set(driver);
        driver().manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        WebDriver driver=driver();
        driver.quit();
    }

    @Test(groups = {"regression"})
    public void allRegressionTestsCopyOne() {

        //1 Open test site by URL
        driver().navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        assertEquals(driver().getTitle(), "Home Page");

        //3 Perform login
        driver().findElement(By.cssSelector("[id='user-icon']")).click();
        driver().findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver().findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver().findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        assertTrue(driver().findElement(By.cssSelector("#user-name")).isDisplayed());
        // Check that user name "PITER CHAILOVSKII" is dispayed in left-top side of screen
        assertEquals(driver().findElement(By.cssSelector("#user-name")).getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver().getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement homePage = driver().findElement(By.cssSelector("[href='index.html']"));
        homePage.isDisplayed();
        assertEquals(homePage.getText(), "HOME");
        WebElement contactForm = driver().findElement(By.cssSelector("[href='contacts.html']"));
        contactForm.isDisplayed();
        assertEquals(contactForm.getText(), "CONTACT FORM");
        WebElement service = driver().findElement(By.cssSelector("[data-toggle='dropdown']"));
        service.isDisplayed();
        assertEquals(service.getText(), "SERVICE");
        WebElement metalsAndColors = driver().findElement(By.cssSelector("[href='metals-colors.html']"));
        metalsAndColors.isDisplayed();
        assertEquals(metalsAndColors.getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        assertTrue(driver().findElement(By.cssSelector(".icons-benefit.icon-practise")).isDisplayed());
        assertTrue(driver().findElement(By.cssSelector(".icons-benefit.icon-custom")).isDisplayed());
        assertTrue(driver().findElement(By.cssSelector(".icons-benefit.icon-multi")).isDisplayed());
        assertTrue(driver().findElement(By.cssSelector(".icons-benefit.icon-base")).isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertEquals(driver().findElement(By.cssSelector("div.col-sm-3:nth-child(1)")).getText(), "To include good practices\nand ideas from successful\nEPAM project");
        assertEquals(driver().findElement(By.cssSelector("div.col-sm-3:nth-child(2)")).getText(), "To be flexible and\ncustomizable");
        assertEquals(driver().findElement(By.cssSelector("div.col-sm-3:nth-child(3)")).getText(), "To be multiplatform");
        assertEquals(driver().findElement(By.cssSelector("div.col-sm-3:nth-child(4)")).getText(), "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        //9 Assert a text of the main headers
        assertEquals((driver().findElement(By.cssSelector(".main-title.text-center"))).getText(), "EPAM FRAMEWORK WISHES…");
        assertTrue(driver().findElement(By.cssSelector(".main-title.text-center")).isDisplayed());
        assertEquals((driver().findElement(By.cssSelector(".main-txt.text-center"))).getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
        driver().findElement(By.cssSelector(".main-txt.text-center")).isDisplayed();

        //10 Assert that there is the iframe in the center of page
        assertTrue(driver().findElement(By.cssSelector("#iframe")).isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        WebElement iFrame = driver().findElement(By.cssSelector("#iframe"));
        driver().switchTo().frame(iFrame);
        assertTrue(driver().findElement(By.cssSelector("#epam_logo")).isDisplayed());

        //12 Switch to original window back
        driver().switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement subHeader = driver().findElement(By.cssSelector("a[href='https://github.com/epam/JDI']"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        WebElement jdiGithub = driver().findElement(By.cssSelector("a[href='https://github.com/epam/JDI']"));
        assertEquals(jdiGithub.getAttribute("ui"), "link");
        assertEquals(jdiGithub.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        assertTrue(driver().findElement(By.cssSelector("#mCSB_1")).isDisplayed());

        //16 Assert that there is Footer
        assertTrue(driver().findElement(By.cssSelector(".footer-content.overflow")).isDisplayed());

        //17 Close Browser
        driver().close();
    }

    @Test(groups = {"regression"})
    public void allRegressionTestsCopyTwo() {

        //1 Open test site by URL
        driver().navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        assertEquals(driver().getTitle(), "Home Page");

        //3 Perform login
        driver().findElement(By.cssSelector("[id='user-icon']")).click();
        driver().findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver().findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver().findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        assertTrue(driver().findElement(By.cssSelector("#user-name")).isDisplayed());
        // Check that user name "PITER CHAILOVSKII" is dispayed in left-top side of screen
        assertEquals(driver().findElement(By.cssSelector("#user-name")).getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver().getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement homePage = driver().findElement(By.cssSelector("[href='index.html']"));
        homePage.isDisplayed();
        assertEquals(homePage.getText(), "HOME");
        WebElement contactForm = driver().findElement(By.cssSelector("[href='contacts.html']"));
        contactForm.isDisplayed();
        assertEquals(contactForm.getText(), "CONTACT FORM");
        WebElement service = driver().findElement(By.cssSelector("[data-toggle='dropdown']"));
        service.isDisplayed();
        assertEquals(service.getText(), "SERVICE");
        WebElement metalsAndColors = driver().findElement(By.cssSelector("[href='metals-colors.html']"));
        metalsAndColors.isDisplayed();
        assertEquals(metalsAndColors.getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        assertTrue(driver().findElement(By.cssSelector(".icons-benefit.icon-practise")).isDisplayed());
        assertTrue(driver().findElement(By.cssSelector(".icons-benefit.icon-custom")).isDisplayed());
        assertTrue(driver().findElement(By.cssSelector(".icons-benefit.icon-multi")).isDisplayed());
        assertTrue(driver().findElement(By.cssSelector(".icons-benefit.icon-base")).isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertEquals(driver().findElement(By.cssSelector("div.col-sm-3:nth-child(1)")).getText(), "To include good practices\nand ideas from successful\nEPAM project");
        assertEquals(driver().findElement(By.cssSelector("div.col-sm-3:nth-child(2)")).getText(), "To be flexible and\ncustomizable");
        assertEquals(driver().findElement(By.cssSelector("div.col-sm-3:nth-child(3)")).getText(), "To be multiplatform");
        assertEquals(driver().findElement(By.cssSelector("div.col-sm-3:nth-child(4)")).getText(), "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        //9 Assert a text of the main headers
        assertEquals((driver().findElement(By.cssSelector(".main-title.text-center"))).getText(), "EPAM FRAMEWORK WISHES…");
        assertTrue(driver().findElement(By.cssSelector(".main-title.text-center")).isDisplayed());
        assertEquals((driver().findElement(By.cssSelector(".main-txt.text-center"))).getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
        driver().findElement(By.cssSelector(".main-txt.text-center")).isDisplayed();

        //10 Assert that there is the iframe in the center of page
        assertTrue(driver().findElement(By.cssSelector("#iframe")).isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        WebElement iFrame = driver().findElement(By.cssSelector("#iframe"));
        driver().switchTo().frame(iFrame);
        assertTrue(driver().findElement(By.cssSelector("#epam_logo")).isDisplayed());

        //12 Switch to original window back
        driver().switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement subHeader = driver().findElement(By.cssSelector("a[href='https://github.com/epam/JDI']"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        WebElement jdiGithub = driver().findElement(By.cssSelector("a[href='https://github.com/epam/JDI']"));
        assertEquals(jdiGithub.getAttribute("ui"), "link");
        assertEquals(jdiGithub.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        assertTrue(driver().findElement(By.cssSelector("#mCSB_1")).isDisplayed());

        //16 Assert that there is Footer
        assertTrue(driver().findElement(By.cssSelector(".footer-content.overflow")).isDisplayed());

        //17 Close Browser
        driver().close();
    }

    @Test(groups = {"regression"})
    public void allRegressionTestsCopyThree() {

        //1 Open test site by URL
        driver().navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        assertEquals(driver().getTitle(), "Home Page");

        //3 Perform login
        driver().findElement(By.cssSelector("[id='user-icon']")).click();
        driver().findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver().findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver().findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        assertTrue(driver().findElement(By.cssSelector("#user-name")).isDisplayed());
        // Check that user name "PITER CHAILOVSKII" is dispayed in left-top side of screen
        assertEquals(driver().findElement(By.cssSelector("#user-name")).getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver().getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement homePage = driver().findElement(By.cssSelector("[href='index.html']"));
        homePage.isDisplayed();
        assertEquals(homePage.getText(), "HOME");
        WebElement contactForm = driver().findElement(By.cssSelector("[href='contacts.html']"));
        contactForm.isDisplayed();
        assertEquals(contactForm.getText(), "CONTACT FORM");
        WebElement service = driver().findElement(By.cssSelector("[data-toggle='dropdown']"));
        service.isDisplayed();
        assertEquals(service.getText(), "SERVICE");
        WebElement metalsAndColors = driver().findElement(By.cssSelector("[href='metals-colors.html']"));
        metalsAndColors.isDisplayed();
        assertEquals(metalsAndColors.getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        assertTrue(driver().findElement(By.cssSelector(".icons-benefit.icon-practise")).isDisplayed());
        assertTrue(driver().findElement(By.cssSelector(".icons-benefit.icon-custom")).isDisplayed());
        assertTrue(driver().findElement(By.cssSelector(".icons-benefit.icon-multi")).isDisplayed());
        assertTrue(driver().findElement(By.cssSelector(".icons-benefit.icon-base")).isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertEquals(driver().findElement(By.cssSelector("div.col-sm-3:nth-child(1)")).getText(), "To include good practices\nand ideas from successful\nEPAM project");
        assertEquals(driver().findElement(By.cssSelector("div.col-sm-3:nth-child(2)")).getText(), "To be flexible and\ncustomizable");
        assertEquals(driver().findElement(By.cssSelector("div.col-sm-3:nth-child(3)")).getText(), "To be multiplatform");
        assertEquals(driver().findElement(By.cssSelector("div.col-sm-3:nth-child(4)")).getText(), "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        //9 Assert a text of the main headers
        assertEquals((driver().findElement(By.cssSelector(".main-title.text-center"))).getText(), "EPAM FRAMEWORK WISHES…");
        assertTrue(driver().findElement(By.cssSelector(".main-title.text-center")).isDisplayed());
        assertEquals((driver().findElement(By.cssSelector(".main-txt.text-center"))).getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
        driver().findElement(By.cssSelector(".main-txt.text-center")).isDisplayed();

        //10 Assert that there is the iframe in the center of page
        assertTrue(driver().findElement(By.cssSelector("#iframe")).isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        WebElement iFrame = driver().findElement(By.cssSelector("#iframe"));
        driver().switchTo().frame(iFrame);
        assertTrue(driver().findElement(By.cssSelector("#epam_logo")).isDisplayed());

        //12 Switch to original window back
        driver().switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement subHeader = driver().findElement(By.cssSelector("a[href='https://github.com/epam/JDI']"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        WebElement jdiGithub = driver().findElement(By.cssSelector("a[href='https://github.com/epam/JDI']"));
        assertEquals(jdiGithub.getAttribute("ui"), "link");
        assertEquals(jdiGithub.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        assertTrue(driver().findElement(By.cssSelector("#mCSB_1")).isDisplayed());

        //16 Assert that there is Footer
        assertTrue(driver().findElement(By.cssSelector(".footer-content.overflow")).isDisplayed());
    }

    private WebDriver driver() {
        WebDriver driver = drivers.get();
        if (driver == null) {
            throw new IllegalStateException("Driver should have not been null.");
        }
        return driver;
    }
}




