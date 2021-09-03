package sentences;

import functions.FindingMinMax;
import objects.Stock;
import utils.PrintingUtils;

import java.util.List;

public class TwoLargestMassTransfer extends FindingMinMax<Stock> {
    public TwoLargestMassTransfer(List<Stock> stocks) {
        super(stocks, "TotalSum", true);
    }

    @Override
    public String print() {
        List<Stock> hottestStock = find_N_Max(2);

        String originalString = "%s dẫn đầu thị trường về khối lượng giao dịch với %d cổ phiếu, giá {0}{1}, " +
                "%s cũng được nhiều nhà đầu tư quan tâm với %d cổ phiếu khớp lệnh";

        String str = PrintingUtils.printFluctuate(originalString, hottestStock.get(0).getMatchOrder().getFluctuate(),
                hottestStock.get(0).getName(), hottestStock.get(0).getMatchOrder().getSum(),
                hottestStock.get(1).getName(), hottestStock.get(1).getMatchOrder().getSum());


        System.out.println(str);
        return str;
    }
}
