package functions;

import functional.Functional;
import objects.Stock;

import java.util.ArrayList;
import java.util.List;

public abstract class CalculatingStandPrice implements Functional {
    protected List<Stock> listOfObjects;
    public final Double MAX_DEVIATION = 1000.0;

    public CalculatingStandPrice(List<Stock> listOfObjects) {
        this.listOfObjects = listOfObjects;
    }

    public boolean isStandPrice(Stock stock) {
        return !(stock.getRoof() - stock.getFloor() > MAX_DEVIATION);
    }

    public List<Stock> findListOfStandPrice() {
        List<Stock> listOfStandPrice = new ArrayList<>();
        for (Stock stock : listOfObjects) {
            if (isStandPrice(stock)) {
                listOfStandPrice.add(stock);
            }
        }
        return listOfStandPrice;
    }
}
