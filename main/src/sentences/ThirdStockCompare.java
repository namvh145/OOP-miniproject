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
public class ThirdStockCompare extends FindingMinMax<Stock> {
    public ThirdStockCompare(List<Stock> listOfObjects) {
        super(listOfObjects, "Mass", true);
    }

    @Override
    public String print() {
        Stock largestStock = this.findMax();
        Stock secondLargestStock = this.find_N_Max(2).get(1);
        String str = String.format("Trong đó trên thị trường tập trung, %s và %s chia nhau hai ngôi vị nhất nhì với lần lượt mức khớp lệnh %d và %d.",
                largestStock.getName(),
                secondLargestStock.getName(),
                largestStock.getMatchOrder().getMass(),
                secondLargestStock.getMatchOrder().getMass());
        return str;
    }

}
