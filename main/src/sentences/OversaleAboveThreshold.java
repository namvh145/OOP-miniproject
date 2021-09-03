package sentences;

import functions.CalculatingStandPrice;
import objects.Stock;

import java.util.List;

public class OversaleAboveThreshold extends CalculatingStandPrice {
    public final int THRESHOLD = 200000;

    public OversaleAboveThreshold(List<Stock> listOfObjects) {
        super(listOfObjects);
    }

    public String stringOfStocks() {
        StringBuilder strOfStocks = new StringBuilder();
        for (Stock stock : this.listOfObjects) {
            if (stock.getOverSale().getMass() >= THRESHOLD)
                strOfStocks.append(stock.getName()).append(", ");
        }
        return strOfStocks.toString();
    }

    @Override
    public String print() {
        String strInput = "Sàn chứng kiến việc bán sàn mạnh các cổ phiếu lớn như %s với dư bán có lúc lên tới hơn %d cổ phiếu.";
        String strOutput = String.format(strInput, stringOfStocks(), THRESHOLD);
        System.out.println(strOutput);
        return strOutput;
    }
}
