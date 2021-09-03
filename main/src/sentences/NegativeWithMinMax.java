package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class NegativeWithMinMax extends FindingMinMax<Stock> {
    public NegativeWithMinMax(List<Stock> listOfObjects) {
        super(listOfObjects, "Mass", true);
    }

    @Override
    public String print() {
        List<Stock> minStocks = this.find_N_Min(2);
        this.setDescendingOrder(false);
        Stock maxStock = this.findMax();
        String strInput = "Sức mua vẫn nhằm vào các blue-chip thanh khoản cao, nhưng duy nhất %s đạt %d cổ phiếu, trong khi %s, %s chỉ trên %d";
        String strOutput = String.format(strInput, maxStock.getName(), maxStock.getMatchOrder().getMass()
                , minStocks.get(0).getName(), minStocks.get(1).getName()
                , minStocks.get(0).getMatchOrder().getMass());
        System.out.println(strOutput);
        return strOutput;
    }
}
