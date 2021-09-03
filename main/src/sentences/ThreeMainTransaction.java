package sentences;

import functions.FindingMinMax;
import objects.StockWithTotalValue;
import utils.CalculatingPercentageUtils;

import java.util.ArrayList;
import java.util.List;

public class ThreeMainTransaction extends FindingMinMax<StockWithTotalValue> {
    private List<StockWithTotalValue> source = new ArrayList<>();

    public ThreeMainTransaction(List<StockWithTotalValue> listOfObjects) {
        super(listOfObjects, "totalValue", true);
    }

    public List<StockWithTotalValue> getSource() {
        return source;
    }

    public void setSource(List<StockWithTotalValue> source) {
        this.source = source;
    }

    private double sumPercentage() {
        double totalPercentage = 0.0;
        for (StockWithTotalValue s : source) {
            totalPercentage += CalculatingPercentageUtils.processTotalValuePercentage(listOfObjects, s.getTotalValue());
        }
        return totalPercentage;
    }

    @Override
    public String print() {
        source = this.find_N_Max(3);
        String str = String.format("%s, %s và %s là các cổ phiếu được giao dịch chủ yếu trong phiên - riêng 3 loại này chiếm tới %f %% giá trị giao dịch toàn thị trường",
                source.get(0).getName(),
                source.get(1).getName(),
                source.get(2).getName(),
                this.sumPercentage()
        );

        System.out.println(str);

        return str;
    }
}
