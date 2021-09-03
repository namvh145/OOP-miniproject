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
public class SecondStockCompare extends FindingMinMax<Stock> {
    public SecondStockCompare(List<Stock> listOfObjects) {
        super(listOfObjects, "Mass", true);
    }

    private Integer calculateTotalSum(List<Stock> stocks) {
        int totalSum = 0;
        for (Stock st : stocks) {
            totalSum += st.getMatchOrder().getSum();
        }
        return totalSum;
    }

    @Override
    public String print() {
        int numberOfStocks = 5;
        List<Stock> stocks = this.find_N_Max(numberOfStocks);
        int totalSum = this.calculateTotalSum(stocks);
        String str = String.format("Nhóm %d cổ phiếu lớn nhất sàn HOSE có lượng giao dịch rất lớn, vào khoảng %d.",
                numberOfStocks,
                totalSum);
        return str;
    }

}
