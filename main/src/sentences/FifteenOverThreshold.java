package sentences;

import functions.CalculatingBound;
import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class FifteenOverThreshold extends FindingMinMax<Stock> {
    public FifteenOverThreshold(List<Stock> stocks) {
        super(stocks, "TotalSum", true);
    }

    @Override
    public String print() {
        List<Stock> hottestStock = find_N_Max(16);
        CalculatingBound calculatingBound = new CalculatingBound(hottestStock) {
            @Override
            public String print() {
                return null;
            }
        };

        int bound = calculatingBound.calculateBound(15);
        String str = String.format(
                "Tâm điểm thị trường vẫn hướng vào %s với lượng cổ phiếu chuyển nhượng cao chưa " +
                        "từng có, %d cổ phiếu và đến 15 mã giao dịch vọt lên %d cổ phiếu",
                hottestStock.get(0).getName(),
                hottestStock.get(0).getMatchOrder().getSum(),
                bound
        );

        System.out.println(str);
        return str;
    }
}

