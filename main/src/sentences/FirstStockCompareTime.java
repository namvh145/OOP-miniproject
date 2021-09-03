/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentences;

import functions.ChangingStock;

import static java.lang.Math.abs;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import objects.Stock;
import utils.CalculatingPercentageUtils;
import utils.CalculatingValueUtils;

/**
 * @author Thao
 */
public class FirstStockCompareTime extends ChangingStock {
    public FirstStockCompareTime(Stock stockBefore, Stock stockNow) {
        super(stockBefore, stockNow);
    }

    @Override
    public String print() {
        Instant dateBefore = this.getStockBefore().getDate().toInstant();
        Instant dateNow = this.getStockNow().getDate().toInstant();
        long daysBetween = ChronoUnit.DAYS.between(dateBefore, dateNow);
        String str = String.format("So với %d ngày trước, cổ phiếu %s có khối lượng giao dịch ",
                daysBetween,
                this.getStockNow().getName());

        int diffSum = this.getStockBefore().getMatchOrder().getSum() - this.getStockNow().getMatchOrder().getSum();
        double sumPercent = CalculatingPercentageUtils.calculatePercentage((double) abs(diffSum), (double) this.getStockBefore().getMatchOrder().getSum());
        if (diffSum > 0) {
            str += "giảm " + sumPercent + "% và giá trị giao dịch ";
        } else {
            str += "tăng " + sumPercent + "% và giá trị giao dịch ";
        }

        long priceBefore = CalculatingValueUtils.calculateTotalValueSt(new ArrayList<Stock>() {
            {
                add(getStockBefore());
            }
        });
        long priceNow = CalculatingValueUtils.calculateTotalValueSt(new ArrayList<Stock>() {
            {
                add(getStockNow());
            }
        });
        long diffPrice = priceBefore - priceNow;
        double pricePercent = CalculatingPercentageUtils.calculatePercentage((double) abs(diffPrice), (double) priceBefore);
        if (diffPrice > 0) {
            str += "giảm " + pricePercent + "%.";
        } else {
            str += "tăng " + pricePercent + "%.";
        }

        return str;
    }
}