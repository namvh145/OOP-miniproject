package sentences;

import functions.FindingMinMax;
import objects.Stock;
import utils.CalculatingPercentageUtils;

import java.util.List;

public class ThreeLargestMassWithPercentage extends FindingMinMax<Stock> {
    public ThreeLargestMassWithPercentage(List<Stock> listOfObjects) {
        super(listOfObjects, "Mass", true);
    }

    private int processBound(int s) {
        int bound = 1;
        while (bound < s) {
            bound = bound * 10;
        }
        return bound;
    }

    private double processPercent(List<Stock> source) {
        long sumOfMass = 0L;
        for (Stock s : source) {
            sumOfMass += s.getMatchOrder().getMass();
        }
        return CalculatingPercentageUtils.processMassPercentage(listOfObjects, sumOfMass);
    }

    @Override
    public String print() {
        String str = "3 cổ phiếu khác có khối lượng giao dịch trên %d và góp khoảng %f%% vào giá trị khớp lệnh là %s %d cổ phiếu, %s %d cổ phiếu và %s %d cổ phiếu.";
        List<Stock> source = this.find_N_Max(3);
        int bound = this.processBound(source.get(2).getMatchOrder().getMass());

        String formattedStr = String.format(str, bound, this.processPercent(source),
                source.get(0).getName(), source.get(0).getMatchOrder().getMass(),
                source.get(1).getName(), source.get(1).getMatchOrder().getMass(),
                source.get(2).getName(), source.get(2).getMatchOrder().getMass());

        System.out.println(formattedStr);

        return formattedStr;
    }
}
