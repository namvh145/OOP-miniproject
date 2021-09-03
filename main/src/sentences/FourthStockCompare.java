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
public class FourthStockCompare extends FindingMinMax<Stock> {
    public FourthStockCompare(List<Stock> listOfObjects) {
        super(listOfObjects, "TotalSum", true);
    }

    @Override
    public String print() {
        Stock st = this.findMax();
        String str = String.format("Đáng chú ý, vị trí quán quân về khối lượng cổ phần khớp lệnh toàn phiên của sàn HOSE hôm nay nhường lại cho %s.",
                st.getName());
        System.out.println();
        return str;
    }

}
