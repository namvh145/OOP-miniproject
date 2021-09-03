package sentences;

import functions.CalculatingBound;
import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class ThreeFirstThreeSecond extends FindingMinMax<Stock> {
    public ThreeFirstThreeSecond(List<Stock> stocks) {
        super(stocks, "TotalSum", true);
    }

    @Override
    public String print() {
        List<Stock> hottestStock = find_N_Max(7);
        CalculatingBound calculatingBound = new CalculatingBound(hottestStock) {
            @Override
            public String print() {
                return null;
            }
        };

        int bound = calculatingBound.calculateBound(6);
        String str = String.format(
                "3 cổ phiếu dẫn đầu thị trường là %s (%d), %s (%d), %s (%d CP), 3 vị trí " +
                        "tiếp theo cũng đều có khối lượng trên mức %d CP gồm: %s (%d CP), %s (%d " +
                        "CP) và %s (%d CP).",
                hottestStock.get(0).getName(),
                hottestStock.get(0).getMatchOrder().getSum(),
                hottestStock.get(1).getName(),
                hottestStock.get(1).getMatchOrder().getSum(),
                hottestStock.get(2).getName(),
                hottestStock.get(2).getMatchOrder().getSum(),
                bound,
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
