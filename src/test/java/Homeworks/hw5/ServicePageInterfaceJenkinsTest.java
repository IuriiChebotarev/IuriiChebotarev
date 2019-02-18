package Homeworks.hw5;

import base.hw4.SelenideBase;
import hw5.AllureAttachmentListener;
import hw5.ElementsPageJenkins;
import hw5.HomePageJenkins;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static hw4.enums.Checkboxes.WATER;
import static hw4.enums.Checkboxes.WIND;
import static hw4.enums.Colors.YELLOW;
import static hw4.enums.HomePageData.HOME_PAGE_DATA;
import static hw4.enums.LogsMessages.CHECKBOX_LOG;
import static hw4.enums.LogsMessages.RADIOBUTTON_LOG;
import static hw4.enums.RadioButtons.SELEN;
import static hw4.enums.ServiceDropDown.DIFFERENT_ELEMENTS;
import static hw4.enums.ServiceDropDown.getServiceDropDownHeaders;
import static hw4.enums.Users.PETER;

@Listeners(AllureAttachmentListener.class)
public class ServicePageInterfaceJenkinsTest extends SelenideBase {

    private HomePageJenkins homePage;
    private ElementsPageJenkins elementsPage;

    @BeforeMethod
    public void beforeMethod() {

        //1.Open test site by URL
        open(HOME_PAGE_DATA.url);
        homePage = page(HomePageJenkins.class);
        elementsPage=page(ElementsPageJenkins.class);
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @Feature("Smoke")
    @Story("Service page test")
    @Test
    public void testServicePageInterface() {
        //2.Assert Browser title
        homePage.checkTitle(HOME_PAGE_DATA);

        //3.Perform login
        homePage.login(PETER);

        //4.Assert User name in the left-top side of screen that user is logged in
        homePage.checkUsername(PETER);

        //5.Click on "Service" subcategory in the header and check that drop down contains options

        homePage.clickOnServiceDropdownInHeader();
        homePage.checkServiceDropdownListInHeader(getServiceDropDownHeaders());

        //6.Click on Service subcategory in the left section and check that drop down contains options
        homePage.clickOnServiceDropdownInLeftMenu();
        homePage.checkServiceDropdownListInLeftMenu(getServiceDropDownHeaders());

        //7.Open through the header menu Service -> Different Elements Page
        homePage.clickOnServiceDropdownInHeader();
        homePage.selectPageInServiceDropdown(DIFFERENT_ELEMENTS);

        //8.Check interface on Different elements page, it contains all needed elements
        elementsPage.checkDifferentPageElements();

        //9.Assert that there is Right Section
        elementsPage.checkRightSection();

        //10.Assert that there is Left Section
        elementsPage.checkLeftSection();

        //11.Select checkboxes
        elementsPage.clickOnCheckbox(WATER);
        elementsPage.clickOnCheckbox(WIND);

        //12.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        elementsPage.checkCheckboxesLogs(WATER, true,CHECKBOX_LOG);
        elementsPage.checkCheckboxesLogs(WIND, true,CHECKBOX_LOG);


        //13.Select radio
        elementsPage.selectRadioButton(SELEN);

        //14.Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton
        elementsPage.checkRadiosLogs(SELEN, RADIOBUTTON_LOG);

        //15.Select in dropdown
        elementsPage.selectColorInDropdown(YELLOW);

        //16.Assert that for dropdown there is a log row and value is corresponded to the selected value
        elementsPage.checkDropdownLogs(YELLOW);

        //17.Unselect and assert checkboxes
        elementsPage.clickOnCheckbox(WATER);
        elementsPage.clickOnCheckbox(WIND);

        //18.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        elementsPage.checkCheckboxesLogs(WATER, false,CHECKBOX_LOG);
        elementsPage.checkCheckboxesLogs(WIND, false,CHECKBOX_LOG);
    }
}
