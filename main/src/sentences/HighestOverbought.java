package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class HighestOverbought extends FindingMinMax<Stock> {
    public HighestOverbought(List<Stock> listOfObjects) {
        super(listOfObjects, "OverBought", true);
    }

    @Override
    public String print() {
        Stock largestOverbought = this.findMax();
        String strInput = "Cổ phiếu %s thuộc hàng dư mua lớn trên sàn, đã khớp trên %d cổ phiếu khi giao dịch chưa kết thúc";
        String strOutput = String.format(strInput, largestOverbought.getName(), largestOverbought.getOverBought().getMass());
        System.out.println(strOutput);
        return strOutput;
    }

}
