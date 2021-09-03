package utils;

import objects.Stock;

import java.text.MessageFormat;
import java.util.Arrays;

import static java.lang.Math.abs;

public class PrintingUtils {
    /*
    Extracting utilities to provide a good extraction for print method of sentences
     */
    public static String stringBigTransaction(String originalString, Stock ithLargestItem, double stock_unit, double stock_value_unit) {
        String name = ithLargestItem.getName();
        int numOfStocks = ithLargestItem.getMatchOrder().getSum();
        int totalValue = (int) (ithLargestItem.getMatchOrder().getValue() * numOfStocks);

        return String.format(originalString, name, numOfStocks * 1.0 / stock_unit, abs(totalValue * 1.0 / stock_value_unit));
    }

    public static String stringBigSum(String originalString, Stock ithLargestItem, double percent) {
        return String.format(
                originalString,
                ithLargestItem.getName(),
                ithLargestItem.getMatchOrder().getMass(),
                percent
        );
    }

    public static String printFluctuate(String originalString, Long fluctuate, Object... varArgs) {
        String str = String.format(originalString, Arrays.stream(varArgs).toArray());
        if (fluctuate != 0) {
            if (fluctuate > 0) {
                str = MessageFormat.format(str, "tăng", " " + fluctuate + " đồng");
            } else {
                str = MessageFormat.format(str, "giảm", " " + abs(fluctuate) + " đồng");
            }
        } else {
            str = MessageFormat.format(str, "không đổi", "");
        }
        return str;
    }
}
