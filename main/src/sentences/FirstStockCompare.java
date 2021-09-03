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
public class FirstStockCompare extends FindingMinMax<Stock> {
    public FirstStockCompare(List<Stock> listOfObjects) {
        super(listOfObjects, "Mass", true);
    }

    @Override
    public String print() {
        Stock stockMax = this.findMax();
        this.setDescendingOrder(false);
        Stock stockMin = this.findMin();
        String str = String.format("Đáng chú ý, lượng khớp lệnh của %s đã cao hơn so với %s.",
                stockMax.getName(),
                stockMin.getName());
        return str;
    }

}
