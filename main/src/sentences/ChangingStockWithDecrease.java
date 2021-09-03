package sentences;

import functions.ChangingStock;
import objects.Stock;

public class ChangingStockWithDecrease extends ChangingStock {
    public ChangingStockWithDecrease(Stock stockBefore, Stock stockNow) {
        super(stockBefore, stockNow);
    }

    @Override
    public String print() {
        String strInput = "Phiên giao dịch diễn ra với áp lực khá mạnh và có thời điểm %s mất hơn %d điểm";
        String strOutput;
        String case0 = "Phiên giao dịch diễn ra với áp lực khá mạnh tuy vậy %s không mất điểm";
        long changedValue = this.calculateValueChange();
        if (changedValue != 0) {
            strOutput = String.format(strInput, this.getStockBefore().getName(), changedValue);
        } else {
            strInput = "Phiên giao dịch diễn ra với áp lực khá mạnh tuy vậy %s không mất điểm";
            strOutput = String.format(strInput, this.getStockBefore().getName());
        }
        System.out.println(strOutput);
        return strOutput;
    }
}
