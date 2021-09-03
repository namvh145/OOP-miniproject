package sentences;

import functions.FindingMinMax;
import objects.StockWithTotalValue;
import utils.CalculatingPercentageUtils;

import java.util.List;

public class FourLargestTotalValue extends FindingMinMax<StockWithTotalValue> {
    public FourLargestTotalValue(List<StockWithTotalValue> listOfObjects) {
        super(listOfObjects, "TotalValue", true);
    }

    @Override
    public String print() {
        String str = "Cổ phiếu đứng đầu về giá trị giao dịch trong phiên hôm nay là %s, " +
                "chiếm %f%% giá trị giao dịch toàn thị trường, tiếp theo là %s (%f%%), %s (%f%%), %s (%f%%).";

        List<StockWithTotalValue> source = this.find_N_Max(4);

        String formattedStr = String.format(str,
                source.get(0).getName(), CalculatingPercentageUtils.processTotalValuePercentage(listOfObjects, source.get(0).getTotalValue()),
                source.get(1).getName(), CalculatingPercentageUtils.processTotalValuePercentage(listOfObjects, source.get(1).getTotalValue()),
                source.get(2).getName(), CalculatingPercentageUtils.processTotalValuePercentage(listOfObjects, source.get(2).getTotalValue()),
                source.get(3).getName(), CalculatingPercentageUtils.processTotalValuePercentage(listOfObjects, source.get(3).getTotalValue()));

        System.out.println(formattedStr);

        return formattedStr;
    }
}
