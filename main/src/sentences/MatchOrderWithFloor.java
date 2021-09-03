package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class MatchOrderWithFloor extends FindingMinMax<Stock> {
    private static final Double MARGIN_OF_ERROR = 10000.0;

    public MatchOrderWithFloor(List<Stock> listOfObjects) {
        super(listOfObjects, "Values", false);
    }

    @Override
    public String print() {
        String strInput = "Giao dịch đáng chú ý nhất vào giữa phiên là việc %d cổ phiếu %s được chuyển nhượng thỏa thuận ở %s %d đồng một cổ phiếu.";
        Stock minValue = this.findMin();
        String strFloor;
        if (minValue.getMatchOrder().getValue() >= (minValue.getFloor() - MARGIN_OF_ERROR) &&
                minValue.getMatchOrder().getValue() <= minValue.getFloor() + MARGIN_OF_ERROR) {
            strFloor = "giá sàn";
        } else {
            strFloor = "giá";
        }

        String strOutput = String.format(strInput, minValue.getMatchOrder().getMass(), minValue.getName(), strFloor, minValue.getMatchOrder().getValue());
        System.out.println(strOutput);
        return strOutput;
    }
}
