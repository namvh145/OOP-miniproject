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

public class SecondStockValueFall extends ChangingStock {
    public SecondStockValueFall(Stock stockBefore, Stock stockNow) {
        super(stockBefore, stockNow);
    }

    @Override
    public String print() {
        try {
            this.checkValueFall();
            String str = String.format("Đợt giao dịch vừa rồi trên sàn HOSE, %s giảm nhẹ %d VNĐ khi khối lượng giao dịch chỉ ở mức %d cổ phiếu.",
                    this.getStockNow().getName(),
                    this.calculateValueChange(),
                    this.getStockNow().getMatchOrder().getMass());
            return str;
        } catch (ChangingStockException ex) {
            System.out.println("Exception caught! Alternative answer put out!");
            return ex.getMessage();
        }
    }
}
