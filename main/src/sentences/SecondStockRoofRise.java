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
public class SecondStockRoofRise extends ChangingStock {

    public SecondStockRoofRise(Stock stockBefore, Stock stockNow) {
        super(stockBefore, stockNow);
    }

    @Override
    public String print() {
        try {
            this.checkRoofRise();
            String str = String.format("Điểm nhấn của phiên này là %s, khi tăng trần %f VNĐ và có với khối lượng khớp lệnh %d.",
                    this.getStockNow().getName(),
                    this.calculateRoofChange(),
                    this.getStockNow().getMatchOrder().getMass());
            return str;
        } catch (ChangingStockException ex) {
            System.out.println("Exception caught! Alternative answer put out!");
            return ex.getMessage();
        }
    }
}
