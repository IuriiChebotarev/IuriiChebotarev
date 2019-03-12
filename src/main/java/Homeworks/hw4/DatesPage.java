package Homeworks.hw4;

import base.hw4.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import Homeworks.hw4.enums.SlidersDirections;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DatesPage extends BasePage {

    @FindBy(css = "a.ui-slider-handle")
    private ElementsCollection slider;

    @FindBy(css = ".uui-slider")
    private SelenideElement sliderLine;

    @FindBy(css = ".panel-body-list.logs")
    private SelenideElement logsPanel;

    private Actions actions = new Actions(getWebDriver());

    public void moveSlider(SlidersDirections slidersDirections, int value) {
        // TODO Please try to avoid code duplication -- fixed
        actions.clickAndHold(slider.get(slidersDirections.index)).moveToElement(sliderLine,((sliderLine.getSize().width) * (value)/99),
                0).release().build().perform();
    }

    public void checkLogs(String direction, Integer value) {
        logsPanel.shouldHave(text("Range 2(" + direction + "):" + value + " link clicked"));
    }
}