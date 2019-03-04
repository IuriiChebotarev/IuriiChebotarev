package hw7.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.base.HtmlRadioGroup;
import com.epam.jdi.light.ui.html.common.Button;
import java.util.Objects;
import static hw7.enums.Radiobuttons.getIndex;

public class SummaryForm extends Form {

    @FindBy(id = "odds-selector")
    public HtmlRadioGroup odds;

    @FindBy(id = "even-selector")
    public HtmlRadioGroup evens;

    @FindBy(id = "calculate-button")
    public Button calculate;

    public void setOdds(int odd) {
        this.odds.select(Objects.requireNonNull(getIndex(odd)));
    }

    public void setEven(int even) {
        this.evens.select(Objects.requireNonNull(getIndex(even)));
    }

}
