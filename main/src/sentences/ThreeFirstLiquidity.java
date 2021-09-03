package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class ThreeFirstLiquidity extends FindingMinMax<Stock> {
    public ThreeFirstLiquidity(List<Stock> stocks) {
        super(stocks, "TotalSum", true);
    }

    @Override
    public String print() {
        List<Stock> hottestStock = find_N_Max(3);
        String str = String.format(
                "%s tiếp tục dẫn đầu về tính thanh khoản với %d cổ phiếu được mua bán trong phiên, " +
                        "%s đứng thứ 2 với %d cổ phiếu và %s xếp thứ 3 với %d cổ phiếu",
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
