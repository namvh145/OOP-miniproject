package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class TwoFirstLiquidity extends FindingMinMax<Stock> {
    public TwoFirstLiquidity(List<Stock> stocks) {
        super(stocks, "TotalSum", true);
    }

    @Override
    public String print() {
        List<Stock> hottestStock = find_N_Max(2);
        String str = String.format(
                "Hai cổ phiếu đứng đầu về tính thanh khoản là %s và %s giữ nguyên giá trị với khối " +
                        "lượng khớp lệnh lần lượt đạt %d và %d đơn vị",
                hottestStock.get(0).getName(),
                hottestStock.get(1).getName(),
                hottestStock.get(0).getMatchOrder().getSum(),
                hottestStock.get(1).getMatchOrder().getSum()
        );

        System.out.println(str);
        return str;
    }
}

