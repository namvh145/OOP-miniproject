package sentences;

import functions.FindingMinMax;
import objects.StockWithTotalValue;
import utils.CalculatingPercentageUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class TwoLargestTotalValue extends FindingMinMax<StockWithTotalValue> {
    public final int VALUE_UNIT = 1000000000;

    public TwoLargestTotalValue(List<StockWithTotalValue> listOfObjects) {
        super(listOfObjects, "TotalValue", true);
    }

    @Override
    public String print() {
        String str = "Đáng chú ý nhất phiên hôm nay là hai cổ phiếu %s và %s được giao dịch với khối lượng khá lớn với tổng giá trị hơn %s tỷ đồng, bằng %f%% thị trường.";
        List<StockWithTotalValue> source = this.find_N_Max(2);
        BigDecimal sumOfTotalValue = new BigDecimal("0.00");
        for (StockWithTotalValue stock : source) {
            sumOfTotalValue = sumOfTotalValue.add(new BigDecimal(String.valueOf(stock.getTotalValue())));
        }
        double percent = CalculatingPercentageUtils.processTotalValuePercentageWithBigInteger(listOfObjects, sumOfTotalValue.abs());
        String formattedStr = String.format(str, source.get(0).getName(), source.get(1).getName(),
                sumOfTotalValue.divide(new BigDecimal(String.valueOf(VALUE_UNIT)), 8, RoundingMode.CEILING).abs(), percent);

        System.out.println(formattedStr);

        return formattedStr;
    }
}
