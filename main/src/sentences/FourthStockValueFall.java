/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentences;

import functions.ChangingStock;
import objects.Stock;
import utils.CalculatingPercentageUtils;
import exception.ChangingStockException;

/**
 * @author Thao
 */

public class FourthStockValueFall extends ChangingStock {
    public FourthStockValueFall(Stock stockBefore, Stock stockNow) {
        super(stockBefore, stockNow);
    }

    @Override
    public String print() {
        try {
            this.checkValueFall();
            String str = String.format("Kết thúc phiên giao dịch %s đã mất thêm %d VNĐ (tương đương %f), còn %d VNĐ.",
                    this.getStockNow().getName(),
                    this.calculateValueChange(),
                    CalculatingPercentageUtils.calculatePercentage((double) this.calculateValueChange(), (double) this.getStockBefore().getMatchOrder().getValue()),
                    this.getStockNow().getMatchOrder().getValue());
            return str;
        } catch (ChangingStockException ex) {
            return ex.getMessage();
        }
    }
}
