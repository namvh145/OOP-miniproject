/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentences;

import functions.FindingMinMax;

import java.util.List;

import objects.Stock;

/**
 * @author Thao
 */
public class FifthStockCompare extends FindingMinMax<Stock> {
    public FifthStockCompare(List<Stock> listOfObjects) {
        super(listOfObjects, "TotalSum", true);
    }

    @Override
    public String print() {
        Stock largestStock = this.findMax();
        Stock secondLargestStock = this.find_N_Max(2).get(1);
        String str = String.format("Giao dịch thỏa thuận trên sàn HOSE trong phiên vừa qua, %s đã vượt %s để trở thành cổ phiếu được khớp lệnh nhiều nhất với tổng khớp lệnh %d.",
                largestStock.getName(),
                secondLargestStock.getName(),
                largestStock.getMatchOrder().getSum());
        return str;
    }

}
