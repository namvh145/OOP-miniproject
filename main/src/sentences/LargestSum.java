package sentences;

import functions.FindingMinMax;
import objects.Stock;
import utils.PrintingUtils;

import java.util.List;

public class LargestSum extends FindingMinMax<Stock> {
    public LargestSum(List<Stock> stocks) {
        super(stocks, "TotalSum", true);
    }

    @Override
    public String print() {
        Stock hottestStock = findMax();

        String originalString = "Đầu tàu %s {0}{1} với tổng khối lượng khớp lệnh lớn nhất thị trường, %d cổ phiếu";

        String str = PrintingUtils.printFluctuate(originalString, hottestStock.getMatchOrder().getFluctuate(),
                hottestStock.getName(), hottestStock.getMatchOrder().getSum());

        System.out.println(str);
        return str;
    }
}
