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
public class ThirdStockRoofRise extends ChangingStock {

    public ThirdStockRoofRise(Stock stockBefore, Stock stockNow) {
        super(stockBefore, stockNow);
    }

    @Override
    public String print() {
        try {
            this.checkRoofRise();
            String str = String.format("Trong số cổ phiếu vốn hóa lớn nhất sàn HOSE, %s tăng trần %f VNĐ.",
                    this.getStockNow().getName(),
                    this.calculateRoofChange());
            return str;
        } catch (ChangingStockException ex) {
            System.out.println("Exception caught: " + ex.getMessage());
            return ex.getMessage();
        }
    }
}
