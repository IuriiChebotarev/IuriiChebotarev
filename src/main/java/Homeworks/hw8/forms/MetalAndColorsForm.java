package Homeworks.hw8.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.ui.html.common.Button;
import Homeworks.hw8.data.MetalAndColorsData;

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
        selectElement(data.elements);
        selectColor(data.color);
        selectMetal(data.metals);
        selectVegetable(data.vegetables);

    }

    private void calculateSummary(int[] radiobuttons) {

        summaryForm.calculate(radiobuttons);

    }

    private void selectElement(String[] natureElement) {

        for (String element:natureElement){
        elements.select(element);
        }
    }

    private void selectColor (String color) {

        colors.select(color);
    }

    private void selectMetal (String metals) {

        metal.select(metals);
    }

    private void selectVegetable (String[] vegetable){

        vegetables.select(vegetables.getSelected());
        for (String element : vegetable) {
            vegetables.select(element);
        }
    }

    public void submit () {

        submit.click();
    }
}
