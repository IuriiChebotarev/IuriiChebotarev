package hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DatesPage{

    @FindBy(css = "a.ui-slider-handle:nth-child(1)")
    private SelenideElement leftSlider;

    @FindBy(css = "a.ui-slider-handle:nth-child(3)")
    private SelenideElement rightSlider;

    @FindBy(css = ".uui-slider")
    private SelenideElement sliderLine;

    @FindBy(css = ".panel-body-list.logs > li")
    private SelenideElement logsPanel;

    private Actions actions = new Actions(getWebDriver());

    public void moveLeftSlider(Integer value) {
        // TODO Please try avoid code duplication
        actions.clickAndHold(leftSlider).moveToElement(sliderLine,  ((sliderLine.getSize().width) * (value)/100 ),
                0).release().build().perform();
    }

    public void moveRightSlider(Integer value) {
        // TODO Please try avoid code duplication
        actions.clickAndHold(rightSlider).moveToElement(sliderLine, ((sliderLine.getSize().width) * (value)/100 ),
                0).release().build().perform();
    }

    public void checkLogs(String direction, Integer value) {
        logsPanel.shouldHave(Condition.text("Range 2(" + direction + "):" + value + " link clicked"));
    }
}