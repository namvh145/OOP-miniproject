package sentences;

import functions.FindingMinMax;
import objects.StockWithTotalValue;

import java.util.List;

public class NegativeWithTwoHighestLiquidity extends FindingMinMax<StockWithTotalValue> {
    public NegativeWithTwoHighestLiquidity(List<StockWithTotalValue> listOfObjects) {
        super(listOfObjects, "TotalValue", true);
    }

    @Override
    public String print() {
        List<StockWithTotalValue> HighestLiquidity = this.find_N_Max(2);
        String strInput = "%s và %s là những mã có thanh khoán tốt nhất sàn, nhưng lượng chuyển nhượng cũng chỉ ở dưới mức %d cổ phiếu";
        String strOutput = String.format(strInput, HighestLiquidity.get(0).getName(), HighestLiquidity.get(1).getName(), HighestLiquidity.get(0).getMatchOrder().getMass());
        System.out.println(strOutput);
        return strOutput;
    }
}
