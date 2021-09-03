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

public class FifthStockValueFall extends ChangingStock {
    public FifthStockValueFall(Stock stockBefore, Stock stockNow) {
        super(stockBefore, stockNow);
    }

    @Override
    public String print() {
        try {
            this.checkValueFall();
            String str = String.format("Ngay khi kết thúc đợt khớp lệnh đầu tiên trên sàn HOSE, %s đã giảm %d VNĐ (%f) và lui về mức %d VNĐ với khối lượng giao dịch sụt giảm mạnh.",
                    this.getStockNow().getName(),
                    this.calculateValueChange(),
                    CalculatingPercentageUtils.calculatePercentage((double) this.calculateValueChange(), (double) this.getStockBefore().getMatchOrder().getValue()),
                    this.getStockNow().getMatchOrder().getValue());
            return str;
        } catch (ChangingStockException ex) {
            System.out.println("Exception caught! Alternative answer put out!");;
            return ex.getMessage();
        }
    }
}
