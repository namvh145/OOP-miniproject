package sentences;

import functions.FindingMinMax;
import objects.Stock;
import utils.PrintingUtils;

import java.util.List;

public class SecondLargestTransaction extends FindingMinMax<Stock> {
    public final double STOCK_UNIT = 1000000.00;
    public final double STOCK_VALUE_UNIT = 1000000000.00;

    public SecondLargestTransaction(List<Stock> listOfObjects) {
        super(listOfObjects, "TotalSum", true);
    }

    @Override
    public String print() {
        Stock secondLargestItem = this.find_N_Max(2).get(1);
        String str = "Cổ phiếu được giao dịch nhiều thứ hai là %s với khoảng %f triệu đơn vị, với trị giá khoảng %f tỷ đồng.";

        System.out.println(PrintingUtils.stringBigTransaction(str, secondLargestItem, STOCK_UNIT, STOCK_VALUE_UNIT));

        return PrintingUtils.stringBigTransaction(str, secondLargestItem, STOCK_UNIT, STOCK_VALUE_UNIT);
    }

}
