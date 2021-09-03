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
public class FourthStockWithTotalValue extends FindingMinMax<StockWithTotalValue> {
    public FourthStockWithTotalValue(List<StockWithTotalValue> listOfObjects) {
        super(listOfObjects, "TotalValue", true);
    }

    @Override
    public String print() {
        long totalValue = CalculatingValueUtils.calculateTotalValue(this.listOfObjects);
        String str = String.format("Giao dịch thỏa thuận tăng mạnh với giá trị giao dịch %d cổ phiếu tổng cộng lên tới %d VNĐ.",
                this.listOfObjects.size(),
                totalValue);
        return str;
    }

}
