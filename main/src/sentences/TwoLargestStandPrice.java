package sentences;

import functions.CalculatingStandPrice;
import functions.FindingMinMax;
import objects.Stock;

import java.util.Arrays;
import java.util.List;

public class TwoLargestStandPrice extends FindingMinMax<Stock> {
    public TwoLargestStandPrice(List<Stock> listOfObjects) {
        super(listOfObjects, "Mass", true);
    }

    @Override
    public String print() {
        List<Stock> listOfStock = this.find_N_Max(2);
        String strInput = "Hai cổ phiếu có vốn hóa lớn nhất thị trường là %s và %s %s giao dịch lần lượt từ %d đến %d đơn vị";
        final String[] strStandPrice = new String[1];
        CalculatingStandPrice calculatingStandPrice = new CalculatingStandPrice(listOfStock) {
            public void getStringStandPrice() {
                if (!isStandPrice(listOfStock.get(0)) && !isStandPrice(listOfStock.get(1))) {
                    strStandPrice[0] = "đều không đứng giá";
                } else strStandPrice[0] = "có đứng giá";
            }

            @Override
            public String print() {
                getStringStandPrice();
                return null;
            }
        };
        calculatingStandPrice.print();
        String strOutput = String.format(strInput, listOfStock.get(0).getName(), listOfStock.get(1).getName(), Arrays.toString(strStandPrice),
                listOfStock.get(0).getMatchOrder().getMass(), listOfStock.get(0).getMatchOrder().getMass());
        System.out.println(strOutput);
        return strOutput;
    }
}
