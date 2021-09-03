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

import objects.Stock;
import utils.CalculatingPercentageUtils;

/**
 * @author Thao
 */
public class SecondStockCompareTime extends ChangingStock {
    public SecondStockCompareTime(Stock stockBefore, Stock stockNow) {
        super(stockBefore, stockNow);
    }

    @Override
    public String print() {
        Instant dateBefore = this.getStockBefore().getDate().toInstant();
        Instant dateNow = this.getStockNow().getDate().toInstant();
        long daysBetween = ChronoUnit.DAYS.between(dateBefore, dateNow);
        String str = String.format("So với phiên giao dịch %d ngày trước cổ phiếu %s trong phiên giao dịch này có số khớp lệnh trong phiên ",
                daysBetween,
                this.getStockNow().getName());

        int diffMass = this.getStockBefore().getMatchOrder().getMass() - this.getStockNow().getMatchOrder().getMass();
        double massPercent = CalculatingPercentageUtils.calculatePercentage(abs(diffMass), (double) this.getStockBefore().getMatchOrder().getMass());
        if (diffMass > 0) {
            str += "giảm " + massPercent + "% và ";
        } else {
            str += "tăng " + massPercent + "% và ";
        }

        Double roofChange = this.calculateRoofChange();
        if (roofChange > 0) {
            str += "tăng trần.";
        } else {
            str += "hạ trần.";
        }

        return str;
    }
}
