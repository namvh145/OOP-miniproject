package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class GeneralIndicationFinalLargestTransaction extends FindingMinMax<Stock> {
    public final double STOCK_UNIT = 1000000000.0;

    public GeneralIndicationFinalLargestTransaction(List<Stock> listOfObjects) {
        super(listOfObjects, "TotalSum", true);
    }

    @Override
    public String print() {
        String str = "Tuy nhiên, kết phiên giao dịch buối sáng, %s mới là cổ phiếu được giao dịch thỏa thuận nhiều nhất," +
                " với hơn %f tỷ cổ phiếu";

        Stock source = this.findMax();
        String formattedStr = String.format(str, source.getName(), source.getMatchOrder().getSum() / STOCK_UNIT);

        System.out.println(formattedStr);

        return formattedStr;
    }
}
