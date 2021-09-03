/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentences;

import functions.FindingMinMax;

import java.util.List;

import objects.StockWithTotalValue;

/**
 * @author Thao
 */
public class ThirdStockWithTotalValue extends FindingMinMax<StockWithTotalValue> {
    public ThirdStockWithTotalValue(List<StockWithTotalValue> listOfObjects) {
        super(listOfObjects, "TotalValue", true);
    }

    @Override
    public String print() {
        StockWithTotalValue stockMax = this.findMax();
        String str = String.format("%s là cổ phiếu có giá trị giao dịch lớn nhất sàn HOSE trong phiên này.",
                stockMax.getName());
        return str;
    }

}
