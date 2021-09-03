package sentences;

import functions.FindingMinMax;
import objects.Stock;
import utils.CalculatingPercentageUtils;

import java.util.List;

public class ThreeSmallestMass extends FindingMinMax<Stock> {

    public ThreeSmallestMass(List<Stock> listOfObjects) {
        super(listOfObjects, "Mass", false);
    }

    @Override
    public String print() {
        String str = "Trong khi đó, %s, %s và %s chiếm số lượng ít ỏi - tổng cộng chỉ có %d " +
                "cổ phiếu được chuyển nhượng, chiếm chưa tới %f%% giá trị toàn thị trường.";

        List<Stock> source = this.find_N_Min(3);

        long sumOfMass = 0L;
        for (Stock s : source) {
            sumOfMass += s.getMatchOrder().getMass();
        }

        String formattedStr = String.format(str, source.get(0).getName(), source.get(1).getName(), source.get(2).getName(),
                sumOfMass, CalculatingPercentageUtils.processMassPercentage(listOfObjects, sumOfMass));

        System.out.println(formattedStr);

        return formattedStr;
    }
}
