package Homeworks.hw8.data;

import java.util.ArrayList;
import java.util.List;

public class MetalAndColorsData {

    public int[] summary;
    public String[] elements;
    public String color;
    public String metals;
    public String[] vegetables;

    public List<String> resultLog() {

        List<String> result = new ArrayList<>();
        String delimiter = ", ";
        result.add(0,"Summary: " + (summary[0]+summary[1]));
        result.add(1,"Elements: " + String.join(delimiter, elements));
        result.add(2,"Color: " + color);
        result.add(3,"Metal: " + metals);
        result.add(4,"Vegetables: " + String.join(delimiter, vegetables));
        return result;
    }
}
