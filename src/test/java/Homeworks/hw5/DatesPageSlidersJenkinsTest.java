package Homeworks.hw5;

import base.hw4.SelenideBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static Homeworks.hw4.enums.HomePageData.HOME_PAGE_DATA;
import static Homeworks.hw4.enums.ServiceDropDown.DATES;
import static Homeworks.hw4.enums.SlidersDirections.LEFT;
import static Homeworks.hw4.enums.SlidersDirections.RIGHT;
import static Homeworks.hw4.enums.Users.PETER;

@Listeners(AllureAttachmentListener.class)
public class DatesPageSlidersJenkinsTest extends SelenideBase {

    private HomePageJenkins homePage;
    private DatesPageJenkins datesPage;

    @BeforeMethod
    @Step
    public void beforeMethod() {

        //1.Open test site by URL
        open(HOME_PAGE_DATA.url);
        homePage = page(HomePageJenkins.class);
        datesPage = page(DatesPageJenkins.class);
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @Feature("Smoke")
    @Story("Dates page test")
    @Test
    public void testDatesPageSliders() {
        //2.Assert Browser title
        homePage.checkTitle(HOME_PAGE_DATA);

        //3.Perform login
        homePage.login(PETER);

        //4.Assert User name in the left-top side of screen that user is logged in
        homePage.checkUsername(PETER);

        //5.Open through the header menu Service -> Dates Page
        // TODO This method should be parametrized
        datesPage.clickOnServiceDropdownInHeader();
        datesPage.selectPageInServiceDropdown(DATES);

        //6.Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most right position
        datesPage.moveSlider(LEFT, 0);
        datesPage.moveSlider(RIGHT, 100);

        //7.Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogs("from", 0);
        datesPage.checkLogs("to", 100);

        //8.Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position
        datesPage.moveSlider(LEFT, 0);
        datesPage.moveSlider(RIGHT, 0);

        //9.Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogs("from", 0);
        datesPage.checkLogs("to", 0);

        //10.Using drag-and-drop set Range sliders. left sliders - the most right position, right slider - the most right position
        datesPage.moveSlider(LEFT, 100);
        datesPage.moveSlider(RIGHT, 100);

        //11.Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogs("to", 100);
        datesPage.checkLogs("to", 100);

        //12.Using drag-and-drop set Range sliders.
        datesPage.moveSlider(LEFT, 30);
        datesPage.moveSlider(RIGHT, 70);

        //13.Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogs("to", 70);
        datesPage.checkLogs("to", 100);
    }
}

