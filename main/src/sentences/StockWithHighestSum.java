package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class StockWithHighestSum extends FindingMinMax<Stock> {
    public StockWithHighestSum(List<Stock> listOfObjects) {
        super(listOfObjects, "TotalSum", true);
    }

    @Override
    public String print() {
        Stock highestTotalSum = this.findMax();
        String strInput = "Tổng khối lượng giao dịch của %s trong buổi sáng đạt gần %d cổ phiếu và là một trong những mã giao dịch sôi động nhất sàn";
        String strOutput = String.format(strInput, highestTotalSum.getName(), highestTotalSum.getMatchOrder().getSum());
        System.out.println(strOutput);
        return strOutput;
    }
}
