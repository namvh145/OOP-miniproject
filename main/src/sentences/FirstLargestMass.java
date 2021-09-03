package sentences;

import functions.FindingMinMax;
import objects.Stock;
import utils.CalculatingPercentageUtils;
import utils.PrintingUtils;

import java.util.List;

public class FirstLargestMass extends FindingMinMax<Stock> {
    public FirstLargestMass(List<Stock> listofObjects) {
        super(listofObjects, "Mass", true);
    }

    @Override
    public String print() {
        Stock firstLargestMass = this.findMax();
        double percent = CalculatingPercentageUtils.processMassPercentage(listOfObjects, firstLargestMass.getMatchOrder().getMass());
        String str = "Dẫn đầu thị trường về khối lượng giao dịch là cổ phiếu %s với %d cổ phiếu, chiếm tỷ trọng hơn %f%%";

        System.out.println(PrintingUtils.stringBigSum(str, firstLargestMass, percent));

        return PrintingUtils.stringBigSum(str, firstLargestMass, percent);
    }
}
