package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class ThreeHottestTransaction extends FindingMinMax<Stock> {
    public ThreeHottestTransaction(List<Stock> stocks) {
        super(stocks, "TotalSum", true);
    }

    @Override
    public String print() {
        List<Stock> hottestStock = find_N_Max(3);
        String str = String.format(
                "3 cổ phiếu có khối lượng giao dịch lớn nhất vẫn là các cổ phiếu có tính thanh " +
                        "khoản cao nhất: %s dẫn đầu với %d cổ phiếu, %s %d cổ phiếu, %s %d cổ phiếu",
                hottestStock.get(0).getName(),
                hottestStock.get(0).getMatchOrder().getSum(),
                hottestStock.get(1).getName(),
                hottestStock.get(1).getMatchOrder().getSum(),
                hottestStock.get(2).getName(),
                hottestStock.get(2).getMatchOrder().getSum()
        );

        System.out.println(str);
        return str;
    }
}
