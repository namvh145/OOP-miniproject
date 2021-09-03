package objects;

import java.util.Date;

public class StockWithTotalValue extends Stock {
    private long totalValue;

    public StockWithTotalValue(String name, Date date, OverTransaction overBought, OverTransaction overSale, Double floor, Double roof, MatchOrder matchOrder) {
        super(name, date, overBought, overSale, floor, roof, matchOrder);
        this.setTotalValue((matchOrder.getMass() * matchOrder.getValue()));
    }

    public long getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(long totalValue) {
        this.totalValue = totalValue;
    }
}
