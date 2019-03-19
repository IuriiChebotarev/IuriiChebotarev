package Homeworks.hw8.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.base.HtmlRadioGroup;
import com.epam.jdi.light.ui.html.common.Button;

import java.util.Objects;

import static Homeworks.hw7.enums.Radiobuttons.getIndex;

public class SummaryForm extends Form {

    @FindBy(id = "odds-selector")
    private HtmlRadioGroup odds;

    @FindBy(id = "even-selector")
    private HtmlRadioGroup evens;

    @FindBy(id = "calculate-button")
    public Button calculate;

    public void setOdds(int odd) {

        this.odds.select(Objects.requireNonNull(getIndex(odd)));
    }

    public void setEven(int even) {

        this.evens.select(Objects.requireNonNull(getIndex(even)));
    }

    public void calculate(int[] radiobuttons) {

        setOdds(radiobuttons[0]);
        setEven(radiobuttons[1]);
        calculate.click();
    }



}
