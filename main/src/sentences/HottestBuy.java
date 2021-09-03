package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class HottestBuy extends FindingMinMax<Stock> {
    public HottestBuy(List<Stock> stocks) {
        super(stocks, "TotalSum", true);
    }

    @Override
    public String print() {
        Stock hottestStock = findMax();
        String str = String.format(
                "Cổ phiếu %s dẫn đầu về lượng mua vào với %d đơn vị, với giá trị trên %d đồng",
                hottestStock.getName(),
                hottestStock.getMatchOrder().getSum(),
                hottestStock.getMatchOrder().getSum() * hottestStock.getMatchOrder().getValue()
        );

        System.out.println(str);
        return str;
    }
}
