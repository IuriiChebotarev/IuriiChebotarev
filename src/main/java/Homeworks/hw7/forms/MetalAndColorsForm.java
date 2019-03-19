package Homeworks.hw7.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.ui.html.common.Button;
import Homeworks.hw7.data.MetalAndColorsData;
// TODO This class should be parametrised by entity !
public class MetalAndColorsForm extends Form<MetalAndColorsData> {

    private SummaryForm summaryForm;

    @JDropdown(root = "div[ui=dropdown]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Droplist colors;

    @JDropdown(root = "div[ui=combobox]",
            value = "input",
            list = "li",
            expand = ".caret")
    public static Droplist metal;

    @JDropdown(root = "#salad-dropdown",
            value = ".dropdown-toggle",
            list = "li",
            expand = ".caret")
    public static Droplist vegetables;

    @FindBy(css = "#elements-checklist > p")
    public WebList elements;

    @FindBy(id = "submit-button")
    public Button submit;

    public void fillForm(MetalAndColorsData data) {

        calculateSummary(data.summary);
        selectElement(data.element);
        selectColor(data.color);
        selectMetal(data.metals);
        selectVegetable(data.vegetable);

    }

    private void calculateSummary(int[] radiobuttons) {

        summaryForm.calculate(radiobuttons);
        // TODO Where did you find this particular action in the script ?
    }

    private void selectElement(String[] element) {

        elements.select(element[0],element[1]);
    }

    private void selectColor (String color) {
        // TODO Take a look on IDEA warning !
        colors.select(color);
    }

    private void selectMetal (String metals) {

        metal.select(metals);
    }

    private void selectVegetable (String[] vegetable){
        vegetables.select(vegetables.getSelected());
        vegetables.select(vegetable[0]);
        vegetables.select(vegetable[1]);
    }

    public void submit () {

        submit.click();
    }
}
