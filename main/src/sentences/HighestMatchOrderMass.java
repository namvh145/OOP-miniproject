package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class HighestMatchOrderMass extends FindingMinMax<Stock> {
    public HighestMatchOrderMass(List<Stock> listOfObjects) {
        super(listOfObjects, "Mass", true);
    }


    @Override
    public String print() {
        Stock highestMass = this.findMax();
        String strInput = "Sức cầu mạnh nhất thuộc về %s với gần %d cổ phiếu đã được chuyển nhượng qua sàn với giá đóng cửa %d đồng.";
        String strOutput = String.format(strInput, highestMass.getName(), highestMass.getMatchOrder().getMass(), highestMass.getMatchOrder().getValue());
        System.out.println(strOutput);
        return strOutput;
    }
}
