package functions;

import objects.Stock;
import functional.Functional;

public abstract class CalculatingOverbought implements Functional {
    public long calculateOverbought(Stock stock) {
        return stock.getOverBought().getValue() * stock.getOverBought().getMass();
    }
}
