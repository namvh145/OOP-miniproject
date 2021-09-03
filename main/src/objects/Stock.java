package objects;

import java.util.Date;

public class Stock implements Comparable<Stock> {
    private String name;
    private Date date;
    private OverTransaction overBought;
    private OverTransaction overSale;
    private Double floor;
    private Double roof;
    private MatchOrder matchOrder;

    public Stock() {

    }

    public Stock(String name, Date date, OverTransaction overBought, OverTransaction overSale, Double floor, Double roof, MatchOrder matchOrder) {
        setName(name);
        setDate(date);
        setOverBought(overBought);
        setOverSale(overSale);
        setFloor(floor);
        setRoof(roof);
        setMatchOrder(matchOrder);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OverTransaction getOverBought() {
        return overBought;
    }

    public void setOverBought(OverTransaction overBought) {
        this.overBought = overBought;
    }

    public OverTransaction getOverSale() {
        return overSale;
    }

    public void setOverSale(OverTransaction overSale) {
        this.overSale = overSale;
    }

    public Double getFloor() {
        return floor;
    }

    public void setFloor(Double floor) {
        this.floor = floor * 1000;
    }

    public Double getRoof() {
        return roof;
    }

    public void setRoof(Double roof) {
        this.roof = roof * 1000;
    }

    public MatchOrder getMatchOrder() {
        return matchOrder;
    }

    public void setMatchOrder(MatchOrder matchOrder) {
        this.matchOrder = matchOrder;
    }

    @Override
    public int compareTo(Stock o) {
        return this.getMatchOrder().getMass() - o.getMatchOrder().getMass();
    }

    public int compareToTotalSum(Stock o) {
        return this.getMatchOrder().getSum() - o.getMatchOrder().getSum();
    }

    public String toString() {
        return "[" + this.getName() + ", " + this.getMatchOrder().getMass() + ". " + this.getMatchOrder().getSum() + "] ";
    }
}
