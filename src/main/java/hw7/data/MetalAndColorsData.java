package hw7.data;

import hw7.enums.*;

// TODO Code convention !!
public class MetalAndColorsData {
    public int[] summary = {Radiobuttons.THREE.number,Radiobuttons.EIGHT.number};
    public String[] elements = {NatureElements.Water.name(), NatureElements.Fire.name()};
    public String color = Colors.Red.name();
    public String metals = Metals.Selen.name();
    public String[] vegetables = {Vegetables.Cucumber.name(),Vegetables.Tomato.name()};

    public String[] resultLog() {
        // TODO It will be better with List<String>
        String[] result = new String[5];
        result[0] = "Summary: " + (summary[0]+summary[1]);
        result[1] = "Elements: " + elements[0] +", "+ elements[1];
        result[2] = "Color: " + color;
        result[3] = "Metal: " + metals;
        result[4] = "Vegetables: " + vegetables[0]+", "+ vegetables[1];
        return result;
    }
}
