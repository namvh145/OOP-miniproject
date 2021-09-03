package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class ThreeHottestSell extends FindingMinMax<Stock> {
    public ThreeHottestSell(List<Stock> stocks) {
        super(stocks, "TotalSum", true);
    }

    @Override
    public String print() {
        List<Stock> threeMaxStocks = find_N_Max(3);
        String str = String.format(
                "%s cũng là cổ phiếu được bán ra nhiều nhất với khối lượng lên đến %d đơn vị, tiếp " +
                        "theo là %s với %d và %s với %d đơn vị.",
                threeMaxStocks.get(0).getName(),
                threeMaxStocks.get(0).getMatchOrder().getSum(),
                threeMaxStocks.get(1).getName(),
                threeMaxStocks.get(1).getMatchOrder().getSum(),
                threeMaxStocks.get(2).getName(),
                threeMaxStocks.get(2).getMatchOrder().getSum()
        );

        System.out.println(str);
        return str;
    }
}
