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

public class FirstStockValueFall extends ChangingStock {
    public FirstStockValueFall(Stock stockBefore, Stock stockNow) {
        super(stockBefore, stockNow);
    }

    @Override
    public String print() {
        try {
            this.checkValueFall();
            String str = String.format("Kết thúc giao dịch %s giảm nhẹ khi giảm %d VNĐ xuống %d VNĐ với lượng khớp lệnh đạt %d",
                    this.getStockNow().getName(),
                    this.calculateValueChange(),
                    this.getStockNow().getMatchOrder().getValue(),
                    this.getStockNow().getMatchOrder().getMass());
            return str;
        } catch (ChangingStockException ex) {
            System.out.println("Exception caught! Alternative answer put out!");
            return ex.getMessage();
        }
    }
}
