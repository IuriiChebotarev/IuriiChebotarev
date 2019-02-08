package Homeworks.hw2.ex2;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AllSmokeTests extends SeleniumBase {

    @Test(groups = {"smoke"})
    public void allSmokeTestsCopyOne() {
        // TODO Please avoid code duplication
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

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
        WebElement homePage= chromeDriver.findElement(By.cssSelector("[href='index.html']"));
        homePage.isDisplayed();
        assertEquals(homePage.getText(), "HOME");
        WebElement contactForm=chromeDriver.findElement(By.cssSelector("[href='contacts.html']"));
        contactForm.isDisplayed();
        assertEquals(contactForm.getText(), "CONTACT FORM");
        WebElement service=chromeDriver.findElement(By.cssSelector("[data-toggle='dropdown']"));
        service.isDisplayed();
        assertEquals(service.getText(), "SERVICE");
        WebElement metalsAndColors=chromeDriver.findElement(By.cssSelector("[href='metals-colors.html']"));
        metalsAndColors.isDisplayed();
        assertEquals(metalsAndColors.getText(), "METALS & COLORS");

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
        WebElement subHeader=chromeDriver.findElement(By.cssSelector("a[href='https://github.com/epam/JDI']"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        WebElement jdiGithub=chromeDriver.findElement(By.cssSelector("a[href='https://github.com/epam/JDI']"));
        assertEquals(jdiGithub.getAttribute("ui"), "link");
        assertEquals(jdiGithub.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        assertTrue(chromeDriver.findElement(By.cssSelector("#mCSB_1")).isDisplayed());

        //16 Assert that there is Footer
        assertTrue(chromeDriver.findElement(By.cssSelector(".footer-content.overflow")).isDisplayed());

        //17 Close Browser
        chromeDriver.close();
    }

    @Test(groups = {"smoke"})
    public void allSmokeTestsCopyTwo() {
        // TODO Please avoid code duplication
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

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
        WebElement homePage= chromeDriver.findElement(By.cssSelector("[href='index.html']"));
        homePage.isDisplayed();
        assertEquals(homePage.getText(), "HOME");
        WebElement contactForm=chromeDriver.findElement(By.cssSelector("[href='contacts.html']"));
        contactForm.isDisplayed();
        assertEquals(contactForm.getText(), "CONTACT FORM");
        WebElement service=chromeDriver.findElement(By.cssSelector("[data-toggle='dropdown']"));
        service.isDisplayed();
        assertEquals(service.getText(), "SERVICE");
        WebElement metalsAndColors=chromeDriver.findElement(By.cssSelector("[href='metals-colors.html']"));
        metalsAndColors.isDisplayed();
        assertEquals(metalsAndColors.getText(), "METALS & COLORS");

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
        WebElement subHeader=chromeDriver.findElement(By.cssSelector("a[href='https://github.com/epam/JDI']"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        WebElement jdiGithub=chromeDriver.findElement(By.cssSelector("a[href='https://github.com/epam/JDI']"));
        assertEquals(jdiGithub.getAttribute("ui"), "link");
        assertEquals(jdiGithub.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        assertTrue(chromeDriver.findElement(By.cssSelector("#mCSB_1")).isDisplayed());

        //16 Assert that there is Footer
        assertTrue(chromeDriver.findElement(By.cssSelector(".footer-content.overflow")).isDisplayed());

        //17 Close Browser
        chromeDriver.close();
    }

    @Test(groups = {"smoke"})
    public void allSmokeTestsCopyThree() {
        // TODO Please avoid code duplication
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

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
        WebElement homePage= chromeDriver.findElement(By.cssSelector("[href='index.html']"));
        homePage.isDisplayed();
        assertEquals(homePage.getText(), "HOME");
        WebElement contactForm=chromeDriver.findElement(By.cssSelector("[href='contacts.html']"));
        contactForm.isDisplayed();
        assertEquals(contactForm.getText(), "CONTACT FORM");
        WebElement service=chromeDriver.findElement(By.cssSelector("[data-toggle='dropdown']"));
        service.isDisplayed();
        assertEquals(service.getText(), "SERVICE");
        WebElement metalsAndColors=chromeDriver.findElement(By.cssSelector("[href='metals-colors.html']"));
        metalsAndColors.isDisplayed();
        assertEquals(metalsAndColors.getText(), "METALS & COLORS");

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
        WebElement subHeader=chromeDriver.findElement(By.cssSelector("a[href='https://github.com/epam/JDI']"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        WebElement jdiGithub=chromeDriver.findElement(By.cssSelector("a[href='https://github.com/epam/JDI']"));
        assertEquals(jdiGithub.getAttribute("ui"), "link");
        assertEquals(jdiGithub.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        assertTrue(chromeDriver.findElement(By.cssSelector("#mCSB_1")).isDisplayed());

        //16 Assert that there is Footer
        assertTrue(chromeDriver.findElement(By.cssSelector(".footer-content.overflow")).isDisplayed());

        //17 Close Browser
        chromeDriver.close();
    }
}
