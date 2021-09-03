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
public class FirstStockWithTotalValue extends FindingMinMax<StockWithTotalValue> {
    public FirstStockWithTotalValue(List<StockWithTotalValue> listOfObjects) {
        super(listOfObjects, "TotalValue", true);
    }

    @Override
    public String print() {
        long totalValue = CalculatingValueUtils.calculateTotalValue(this.listOfObjects);
        StockWithTotalValue stockMax = this.findMax();
        String str = String.format("Tổng giá trị thị trường đạt %d VNĐ, trong đó cổ phiếu giao dịch nhiều nhất là %s.",
                totalValue,
                stockMax.getName());
        return str;
    }

}
