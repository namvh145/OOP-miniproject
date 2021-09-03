package sentences;

import functions.CalculatingStandPrice;
import functions.FindingMinMax;
import objects.Stock;
import utils.StringUtils;

import java.util.List;

public class StandPriceWithBound extends CalculatingStandPrice {
    public StandPriceWithBound(List<Stock> listOfObjects) {
        super(listOfObjects);
    }

    @Override
    public String print() {
        String strInput = "Một số mã khác trên sàn đứng giá như %s với khối lượng giao dịch chỉ dao động từ %d đến hơn %d cổ phiếu";
        List<Stock> listOfStandPrices = this.findListOfStandPrice();
        String strNameOfStandPrices = StringUtils.stringOfNames(listOfStandPrices);
        final Stock[] minStock = new Stock[1];
        final Stock[] maxStock = new Stock[1];
        FindingMinMax<Stock> findingMinMax = new FindingMinMax<Stock>(listOfStandPrices, "Mass", true) {
            public void getMinMax() {
                minStock[0] = this.findMin();
                maxStock[0] = this.findMax();
            }

            @Override
            public String print() {
                getMinMax();
                return null;
            }
        };
        findingMinMax.print();
        String strOutput = String.format(strInput, strNameOfStandPrices, minStock[0].getMatchOrder().getMass(), maxStock[0].getMatchOrder().getMass());
        System.out.println(strOutput);
        return strOutput;
    }
}
