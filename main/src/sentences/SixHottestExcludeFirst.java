package sentences;

import functions.CalculatingBound;
import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class SixHottestExcludeFirst extends FindingMinMax<Stock> {
    public SixHottestExcludeFirst(List<Stock> stocks) {
        super(stocks, "TotalSum", true);
    }

    @Override
    public String print() {
        List<Stock> hottestStock = find_N_Max(7);

        CalculatingBound cbObj = new CalculatingBound(hottestStock) {
            @Override
            public String print() {
                return null;
            }
        };
        int boundValue = cbObj.calculateBound(6);

        String str = String.format(
                "%s vươn lên thứ 2 với %d cổ phiếu và hơn %d đồng, 4 cổ phiếu tiếp theo có khối " +
                        "lượng giao dịch trên %d cổ phiếu là %s, %s, %s và %s.",
                hottestStock.get(1).getName(),
                hottestStock.get(1).getMatchOrder().getSum(),
                hottestStock.get(1).getMatchOrder().getSum() * hottestStock.get(1).getMatchOrder().getValue(),
                boundValue,
                hottestStock.get(2).getName(),
                hottestStock.get(3).getName(),
                hottestStock.get(4).getName(),
                hottestStock.get(5).getName()
        );

        System.out.println(str);
        return str;
    }
}
