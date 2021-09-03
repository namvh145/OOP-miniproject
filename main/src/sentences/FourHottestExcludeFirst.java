package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class FourHottestExcludeFirst extends FindingMinMax<Stock> {
    public FourHottestExcludeFirst(List<Stock> stocks) {
        super(stocks, "TotalSum", true);
    }

    @Override
    public String print() {
        List<Stock> hottestStock = find_N_Max(4);
        String str = String.format(
                "Đứng thứ hai là %s với %d đơn vị, các vị trí tiếp theo là %s, %s với khối lượng " +
                        "cổ phiếu được mua vào lần lượt là %d và %d đơn vị.",
                hottestStock.get(1).getName(),
                hottestStock.get(1).getMatchOrder().getSum(),
                hottestStock.get(2).getName(),
                hottestStock.get(3).getName(),
                hottestStock.get(2).getMatchOrder().getSum(),
                hottestStock.get(3).getMatchOrder().getSum()
        );

        System.out.println(str);
        return str;
    }
}
