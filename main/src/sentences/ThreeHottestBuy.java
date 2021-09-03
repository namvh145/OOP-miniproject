package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class ThreeHottestBuy extends FindingMinMax<Stock> {
    public ThreeHottestBuy(List<Stock> stocks) {
        super(stocks, "TotalSum", true);
    }

    @Override
    public String print() {
        List<Stock> threeMaxStocks = find_N_Max(3);
        String str = String.format(
                "%s là mã được gom vào nhiều nhất theo hình thức khớp lệnh với %d đơn vị, tiếp " +
                        "sau là %s và %s với lần lượt %d và %d đơn vị",
                threeMaxStocks.get(0).getName(),
                threeMaxStocks.get(0).getMatchOrder().getSum(),
                threeMaxStocks.get(1).getName(),
                threeMaxStocks.get(2).getName(),
                threeMaxStocks.get(1).getMatchOrder().getSum(),
                threeMaxStocks.get(2).getMatchOrder().getSum()
        );

        System.out.println(str);
        return str;
    }
}
