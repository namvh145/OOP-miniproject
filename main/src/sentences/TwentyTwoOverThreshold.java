package sentences;

import functions.CalculatingBound;
import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class TwentyTwoOverThreshold extends FindingMinMax<Stock> {
    public TwentyTwoOverThreshold(List<Stock> stocks) {
        super(stocks, "TotalSum", true);
    }

    @Override
    public String print() {
        List<Stock> hottestStock = find_N_Max(23);
        CalculatingBound calculatingBound = new CalculatingBound(hottestStock) {
            @Override
            public String print() {
                return null;
            }
        };

        int bound = calculatingBound.calculateBound(22);
        String str = String.format(
                "Toàn sàn có đến 22 mã giao dịch trên %d cổ phiếu, trong đó %s, %s và " +
                        "%s dẫn đầu với %d-%d chứng khoán được sang tay.",
                bound,
                hottestStock.get(0).getName(),
                hottestStock.get(1).getName(),
                hottestStock.get(2).getName(),
                hottestStock.get(2).getMatchOrder().getSum(),
                hottestStock.get(0).getMatchOrder().getSum()
        );

        System.out.println(str);
        return str;
    }
}
