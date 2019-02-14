package Homeworks.hw2.ex1;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;
// TODO Jave Code convention style--?
public class TextsBelowPicturesWithDataProvider extends SeleniumBase {
    private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    // TODO Is it possible to use @BeforeMethod?--No it is not possible. 4 browser windows will be opened but testing will be performed only in one
    // TODO Ok. 4 browser windows. How to make test run in all browsers in parallel mode?@BeforeMethod()
    @BeforeMethod
    public void beforeMethod() {
        WebDriver driver = new ChromeDriver();
        drivers.set(driver);
    }

    @DataProvider(parallel = true)
    private Object[][] dataProvider() {
        return new Object[][]{
                {0, "To include good practices\nand ideas from successful\nEPAM project"},
                {1, "To be flexible and\ncustomizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}
        };
    }

    @Test(dataProvider = "dataProvider")
    // TODO textNumder - I guess should be textNumber--FIXED
    // TODO int textNumder,String text - missing space--FIXED
    public void assertTexts(int textNumber, String text) {
        driver().navigate().to("https://epam.github.io/JDI/");
        assertEquals(driver().findElements(By.cssSelector(".benefit-txt")).get(textNumber).getText(), text);
    }

    @AfterMethod()
    public void afterMethod() {
        driver().close();
    }

    private WebDriver driver() {
        WebDriver driver = drivers.get();
        if (driver == null) {
            throw new IllegalStateException("Driver should have not been null.");
        }
        return driver;
    }
}



