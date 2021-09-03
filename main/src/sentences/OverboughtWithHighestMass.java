package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class OverboughtWithHighestMass extends FindingMinMax<Stock> {
    public OverboughtWithHighestMass(List<Stock> listOfObjects) {
        super(listOfObjects, "OverBoughtMass", true);
    }

    @Override
    public String print() {
        Stock highestMassOverbought = this.findMax();
        String strInput = "Tâm điểm chú ý của thị trường vẫn là loại cổ phiếu có tính thanh khoản cao nhất %s-với mức dư mua tới %d đơn vị";
        String strOutput = String.format(strInput, highestMassOverbought.getName(), highestMassOverbought.getOverBought().getMass());
        System.out.println(strOutput);
        return strOutput;
    }
}
