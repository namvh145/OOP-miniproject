package sentences;

import functions.FindingMinMax;
import objects.Stock;
import utils.CalculatingPercentageUtils;

import java.util.List;

public class OverboughtWithHighestPercentage extends FindingMinMax<Stock> {
    private final List<Stock> listOfObjects;

    public OverboughtWithHighestPercentage(List<Stock> listOfObjects) {
        super(listOfObjects, "OverBought", true);
        this.listOfObjects = listOfObjects;
    }

    public Double overBoughtPercentage(Stock largestOverbought) {
        double totalOverboughtValue = 0d;
        for (Stock stock : listOfObjects) {
            totalOverboughtValue += stock.getOverBought().getValue() * stock.getOverBought().getMass();
        }
        return CalculatingPercentageUtils.calculatePercentage(largestOverbought.getOverBought().getValue() * largestOverbought.getOverBought().getMass()
                , totalOverboughtValue);
    }

    @Override
    public String print() {
        Stock largestOverbought = this.findMax();
        String strInput = "Với khối lượng dư mua %d cổ phiếu, %s đang là cổ phiếu có tính thanh khoản tốt nhất hiện nay, giá trị giao dịch chiếm %f%% toàn thị trường";
        String strOutput = String.format(strInput, largestOverbought.getOverBought().getMass(), largestOverbought.getName(), overBoughtPercentage(largestOverbought));
        System.out.println(strOutput);
        return strOutput;
    }
}
