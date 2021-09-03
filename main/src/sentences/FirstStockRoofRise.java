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
public class FirstStockRoofRise extends ChangingStock {
    public FirstStockRoofRise(Stock stockBefore, Stock stockNow) {
        super(stockBefore, stockNow);
    }

    @Override
    public String print() {
        try {
            this.checkRoofRise();
            String str = String.format("Trên sàn HOSE, %s tăng trần với %d cổ phiếu được giao dịch.",
                    this.getStockNow().getName(),
                    this.getStockNow().getMatchOrder().getMass());
            return str;
        } catch (ChangingStockException ex) {
            System.out.println("Exception caught! Alternative answer put out!");
            return ex.getMessage();
        }
    }
}
