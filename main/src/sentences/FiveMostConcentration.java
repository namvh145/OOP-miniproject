package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class FiveMostConcentration extends FindingMinMax<Stock> {
    public FiveMostConcentration(List<Stock> stocks) {
        super(stocks, "TotalSum", true);
    }

    @Override
    public String print() {
        List<Stock> hottestStock = find_N_Max(5);
        String str = String.format(
                "Khối lượng và giá trị giao dịch tập trung vào 5 cổ phiếu là %s với %d cổ " +
                        "phiếu, %s %d cổ phiếu, %s %d cổ phiếu, %s %d cổ phiếu và %s %d " +
                        "cổ phiếu.",
                hottestStock.get(0).getName(),
                hottestStock.get(0).getMatchOrder().getSum(),
                hottestStock.get(1).getName(),
                hottestStock.get(1).getMatchOrder().getSum(),
                hottestStock.get(2).getName(),
                hottestStock.get(2).getMatchOrder().getSum(),
                hottestStock.get(3).getName(),
                hottestStock.get(3).getMatchOrder().getSum(),
                hottestStock.get(4).getName(),
                hottestStock.get(4).getMatchOrder().getSum()
        );

        System.out.println(str);
        return str;
    }
}
