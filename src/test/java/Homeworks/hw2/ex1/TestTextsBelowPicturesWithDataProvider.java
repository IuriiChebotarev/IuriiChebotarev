package Homeworks.hw2.ex1;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;

// TODO Jave Code convention style
public class TestTextsBelowPicturesWithDataProvider extends SeleniumBase {
    private WebDriver chromeDriver;

    // TODO Is it possible to use @BeforeMethod?
    @BeforeClass()
    public void beforeClass() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
    }

    @DataProvider(parallel=true)
    private Object [][] dataProvider() {
        return new Object[][]{
                {0,"To include good practices\nand ideas from successful\nEPAM project"},
                {1,"To be flexible and\ncustomizable"},
                {2,"To be multiplatform"},
                {3,"Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}
        };
    }

    @Test (dataProvider="dataProvider")
    /* TODO
        1. What does i mean?
        2. What does s mean?
     */
    public void assertTexts(int i,String s) {
        chromeDriver.navigate().to("https://epam.github.io/JDI/");
        assertEquals(chromeDriver.findElements(By.cssSelector(".benefit-txt")).get(i).getText(), s);
    }

    @AfterClass()
    public void afterClass(){
        chromeDriver.close();
    }
}
