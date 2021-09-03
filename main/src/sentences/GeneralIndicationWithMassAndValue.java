package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class GeneralIndicationWithMassAndValue extends FindingMinMax<Stock> {
    public GeneralIndicationWithMassAndValue(List<Stock> listOfObjects) {
        super(listOfObjects, "MassAndValue", true);
    }

    @Override
    public String print() {
        String str = "Trong đó, đáng chú ý là giao dịch thỏa thuận thành công của %s với khối lượng rất lớn %d " +
                "cổ phiếu với giá %d đồng và %s %d cổ phiếu với giá %d đồng";
        List<Stock> source = this.find_N_Max(2);
        String formattedStr = String.format(str,
                source.get(0).getName(), source.get(0).getMatchOrder().getMass(), source.get(0).getMatchOrder().getValue(),
                source.get(1).getName(), source.get(1).getMatchOrder().getMass(), source.get(1).getMatchOrder().getValue()
        );

        System.out.println(formattedStr);

        return formattedStr;
    }
}
