package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class FiveHottestTransaction extends FindingMinMax<Stock> {
    public FiveHottestTransaction(List<Stock> stocks) {
        super(stocks, "TotalSum", true);
    }

    @Override
    public String print() {
        List<Stock> topFiveStocks = find_N_Max(5);
        String str = String.format(
                "Top 5 cổ phiếu giao dịch nhiều nhất sàn HOSE gồm: %s, %s, %s, %s và %s, " +
                        "trong đó %s dẫn đầu với hơn %d cổ phiếu được mua bán",
                topFiveStocks.get(0).getName(),
                topFiveStocks.get(1).getName(),
                topFiveStocks.get(2).getName(),
                topFiveStocks.get(3).getName(),
                topFiveStocks.get(4).getName(),
                topFiveStocks.get(0).getName(),
                topFiveStocks.get(0).getMatchOrder().getSum()
        );

        System.out.println(str);
        return str;
    }
}
