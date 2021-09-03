package functions;

import functional.Functional;
import objects.Stock;

import java.util.List;

public abstract class CalculatingBound implements Functional {
    private List<Stock> stocks;

    public CalculatingBound(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public int calculateBound(int numberOfStock) {
        double boundValue = (stocks.get(numberOfStock - 1).getMatchOrder().getSum()
                + stocks.get(numberOfStock).getMatchOrder().getSum()) / 2.0;
        return (int) Math.round(boundValue);
    }
}
