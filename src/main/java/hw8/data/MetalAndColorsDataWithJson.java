/*
package hw8.data;

import com.google.gson.Gson;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MetalAndColorsDataWithJson {
    public static final String PATH_TO_DATA_FILES="src/main/resources/";

    public int[] summary;
    public String[] elements;
    public String color;
    public String metals;
    public String vegetables;

    Gson g = new Gson();
    Data data = g.fromJson(PATH_TO_DATA_FILES, Data.class);

}





@DataProvider
public Iterator<String[]>loadDataFromFile()throws IOException{
        List<String[]>userData=new ArrayList<>();
        try(Scanner text=new Scanner(new File(PATH_TO_DATA_FILES+"user.data"))){
        int i=0;
        while(text.hasNext()){
        i++;

        String print=text.nextLine();

        if(i>1){
        userData.add(print.split(";"));
        }
        }
        }
        return userData.iterator();
        }

*/