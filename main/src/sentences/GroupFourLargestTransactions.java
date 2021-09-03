package sentences;

import functions.FindingMinMax;
import objects.StockWithTotalValue;

import java.util.List;

public class GroupFourLargestTransactions extends FindingMinMax<StockWithTotalValue> {
    public final double MONEY_UNIT = 1000000000;

    public GroupFourLargestTransactions(List<StockWithTotalValue> listOfObjects) {
        super(listOfObjects, "TotalValue", true);
    }

    @Override
    public String print() {
        String str = "Trong nhóm cổ phiếu giao dịch nhiều nhất, ngoài các gương mặt quen thuộc như %s, %s, %s có %s với khối lượng khớp tới %d cổ phiếu, giá trị %f tỷ đồng.";

        List<StockWithTotalValue> source = this.find_N_Max(4);
        String formattedStr = String.format(str, source.get(1).getName(), source.get(2).getName(), source.get(3).getName(),
                source.get(0).getName(), source.get(0).getMatchOrder().getMass(), source.get(0).getTotalValue() * 1.0 / MONEY_UNIT);

        System.out.println(formattedStr);

        return formattedStr;
    }
}
