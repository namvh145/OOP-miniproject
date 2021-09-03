package sentences;

import functions.FindingMinMax;
import objects.StockWithTotalValue;
import utils.CalculatingPercentageUtils;

import java.util.List;

public class TransactionPercentage extends FindingMinMax<StockWithTotalValue> {
    public TransactionPercentage(List<StockWithTotalValue> listOfObjects) {
        super(listOfObjects, "TotalValue", true);
    }

    private double processPercentage(StockWithTotalValue s) {
        long totalValue = 0;
        for (StockWithTotalValue o : listOfObjects) {
            totalValue += o.getMatchOrder().getValue();
        }
        return CalculatingPercentageUtils.calculatePercentage(s.getMatchOrder().getValue(), totalValue);
    }

    @Override
    public String print() {
        StockWithTotalValue largestTransactionValue = this.findMax();
        String str = String.format("Với giá khớp lệnh đạt %d đồng (giao động %d), cổ phiếu %s " +
                        "lại quay về thế chủ đạo trên thị trường, chiếm %f%% giá trị giao dịch.",
                largestTransactionValue.getMatchOrder().getValue(),
                largestTransactionValue.getMatchOrder().getFluctuate(),
                largestTransactionValue.getName(),
                this.processPercentage(largestTransactionValue));

        System.out.println(str);

        return str;
    }
}
