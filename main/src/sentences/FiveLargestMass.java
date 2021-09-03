package sentences;

import functions.FindingMinMax;
import objects.Stock;
import utils.CalculatingPercentageUtils;

import java.util.List;

public class FiveLargestMass extends FindingMinMax<Stock> {
    public FiveLargestMass(List<Stock> listOfObjects) {
        super(listOfObjects, "Mass", true);
    }

    @Override
    public String print() {
        String str = "%s tiếp tục dẫn đầu về khối lượng giao dịch, với %d cổ phiếu khớp lệnh chiếm tới %f%% thị phần, tiếp đến là %s, %s, %s và %s";
        List<Stock> source = this.find_N_Max(5);
        double percent = CalculatingPercentageUtils.processMassPercentage(listOfObjects, source.get(0).getMatchOrder().getMass());
        String formattedStr = String.format(str, source.get(0).getName(), source.get(0).getMatchOrder().getMass(), percent,
                source.get(1).getName(), source.get(2).getName(),
                source.get(3).getName(), source.get(4).getName()
        );

        System.out.println(formattedStr);

        return formattedStr;
    }
}
