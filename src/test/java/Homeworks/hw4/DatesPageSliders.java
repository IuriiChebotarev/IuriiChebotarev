package Homeworks.hw4;

import base.hw4.SelenideBase;
import hw4.DatesPage;
import hw4.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.page;
import static hw4.enums.HomePageData.HOME_PAGE_DATA;
import static hw4.enums.Users.PETER;

public class DatesPageSliders extends SelenideBase {

    private HomePage homePage;
    private DatesPage datesPage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = new HomePage();

        //1.Open test site by URL
        homePage.open(HOME_PAGE_DATA);

        datesPage = new DatesPage();

        page(homePage);
        page(datesPage);
    }

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
        homePage.openDatesPage();

        //6.Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most right position
        datesPage.moveLeftSlider(0);
        datesPage.checkLogs("from", 0);
        datesPage.moveRightSlider(100);

        //7.Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogs("to", 100);

        //8.Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position
        datesPage.moveLeftSlider(0);
        datesPage.checkLogs("from", 0);
        datesPage.moveRightSlider(0);

        //9.Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogs("to", 0);

        //10.Using drag-and-drop set Range sliders. left sliders - the most right position, right slider - the most right position
        datesPage.moveRightSlider(100);
        datesPage.checkLogs("to", 100);
        datesPage.moveLeftSlider(100);

        //11.Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogs("from", 100);

        //12.Using drag-and-drop set Range sliders.
        datesPage.moveLeftSlider(30);
        datesPage.checkLogs("to", 100);
        datesPage.moveRightSlider(70);

        //13.Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogs("to", 70);
    }
}

