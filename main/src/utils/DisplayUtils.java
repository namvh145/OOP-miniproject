package utils;

import objects.Stock;

import java.util.List;
import java.util.Random;

public class DisplayUtils {
    public static Stock[] SelectFromToStocks(List<Stock> fromStocks, List<Stock> toStocks) {
        Stock[] result = new Stock[2];
        int upperBound = Math.min(fromStocks.size(), toStocks.size());
        Random rand = new Random();
        System.out.println(upperBound);
        int int_random = rand.nextInt(upperBound);
        System.out.println(int_random);
        while (result[1] == null) {
            result[0] = fromStocks.get(int_random);
            result[1] = toStocks.stream().filter(toStock -> fromStocks.get(int_random).getName().equals(toStock.getName()))
                    .findAny().orElse(null);
        }
        return result;
    }
}
