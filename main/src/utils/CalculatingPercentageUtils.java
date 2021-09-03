package utils;

import objects.Stock;
import objects.StockWithTotalValue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class CalculatingPercentageUtils {
    private double divident = 0.0;
    private double divisor = 1.0;

    public double getDivident() {
        return divident;
    }

    public void setDivident(double divident) {
        this.divident = divident;
    }

    public double getDivisor() {
        return divisor;
    }

    public void setDivisor(double divisor) {
        if (divisor == 0.0) {
            throw new IllegalArgumentException("Argument 'divisor' is 0");
        }
        this.divisor = divisor;
    }

    public int roundUp(double number) {
        return (int) Math.round(number);
    }

    public static double calculatePercentage(double divident, double divisor) {
        CalculatingPercentageUtils tmp = new CalculatingPercentageUtils();
        tmp.setDivident(divident);
        tmp.setDivisor(divisor);
        double result = (tmp.getDivident() * 100.0) / (tmp.getDivisor() * 1.0);
        return tmp.roundUp(result);
    }

    public static double processMassPercentage(List<Stock> listOfObjects, long stockMass) {
        long totalMass = 0;
        for (Stock o : listOfObjects) {
            totalMass += o.getMatchOrder().getMass();
        }
        return calculatePercentage(stockMass, totalMass);
    }

    public static double processTotalValuePercentage(List<StockWithTotalValue> listOfObjects, long stockValue) {
        BigDecimal overallTotalValue = new BigDecimal("0.00");
        for (StockWithTotalValue o : listOfObjects) {
            overallTotalValue = overallTotalValue.add(new BigDecimal(String.valueOf(o.getTotalValue())));
        }
        return Double.parseDouble(new BigDecimal(String.valueOf(stockValue)).divide(overallTotalValue, 8, RoundingMode.CEILING).multiply(new BigDecimal("100.00")).toString());
    }

    public static double processTotalValuePercentageWithBigInteger(List<StockWithTotalValue> listOfObjects, BigDecimal stockValue) {
        BigDecimal overallTotalValue = new BigDecimal("0.00");
        for (StockWithTotalValue o : listOfObjects) {
            overallTotalValue = overallTotalValue.add(new BigDecimal(String.valueOf(o.getTotalValue())));
        }
        return Double.parseDouble(stockValue.divide(overallTotalValue, 8, RoundingMode.CEILING).multiply(new BigDecimal("100.00")).toString());
    }
}
