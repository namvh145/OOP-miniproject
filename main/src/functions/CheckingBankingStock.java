package functions;

import functional.Functional;
import objects.Stock;

import java.util.ArrayList;
import java.util.List;

public abstract class CheckingBankingStock implements Functional {
    protected List<Stock> listOfObjects;

    private final List<String> bankingStocks = new ArrayList<>() {{
        add("CTG");
        add("NVB");
        add("SHB");
        add("STB");
        add("AAM");
    }};

    public CheckingBankingStock(List<Stock> listOfObjects) {
        this.listOfObjects = listOfObjects;
    }

    public List<Stock> getListOfBankStocks() {
        List<Stock> bankStocks = new ArrayList<>();
        for (Stock stock : listOfObjects) {
            if (bankingStocks.contains(stock.getName())) {
                bankStocks.add(stock);
            }
        }
        return bankStocks;
    }
}
