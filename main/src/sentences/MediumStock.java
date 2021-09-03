package sentences;

import functions.CalculatingBound;
import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class MediumStock extends FindingMinMax<Stock> {
    public MediumStock(List<Stock> stocks) {
        super(stocks, "TotalSum", true);
    }

    @Override
    public String print() {
        List<Stock> hottestStock = find_N_Max(9);
        CalculatingBound calculatingBound = new CalculatingBound(hottestStock) {
            @Override
            public String print() {
                return null;
            }
        };

        int bound = calculatingBound.calculateBound(8);
        String str = String.format(
                "Ngoài giao dịch sôi động của 2 cổ phiếu trên, có tới 6 loại khớp lệnh trên ngưỡng %d " +
                        "cổ phiếu là %s, %s, %s, %s, %s và %s.",
                bound,
                hottestStock.get(2).getName(),
                hottestStock.get(3).getName(),
                hottestStock.get(4).getName(),
                hottestStock.get(5).getName(),
                hottestStock.get(6).getName(),
                hottestStock.get(7).getName()
        );

        System.out.println(str);
        return str;
    }
}
