package Homeworks.hw4;

import base.hw4.SelenideBase;
import hw4.ElementsPage;
import hw4.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Selenide.page;
import static hw4.enums.Checkboxes.WATER;
import static hw4.enums.Checkboxes.WIND;
import static hw4.enums.Colors.YELLOW;
import static hw4.enums.HomePageData.HOME_PAGE_DATA;
import static hw4.enums.RadioButtons.SELEN;
import static hw4.enums.ServiceDropDown.*;
import static hw4.enums.Users.PETER;

public class ServicePageInterface extends SelenideBase {

    private HomePage homePage;
    private ElementsPage elementsPage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = new HomePage();
        elementsPage = new ElementsPage();

        //1.Open test site by URL
        homePage.open(HOME_PAGE_DATA);

        page(homePage);
        page(elementsPage);
    }

    @Test
    public void testServicePageInterface() {
        //2.Assert Browser title
        homePage.checkTitle(HOME_PAGE_DATA);

        //3.Perform login
        homePage.login(PETER);

        //4.Assert User name in the left-top side of screen that user is logged in
        homePage.checkUsername(PETER);

        //5.Click on "Service" subcategory in the header and check that drop down contains options
        List<String> serviceDropdownInHeader = new ArrayList<>();
        serviceDropdownInHeader.add(SUPPORT.text);
        serviceDropdownInHeader.add(DATES.text);
        serviceDropdownInHeader.add(COMPLEX_TABLE.text);
        serviceDropdownInHeader.add(SIMPLE_TABLE.text);
        serviceDropdownInHeader.add(TABLES_WITH_PAGE.text);
        serviceDropdownInHeader.add(DIFFERENT_ELEMENTS.text);

        homePage.checkServiceDropdownListInHeader(serviceDropdownInHeader);

        //6.Click on Service subcategory in the left section and check that drop down contains options
        List<String> serviceDropdownInLeftMenu = new ArrayList<>();
        serviceDropdownInLeftMenu.add(SUPPORT.text);
        serviceDropdownInLeftMenu.add(DATES.text);
        serviceDropdownInLeftMenu.add(COMPLEX_TABLE.text);
        serviceDropdownInLeftMenu.add(SIMPLE_TABLE.text);
        serviceDropdownInLeftMenu.add(TABLES_WITH_PAGE.text);
        serviceDropdownInLeftMenu.add(DIFFERENT_ELEMENTS.text);

        homePage.checkServiceDropdownListInLeftMenu(serviceDropdownInLeftMenu);

        //7.Open through the header menu Service -> Different Elements Page
        homePage.openDifferentElementsPage();

        //8.Check interface on Different elements page, it contains all needed elements
        elementsPage.checkDifferentPageElements();

        //9.Assert that there is Right Section
        elementsPage.checkRightSection();

        //10.Assert that there is Left Section
        elementsPage.checkLeftSection();

        //11.Select checkboxes
        elementsPage.clickOnWaterCheckbox();
        elementsPage.checkCheckboxesLogs(WATER, true);
        elementsPage.clickOnWindCheckbox();

        //12.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        elementsPage.checkCheckboxesLogs(WIND, true);

        //13.Select radio
        elementsPage.selectSelenRadio();

        //14.Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton
        elementsPage.checkRadiosLogs(SELEN);

        //15.Select in dropdown
        elementsPage.selectYellowInDropdown();

        //16.Assert that for dropdown there is a log row and value is corresponded to the selected value
        elementsPage.checkDropdownLogs(YELLOW);

        //17.Unselect and assert checkboxes
        elementsPage.clickOnWaterCheckbox();
        elementsPage.checkCheckboxesLogs(WATER, false);
        elementsPage.clickOnWindCheckbox();

        //18.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        elementsPage.checkCheckboxesLogs(WIND, false);
    }
}
