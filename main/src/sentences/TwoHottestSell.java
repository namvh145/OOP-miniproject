package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class TwoHottestSell extends FindingMinMax<Stock> {
    public TwoHottestSell(List<Stock> stocks) {
        super(stocks, "TotalSum", true);
    }

    @Override
    public String print() {
        List<Stock> twoMaxStocks = find_N_Max(2);
        String str = String.format(
                "Được bán ra nhiều nhất trong ngày là %s và %s với khối lượng lần lượt là %d và %d",
                twoMaxStocks.get(0).getName(),
                twoMaxStocks.get(1).getName(),
                twoMaxStocks.get(0).getMatchOrder().getSum(),
                twoMaxStocks.get(1).getMatchOrder().getSum()
        );

        System.out.println(str);
        return str;
    }
}
