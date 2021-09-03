package sentences;

import functions.CalculatingStandPrice;
import objects.Stock;
import utils.StringUtils;

import java.util.List;

public class StandPriceWithCount extends CalculatingStandPrice {
    public StandPriceWithCount(List<Stock> listOfObjects) {
        super(listOfObjects);
    }

    @Override
    public String print() {
        List<Stock> listOfStandPrices = this.findListOfStandPrice();
        Stock st = listOfStandPrices.get(0);
        listOfStandPrices.remove(0);
        String strNameOfStandPrices = StringUtils.stringOfNames(listOfStandPrices);
        String strInput = "Đáng chú ý có tới %d cổ phiếu đứng giá trong đó có %s";
        String strOutput = String.format(strInput, listOfStandPrices.size() + 1, strNameOfStandPrices);
        strOutput += " " + st.getName() + ".";
        System.out.println(strOutput);
        return strOutput;
    }
}
