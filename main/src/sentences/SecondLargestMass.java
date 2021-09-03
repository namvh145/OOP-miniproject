package sentences;

import functions.FindingMinMax;
import objects.Stock;
import utils.CalculatingPercentageUtils;
import utils.PrintingUtils;

import java.util.List;

public class SecondLargestMass extends FindingMinMax<Stock> {
    public SecondLargestMass(List<Stock> listOfObjects) {
        super(listOfObjects, "Mass", true);
    }

    @Override
    public String print() {
        Stock secondLargestMass = this.find_N_Max(2).get(1);
        double percent = CalculatingPercentageUtils.processMassPercentage(listOfObjects, secondLargestMass.getMatchOrder().getMass());
        String str = "Tiếp theo sau cổ phiếu đang dẫn đầu hiện nay là cổ phiếu %s với %d cổ phiếu (khoảng %f %%) đứng thứ 2";

        System.out.println(PrintingUtils.stringBigSum(str, secondLargestMass, percent));

        return PrintingUtils.stringBigSum(str, secondLargestMass, percent);
    }
}