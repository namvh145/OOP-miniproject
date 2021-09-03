package sentences;

import functions.FindingMinMax;
import objects.Stock;
import utils.CalculatingPercentageUtils;

import java.util.List;

public class ThreeLargestMassWithPercent extends FindingMinMax<Stock> {
    public ThreeLargestMassWithPercent(List<Stock> listOfObjects) {
        super(listOfObjects, "Mass", true);
    }

    @Override
    public String print() {
        List<Stock> maxMasses = this.find_N_Max(3);
        String strInput = "Đứng đầu về khối lượng giao dịch là %s, với %d cổ phiếu (chiếm %f%% tổng mức giao dịch toàn thị trường), kế đến là %s, %s";
        String strOutput = String.format(strInput, maxMasses.get(0).getName(), maxMasses.get(0).getMatchOrder().getMass(),
                CalculatingPercentageUtils.processMassPercentage(this.listOfObjects, maxMasses.get(0).getMatchOrder().getMass()),
                maxMasses.get(1).getName(), maxMasses.get(2).getName());
        System.out.println(strOutput);
        return strOutput;
    }
}
