package sentences;

import functions.FindingMinMax;
import objects.Stock;
import utils.CalculatingPercentageUtils;

import java.util.List;

public class TwoLargestTransaction extends FindingMinMax<Stock> {
    public TwoLargestTransaction(List<Stock> listOfObjects) {
        super(listOfObjects, "Mass", true);
    }

    private double processPercentage(List<Stock> stocks) {
        double totalPercent = 0.0;
        for (Stock stock : stocks) {
            totalPercent += CalculatingPercentageUtils.processMassPercentage(listOfObjects, stock.getMatchOrder().getMass());
        }
        return totalPercent;
    }

    @Override
    public String print() {
        String str = "Ngoài ra, %s và %s cũng là 2 mã giao dịch nhiều nhất sàn với lượng khớp lên tới %f%% khối lượng toàn sàn.";
        List<Stock> source = this.find_N_Max(2);
        String formattedStr = String.format(str, source.get(0).getName(), source.get(1).getName(), this.processPercentage(source));

        System.out.println(formattedStr);

        return formattedStr;
    }
}
