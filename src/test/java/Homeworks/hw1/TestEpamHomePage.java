package Homeworks.hw1;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

// TODO missing variant with soft assertions
// TODO Test does not launching
public class TestEpamHomePage extends SeleniumBase {
    private WebDriver chromeDriver;

    @BeforeMethod
    public void beforeMethod() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
    }

    @Test
    public void testEpamHomePage() {
        // TODO What is the purpose of using window handle?
        String handle = chromeDriver.getWindowHandle();
        chromeDriver.switchTo().window(handle);

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
        // TODO What do you expect from line 42?
        chromeDriver.findElement(By.cssSelector("#user-name")).isDisplayed();
        assertEquals(chromeDriver.findElement(By.cssSelector("#user-name")).getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(chromeDriver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        /* TODO
            * Please try to avoid code duplication
            * I suppose the locators could be improved here
            * What do you expect from execution element.isDisplayed()?
         */
        chromeDriver.findElement(By.cssSelector("a[href='index.html']")).isDisplayed();
        assertEquals((chromeDriver.findElement(By.cssSelector("a[href='index.html']"))).getText(), "HOME");
        chromeDriver.findElement(By.cssSelector("a[href='contacts.html']")).isDisplayed();
        assertEquals((chromeDriver.findElement(By.cssSelector("a[href='contacts.html']"))).getText(), "CONTACT FORM");
        chromeDriver.findElement(By.cssSelector("a[data-toggle='dropdown']")).isDisplayed();
        assertEquals((chromeDriver.findElement(By.cssSelector("a[data-toggle='dropdown']"))).getText(), "SERVICE");
        chromeDriver.findElement(By.cssSelector("a[href='metals-colors.html']")).isDisplayed();
        assertEquals((chromeDriver.findElement(By.cssSelector("a[href='metals-colors.html']"))).getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        // TODO What do you expect from this step
        chromeDriver.findElement(By.cssSelector(".icons-benefit.icon-practise")).isDisplayed();
        chromeDriver.findElement(By.cssSelector(".icons-benefit.icon-custom")).isDisplayed();
        chromeDriver.findElement(By.cssSelector(".icons-benefit.icon-multi")).isDisplayed();
        chromeDriver.findElement(By.cssSelector(".icons-benefit.icon-base")).isDisplayed();

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        // TODO I suggest think about simplifying locators in current step
        assertTrue(chromeDriver.findElement(By.xpath("//*[contains(text(),'To include good practices')]/../div/span[@class='icons-benefit icon-practise']")).isDisplayed());
        assertEquals(chromeDriver.findElement(By.xpath("//*[contains(text(),'To include good practices')]")).getText(), "To include good practices\nand ideas from successful\nEPAM project");
        assertTrue(chromeDriver.findElement(By.xpath("//*[contains(text(),'To be flexible and')]/../div/span[@class='icons-benefit icon-custom']")).isDisplayed());
        assertEquals(chromeDriver.findElement(By.xpath("//*[contains(text(),'To be flexible and')]")).getText(), "To be flexible and\ncustomizable");
        assertTrue(chromeDriver.findElement(By.xpath("//*[contains(text(),'To be multiplatform')]/../div/span[@class='icons-benefit icon-multi']")).isDisplayed());
        assertEquals(chromeDriver.findElement(By.xpath("//*[contains(text(),'To be multiplatform')]")).getText(), "To be multiplatform");
        assertTrue(chromeDriver.findElement(By.xpath("//*[contains(text(),'Already have good base')]/../div/span[@class='icons-benefit icon-base']")).isDisplayed());
        assertEquals(chromeDriver.findElement(By.xpath("//*[contains(text(),'Already have good base')]")).getText(), "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        //9 Assert a text of the main headers
        assertEquals((chromeDriver.findElement(By.cssSelector(".main-title.text-center"))).getText(), "EPAM FRAMEWORK WISHES…");
        // TODO What do you expect from this method invocation?
        chromeDriver.findElement(By.cssSelector(".main-title.text-center")).isDisplayed();
        assertEquals((chromeDriver.findElement(By.cssSelector(".main-txt.text-center"))).getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
        // TODO What do you expect from this method invocation?
        chromeDriver.findElement(By.cssSelector(".main-txt.text-center")).isDisplayed();

        //10 Assert that there is the iframe in the center of page
        assertTrue(chromeDriver.findElement(By.cssSelector("#iframe")).isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        WebElement iFrame = chromeDriver.findElement(By.cssSelector("#iframe"));
        chromeDriver.switchTo().frame(iFrame);
        assertTrue(chromeDriver.findElement(By.cssSelector("#epam_logo")).isDisplayed());

        //12 Switch to original window back
        chromeDriver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        // TODO Please try to avoid code duplications
        assertTrue(chromeDriver.findElement(By.cssSelector("a[href='https://github.com/epam/JDI']")).isDisplayed());
        assertEquals((chromeDriver.findElement(By.cssSelector("a[href='https://github.com/epam/JDI']"))).getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        // TODO Please try to avoid code duplications
        assertEquals(chromeDriver.findElement(By.cssSelector("a[href='https://github.com/epam/JDI']")).getAttribute("ui"), "link");
        assertEquals((chromeDriver.findElement(By.cssSelector("a[href='https://github.com/epam/JDI']"))).getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        assertTrue(chromeDriver.findElement(By.cssSelector("#mCSB_1")).isDisplayed());

        //16 Assert that there is Footer
        assertTrue(chromeDriver.findElement(By.cssSelector(".footer-content.overflow")).isDisplayed());
    }
        //17 Close Browser

    @AfterMethod
    public void afterMethod() {
        chromeDriver.close();
    }
}



