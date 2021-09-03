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
public class FifthStockWithTotalValue extends FindingMinMax<StockWithTotalValue> {
    private final int numberOfStocks = 5;

    public FifthStockWithTotalValue(List<StockWithTotalValue> listOfObjects) {
        super(listOfObjects, "TotalValue", true);
    }

    public int getNumberOfStocks() {
        return numberOfStocks;
    }

    @Override
    public String print() {
        List<StockWithTotalValue> stocks = this.find_N_Max(numberOfStocks);
        long totalValue = CalculatingValueUtils.calculateTotalValue(this.listOfObjects);
        StockWithTotalValue stMin = stocks.get(numberOfStocks - 1);
        stocks.remove(numberOfStocks - 1);

        String str = String.format("Trong khi đó top %d cổ phiếu đóng góp nhiều nhất trong tổng số %d VNĐ giá trị khớp lệnh bao gồm ",
                numberOfStocks,
                totalValue);
        for (StockWithTotalValue st : stocks) {
            str += st.getName() + ", ";
        }
        str += stMin.getName() + ".";
        return str;
    }

}
