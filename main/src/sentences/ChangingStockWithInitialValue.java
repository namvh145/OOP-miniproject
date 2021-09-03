package sentences;

import functions.ChangingStock;
import objects.Stock;

public class ChangingStockWithInitialValue extends ChangingStock {
    public ChangingStockWithInitialValue(Stock stockBefore, Stock stockNow) {
        super(stockBefore, stockNow);
    }

    @Override
    public String print() {
        String strInput = "Mở của phiên giao dịch, %s tiếp tục %s %d điểm sau khi %s %d điểm";
        String strOutput;
        String changedValueString1;
        String changedValueString2;
        long changedValue = this.calculateValueChange();
        if (changedValue > 0) {
            changedValueString1 = "tăng lên";
            changedValueString2 = "tăng";
            strOutput = String.format(strInput, this.getStockBefore().getName(), changedValueString1,
                    this.getStockNow().getMatchOrder().getValue(), changedValueString2, changedValue);
        } else if (changedValue < 0) {
            changedValueString1 = "giảm về";
            changedValueString2 = "giảm";
            changedValue = -changedValue;
            strOutput = String.format(strInput, this.getStockBefore().getName(), changedValueString1,
                    this.getStockNow().getMatchOrder().getValue(), changedValueString2, changedValue);
        } else {
            strInput = "Mở của phiên giao dịch, %s tiếp tục giữ nguyên giá trị";
            strOutput = String.format(strInput, this.getStockBefore().getName());
        }
        System.out.println(strOutput);
        return strOutput;
    }
}
