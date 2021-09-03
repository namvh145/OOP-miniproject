package sentences;

import functions.FindingMinMax;
import objects.StockWithTotalValue;
import utils.CalculatingPercentageUtils;

import java.util.List;

public class SmallestLiquidity extends FindingMinMax<StockWithTotalValue> {
    public SmallestLiquidity(List<StockWithTotalValue> listOfObjects) {
        super(listOfObjects, "TotalValue", false);
    }

    @Override
    public String print() {
        String str = "Dù vậy, %s vẫn được xem là mã có thanh khoản thấp nhất do lượng giao dịch chỉ chiếm %f%% trên tổng khối lượng chung toàn ngành.";

        StockWithTotalValue source = this.findMin();
        String formattedStr = String.format(str, source.getName(), CalculatingPercentageUtils.processTotalValuePercentage(listOfObjects, source.getTotalValue()));

        System.out.println(formattedStr);

        return formattedStr;
    }
}
