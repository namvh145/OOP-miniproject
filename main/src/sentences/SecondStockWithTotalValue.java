/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentences;

import functions.FindingMinMax;

import java.util.List;

import objects.StockWithTotalValue;
import utils.CalculatingValueUtils;

/**
 * @author Thao
 */
public class SecondStockWithTotalValue extends FindingMinMax<StockWithTotalValue> {
    private final int numberOfStocks = 5;

    public SecondStockWithTotalValue(List<StockWithTotalValue> listOfObjects) {
        super(listOfObjects, "TotalValue", true);
    }

    public int getNumberOfStocks() {
        return numberOfStocks;
    }

    @Override
    public String print() {
        long totalValue = CalculatingValueUtils.calculateTotalValue(this.listOfObjects);
        List<StockWithTotalValue> stocks = this.find_N_Max(numberOfStocks);
        StockWithTotalValue stMin = stocks.get(numberOfStocks - 1);
        stocks.remove(numberOfStocks - 1);

        String str = String.format("Tổng giá trị giao dịch của thị trường đạt %d VNĐ, trong đó có %d cổ phiếu giao dịch trên %d VNĐ là ",
                totalValue,
                numberOfStocks,
                stMin.getTotalValue());
        for (StockWithTotalValue st : stocks) {
            str += st.getName() + ", ";
        }
        str += stMin.getName() + ".";

        return str;
    }
}
