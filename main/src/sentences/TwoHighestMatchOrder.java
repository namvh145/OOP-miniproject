package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class TwoHighestMatchOrder extends FindingMinMax<Stock> {
    public TwoHighestMatchOrder(List<Stock> listOfObjects) {
        super(listOfObjects, "Mass", true);
    }

    @Override
    public String print() {
        List<Stock> twoHighestStock = this.find_N_Max(2);
        String strInput = "Cổ phiếu chứng khoán vẫn là tâm điểm, trong đó, %s có khối lượng chuyển nhượng dẫn đầu, với gần %d, %s khớp hơn %d cổ phiếu.";
        String strOutput = String.format(strInput, twoHighestStock.get(0).getName(), twoHighestStock.get(0).getMatchOrder().getMass(),
                twoHighestStock.get(1).getName(), twoHighestStock.get(1).getMatchOrder().getMass());
        System.out.println(strOutput);
        return strOutput;
    }
}
