package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class SixHottest extends FindingMinMax<Stock> {
    public SixHottest(List<Stock> stocks) {
        super(stocks, "TotalSum", true);
    }

    @Override
    public String print() {
        List<Stock> hottestStock = find_N_Max(6);

        String str = String.format(
                "Xếp đầu bảng vẫn là %s với %d đồng khớp lệnh; kế đó có %s, %d; %s, %d " +
                        "%s, %d; %s %d và %s %d.",
                hottestStock.get(0).getName(),
                hottestStock.get(0).getMatchOrder().getSum(),
                hottestStock.get(1).getName(),
                hottestStock.get(1).getMatchOrder().getSum(),
                hottestStock.get(2).getName(),
                hottestStock.get(2).getMatchOrder().getSum(),
                hottestStock.get(3).getName(),
                hottestStock.get(3).getMatchOrder().getSum(),
                hottestStock.get(4).getName(),
                hottestStock.get(4).getMatchOrder().getSum(),
                hottestStock.get(5).getName(),
                hottestStock.get(5).getMatchOrder().getSum()
        );

        System.out.println(str);
        return str;
    }
}
