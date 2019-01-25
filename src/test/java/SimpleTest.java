import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class SimpleTest {

    @Test
    public void simleTest(){
        //1
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

        String handle= driver.getWindowHandle();
        driver.switchTo().window(handle);
        //2
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        //3
        assertEquals(driver.getTitle(),"Home Page");
        //4
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        driver.close();
    }
}
