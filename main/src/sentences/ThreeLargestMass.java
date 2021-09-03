package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class ThreeLargestMass extends FindingMinMax<Stock> {
    public ThreeLargestMass(List<Stock> listOfObjects) {
        super(listOfObjects, "Mass", true);
    }

    @Override
    public String print() {
        List<Stock> source = this.find_N_Max(3);
        String str = "Lượng giao dịch hôm qua đã tăng mạnh, dẫn đầu là %s với %d cổ phiếu, %s là %d cổ phiếu và %s %d cổ phiếu";
        String formatedStr = String.format(str, source.get(0).getName(), source.get(0).getMatchOrder().getMass(),
                source.get(1).getName(), source.get(1).getMatchOrder().getMass(),
                source.get(2).getName(), source.get(2).getMatchOrder().getMass());

        System.out.println(formatedStr);

        return formatedStr;
    }
}
