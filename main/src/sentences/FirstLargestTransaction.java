package sentences;

import functions.FindingMinMax;
import objects.Stock;
import utils.PrintingUtils;

import java.util.List;

public class FirstLargestTransaction extends FindingMinMax<Stock> {
    public final int STOCK_UNIT = 1000000;
    public final int STOCK_VALUE_UNIT = 1000000000;

    public FirstLargestTransaction(List<Stock> listOfObjects) {
        super(listOfObjects, "TotalSum", true);
    }

    @Override
    public String print() {
        Stock firstLargestItem = this.findMax();
        String str = "Trong phiên hôm qua, %s gây đột biến với hai giao dịch thỏa thuận %f triệu cổ phiếu, trị giá hơn %f tỷ đồng.";

        System.out.println(PrintingUtils.stringBigTransaction(str, firstLargestItem, STOCK_UNIT, STOCK_VALUE_UNIT));

        return PrintingUtils.stringBigTransaction(str, firstLargestItem, STOCK_UNIT, STOCK_VALUE_UNIT);
    }
}
