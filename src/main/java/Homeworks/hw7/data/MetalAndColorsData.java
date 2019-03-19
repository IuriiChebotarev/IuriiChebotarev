package Homeworks.hw7.data;

import Homeworks.hw7.enums.*;
import java.util.ArrayList;
import java.util.List;
// TODO Code convention !!
public class MetalAndColorsData {

    public int[] summary = {Radiobuttons.THREE.number,Radiobuttons.EIGHT.number};
    public String[] element = {NatureElements.Water.name(), NatureElements.Fire.name()};
    public String color = Colors.Red.name();
    public String metals = Metals.Selen.name();
    public String[] vegetable = {Vegetables.Cucumber.name(),Vegetables.Tomato.name()};

    public List<String> resultLog() {
        // TODO It will be better with List<String>
        List<String> result = new ArrayList<>();
        result.add(0,"Summary: " + (summary[0]+summary[1]));
        result.add(1,"Elements: " + element[0] +", "+ element[1]);
        result.add(2,"Color: " + color);
        result.add(3,"Metal: " + metals);
        result.add(4,"Vegetables: " + vegetable[0]+", "+ vegetable[1]);
        return result;
    }
}
