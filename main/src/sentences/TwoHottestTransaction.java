package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class TwoHottestTransaction extends FindingMinMax<Stock> {
    public TwoHottestTransaction(List<Stock> stocks) {
        super(stocks, "TotalSum", true);
    }

    @Override
    public String print() {
        List<Stock> twoMaxStocks = find_N_Max(2);
        String str = String.format(
                "Các cổ phiếu có khối lượng giao dịch khớp lệnh lớn nhất phiên này là %s với khối lượng " +
                        "%d cổ phiếu, tiếp đến là %s với khối lượng %d cổ phiếu.",
                twoMaxStocks.get(0).getName(),
                twoMaxStocks.get(0).getMatchOrder().getSum(),
                twoMaxStocks.get(1).getName(),
                twoMaxStocks.get(1).getMatchOrder().getSum()
        );

        System.out.println(str);
        return str;
    }
}
