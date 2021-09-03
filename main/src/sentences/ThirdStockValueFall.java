/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentences;

import functions.ChangingStock;
import objects.Stock;
import exception.ChangingStockException;

/**
 * @author Thao
 */

public class ThirdStockValueFall extends ChangingStock {
    public ThirdStockValueFall(Stock stockBefore, Stock stockNow) {
        super(stockBefore, stockNow);
    }

    @Override
    public String print() {
        try {
            this.checkValueFall();
            String str = String.format("%s đóng cửa phiên giao dịch trước với mức giảm %d VNĐ khi nhà đầu tư đẩy mạnh bán sàn tại hầu hết các cổ phiếu.",
                    this.getStockNow().getName(),
                    this.calculateValueChange());
            return str;
        } catch (ChangingStockException ex) {
            System.out.println("Exception caught! Alternative answer put out!");
            return ex.getMessage();
        }
    }
}
