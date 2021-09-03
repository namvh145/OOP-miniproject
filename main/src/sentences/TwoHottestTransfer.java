package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class TwoHottestTransfer extends FindingMinMax<Stock> {
    public TwoHottestTransfer(List<Stock> stocks) {
        super(stocks, "TotalSum", true);
    }

    @Override
    public String print() {
        List<Stock> hottestStock = find_N_Max(2);
        String str = String.format(
                "%s và %s tiếp tục là những cổ phiếu được chuyển nhượng nhiều nhất trên sàn HOSE " +
                        "với lượng khớp lần lượt đạt %d và %d chứng khoán.",
                hottestStock.get(0).getName(),
                hottestStock.get(1).getName(),
                hottestStock.get(0).getMatchOrder().getSum(),
                hottestStock.get(1).getMatchOrder().getSum()
        );

        System.out.println(str);
        return str;
    }
}
