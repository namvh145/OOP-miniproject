package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class FiveLargestTransaction extends FindingMinMax<Stock> {
    public FiveLargestTransaction(List<Stock> listOfObjects) {
        super(listOfObjects, "Mass", true);
    }

    @Override
    public String print() {
        String str = "%s, %s, %s, %s và %s là 5 chứng khoán có khối lượng giao dịch " +
                "nhiếu nhất, đứng đầu với %d đơn vị giao dịch thành công.";
        List<Stock> source = this.find_N_Max(5);
        String formattedStr = String.format(str, source.get(0).getName(), source.get(1).getName(), source.get(2).getName(),
                source.get(3).getName(), source.get(4).getName(), source.get(0).getMatchOrder().getMass());

        System.out.println(formattedStr);

        return formattedStr;
    }
}
