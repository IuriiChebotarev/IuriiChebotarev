package Homeworks.hw2.ex3;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static java.lang.System.currentTimeMillis;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestEpamHomePageWithAnnotations extends SeleniumBase {

    public WebDriver chromeDriver;
    public long startTime = currentTimeMillis();


    @BeforeClass
    public void beforeClass() {
        chromeDriver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        chromeDriver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(chromeDriver.getTitle());
    }

    @AfterClass
    public void afterClass() {
        //17 Close Browser
        chromeDriver.close();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Time of testing was: " + (currentTimeMillis() - startTime));
    }


    @Test
    public void testEpamHomePageWithAnnotations() {
        //1 Open test site by URL
        chromeDriver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        assertEquals(chromeDriver.getTitle(), "Home Page");

        //3 Perform login
        chromeDriver.findElement(By.cssSelector("[id='user-icon']")).click();
        chromeDriver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        chromeDriver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        chromeDriver.findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        assertTrue(chromeDriver.findElement(By.cssSelector("#user-name")).isDisplayed());
        // Check that user name "PITER CHAILOVSKII" is dispayed in left-top side of screen
        assertEquals(chromeDriver.findElement(By.cssSelector("#user-name")).getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(chromeDriver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement HomePage= chromeDriver.findElement(By.cssSelector("[href='index.html']"));
        HomePage.isDisplayed();
        assertEquals(HomePage.getText(), "HOME");
        WebElement ContactForm=chromeDriver.findElement(By.cssSelector("[href='contacts.html']"));
        ContactForm.isDisplayed();
        assertEquals(ContactForm.getText(), "CONTACT FORM");
        WebElement Service=chromeDriver.findElement(By.cssSelector("[data-toggle='dropdown']"));
        Service.isDisplayed();
        assertEquals(Service.getText(), "SERVICE");
        WebElement MetalsAndColors=chromeDriver.findElement(By.cssSelector("[href='metals-colors.html']"));
        MetalsAndColors.isDisplayed();
        assertEquals(MetalsAndColors.getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        assertTrue(chromeDriver.findElement(By.cssSelector(".icons-benefit.icon-practise")).isDisplayed());
        assertTrue(chromeDriver.findElement(By.cssSelector(".icons-benefit.icon-custom")).isDisplayed());
        assertTrue(chromeDriver.findElement(By.cssSelector(".icons-benefit.icon-multi")).isDisplayed());
        assertTrue(chromeDriver.findElement(By.cssSelector(".icons-benefit.icon-base")).isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertEquals(chromeDriver.findElement(By.cssSelector("div.col-sm-3:nth-child(1)")).getText(), "To include good practices\nand ideas from successful\nEPAM project");
        assertEquals(chromeDriver.findElement(By.cssSelector("div.col-sm-3:nth-child(2)")).getText(), "To be flexible and\ncustomizable");
        assertEquals(chromeDriver.findElement(By.cssSelector("div.col-sm-3:nth-child(3)")).getText(), "To be multiplatform");
        assertEquals(chromeDriver.findElement(By.cssSelector("div.col-sm-3:nth-child(4)")).getText(), "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        //9 Assert a text of the main headers
        assertEquals((chromeDriver.findElement(By.cssSelector(".main-title.text-center"))).getText(), "EPAM FRAMEWORK WISHES…");

        assertTrue(chromeDriver.findElement(By.cssSelector(".main-title.text-center")).isDisplayed());
        assertEquals((chromeDriver.findElement(By.cssSelector(".main-txt.text-center"))).getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        assertTrue(chromeDriver.findElement(By.cssSelector(".main-txt.text-center")).isDisplayed());

        //10 Assert that there is the iframe in the center of page
        assertTrue(chromeDriver.findElement(By.cssSelector("#iframe")).isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        WebElement iFrame = chromeDriver.findElement(By.cssSelector("#iframe"));
        chromeDriver.switchTo().frame(iFrame);
        assertTrue(chromeDriver.findElement(By.cssSelector("#epam_logo")).isDisplayed());

        //12 Switch to original window back
        chromeDriver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement SubHeader=chromeDriver.findElement(By.cssSelector("a[href='https://github.com/epam/JDI']"));
        assertTrue(SubHeader.isDisplayed());
        assertEquals(SubHeader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        WebElement JdiGithub=chromeDriver.findElement(By.cssSelector("a[href='https://github.com/epam/JDI']"));
        assertEquals(JdiGithub.getAttribute("ui"), "link");
        assertEquals(JdiGithub.getAttribute("href"), "https://github.com/epam/JDI");
        //15 Assert that there is Left Section
        assertTrue(chromeDriver.findElement(By.cssSelector("#mCSB_1")).isDisplayed());
        //16 Assert that there is Footer
        assertTrue(chromeDriver.findElement(By.cssSelector(".footer-content.overflow")).isDisplayed());
    }
}






