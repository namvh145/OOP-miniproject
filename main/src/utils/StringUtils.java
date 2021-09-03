package utils;

import objects.Stock;

import java.util.List;

public class StringUtils {
    //Various functions that returns string use for printing
    public static String stringOfNames(List<Stock> listOfObjects) {
        //Pass in a list of stocks to get string of names of the stocks
        //Ex: NLA, NFA, fdw,
        StringBuilder strOutput = new StringBuilder();
        for (Stock stock : listOfObjects) {
            strOutput.append(stock.getName()).append(", ");
        }
        return strOutput.toString();
    }
}
