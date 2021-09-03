package sentences;

import functions.FindingMinMax;
import objects.StockWithTotalValue;

import java.util.List;

public class HighestTotalValue extends FindingMinMax<StockWithTotalValue> {
    public HighestTotalValue(List<StockWithTotalValue> listOfObjects) {
        super(listOfObjects, "TotalValue", true);
    }

    @Override
    public String print() {
        StockWithTotalValue highestTotalValue = this.findMax();
        String strInput = "Tính chung toàn phiên, %s cũng khớp xong hơn %d chứng khoán và là một trong những mã có thanh khoản cao nhất sàn hôm nay";
        String strOutput = String.format(strInput, highestTotalValue.getName(), highestTotalValue.getMatchOrder().getMass());
        System.out.println(strOutput);
        return strOutput;
    }
}
