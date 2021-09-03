package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class GeneralIndicationWithMass extends FindingMinMax<Stock> {
    public GeneralIndicationWithMass(List<Stock> listOfObjects) {
        super(listOfObjects, "Mass", true);
    }

    @Override
    public String print() {
        String str = "Những cổ phiếu có khối lượng khớp lệnh lớn khác là BCC với 292.500 cổ phiếu, " +
                "KHP 113.600 cổ phiếu, TBC 66.400 cổ phiếu, NTP 60.300 cổ phiếu, VMC 58.000 cổ phiếu và ACB 54.000 cổ phiếu.";

        List<Stock> source = this.find_N_Max(10);
        String formattedStr = String.format(str, source.get(0).getName(), source.get(0).getMatchOrder().getMass(),
                source.get(1).getName(), source.get(1).getMatchOrder().getMass(),
                source.get(2).getName(), source.get(2).getMatchOrder().getMass(),
                source.get(3).getName(), source.get(3).getMatchOrder().getMass(),
                source.get(4).getName(), source.get(4).getMatchOrder().getMass());

        System.out.println(formattedStr);

        return formattedStr;
    }
}
