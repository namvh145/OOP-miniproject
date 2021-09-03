/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import functional.Functional;

import static java.lang.Math.abs;

import objects.Stock;
import exception.ChangingStockException;

/**
 * @author Thao
 */
public abstract class ChangingStock implements Functional {
    private Stock stockBefore;
    private Stock stockNow;

    public ChangingStock(Stock stockBefore, Stock stockNow) {
        this.stockBefore = stockBefore;
        this.stockNow = stockNow;
    }

    public Stock getStockBefore() {
        return stockBefore;
    }

    public void setStockBefore(Stock stockBefore) {
        this.stockBefore = stockBefore;
    }

    public Stock getStockNow() {
        return stockNow;
    }

    public void setStockNow(Stock stockNow) {
        this.stockNow = stockNow;
    }

    public Long calculateValueChange() {
        return stockBefore.getMatchOrder().getValue() - stockNow.getMatchOrder().getValue();
    }

    public Double calculateRoofChange() {
        return stockNow.getRoof() - stockBefore.getRoof();
    }

    public void checkValueFall() throws ChangingStockException {
        double valueChange = this.calculateValueChange();
        if (valueChange < 0) {
            throw new ChangingStockException("Cổ phiếu %s tăng giá so với phiên giao dịch trước.", stockNow.getName());
        }
    }

    public void checkRoofRise() throws ChangingStockException {
        double roofChange = this.calculateRoofChange();
        if (roofChange < 0) {
            throw new ChangingStockException("Cổ phiếu %s hạ trần so với phiên giao dịch trước.", stockNow.getName());
        }
    }

}
