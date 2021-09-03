package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class NegativeTwoLowestPrice extends FindingMinMax<Stock> {
    private static final Double MARGIN_OF_ERROR = 10000.0;

    public NegativeTwoLowestPrice(List<Stock> listOfObjects) {
        super(listOfObjects, "Values", false);
    }

    @Override
    public String print() {
        String strInput = "%s, %s tuy vẫn đạt thanh khoản trên %d cổ phiếu, nhưng có lúc được mua bán ở mức giá thấp";
        String atFloor = ", thậm chí là giá sàn";
        List<Stock> LowestPrice = this.find_N_Min(2);
        if (LowestPrice.get(0).getMatchOrder().getValue() >= (LowestPrice.get(0).getFloor() + MARGIN_OF_ERROR)
                || LowestPrice.get(0).getMatchOrder().getValue() <= (LowestPrice.get(0).getFloor() + MARGIN_OF_ERROR)) {
            strInput += atFloor;
        }
        String strOutput = String.format(strInput, LowestPrice.get(0).getName(), LowestPrice.get(1).getName(), LowestPrice.get(0).getMatchOrder().getMass());
        System.out.println(strOutput);
        return strOutput;
    }
}
