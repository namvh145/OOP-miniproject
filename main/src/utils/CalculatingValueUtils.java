/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import objects.Stock;
import objects.StockWithTotalValue;

import java.util.List;

public class CalculatingValueUtils {
    public static long calculateTotalValueSt(List<Stock> stocks) {
        long price = 0;
        for (Stock st : stocks) {
            long val = st.getMatchOrder().getValue() * st.getMatchOrder().getSum();
            price += val;
        }
        return price;
    }

    public static long calculateTotalValue(List<StockWithTotalValue> stocks) {
        long totalValue = 0;
        for (StockWithTotalValue st : stocks) {
            totalValue += st.getTotalValue();
        }
        return totalValue;
    }
}
