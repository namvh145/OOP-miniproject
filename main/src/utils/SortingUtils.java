package utils;

import objects.Stock;
import objects.StockWithTotalValue;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingUtils {
    /*
    Sorting Utilities with pre-defined field in the list of Objects
     */
    public static void sortByValues(List<Stock> source, boolean isDescendingOrder) {
        if (!isDescendingOrder) {
            Collections.sort(source, new Comparator<>() {
                @Override
                public int compare(Stock o1, Stock o2) {
                    return o1.getMatchOrder().getValue().compareTo(o2.getMatchOrder().getValue());
                }
            });
            return;
        }
        Collections.sort(source, new Comparator<>() {
            @Override
            public int compare(Stock o1, Stock o2) {
                return o2.getMatchOrder().getValue().compareTo(o1.getMatchOrder().getValue());
            }
        });
    }

    public static void sortByTotalSum(List<Stock> source, boolean isDescendingOrder) {
        if (!isDescendingOrder) {
            Collections.sort(source, new Comparator<>() {
                @Override
                public int compare(Stock o1, Stock o2) {
                    return o1.compareToTotalSum(o2);
                }
            });
            return;
        }
        Collections.sort(source, new Comparator<>() {
            @Override
            public int compare(Stock o1, Stock o2) {
                return o2.compareToTotalSum(o1);
            }
        });
    }

    public static void sortByTotalValue(List<StockWithTotalValue> source, boolean isDescendingOrder) {
        if (!isDescendingOrder) {
            Collections.sort(source, new Comparator<StockWithTotalValue>() {
                @Override
                public int compare(StockWithTotalValue o1, StockWithTotalValue o2) {
                    return (int) (o1.getTotalValue() - o2.getTotalValue());
                }
            });
            return;
        }
        Collections.sort(source, new Comparator<StockWithTotalValue>() {
            @Override
            public int compare(StockWithTotalValue o1, StockWithTotalValue o2) {
                return (int) (o1.getTotalValue() - o2.getTotalValue());
            }
        });
    }

    public static void sortByMass(List<Stock> source, boolean isDescendingOrder) {
        if (!isDescendingOrder) {
            Collections.sort(source, new Comparator<>() {
                @Override
                public int compare(Stock o1, Stock o2) {
                    return o1.getMatchOrder().getMass().compareTo(o2.getMatchOrder().getMass());
                }
            });
            return;
        }
        Collections.sort(source, new Comparator<>() {
            @Override
            public int compare(Stock o1, Stock o2) {
                return o2.getMatchOrder().getMass().compareTo(o1.getMatchOrder().getMass());
            }
        });
    }

    public static void sortByOverboughtMass(List<Stock> source, boolean isDescendingOrder) {
        if (!isDescendingOrder) {
            Collections.sort(source, new Comparator<>() {
                @Override
                public int compare(Stock o1, Stock o2) {
                    return o1.getOverBought().getMass().compareTo(o2.getOverBought().getMass());
                }
            });
            return;
        }
        Collections.sort(source, new Comparator<>() {
            @Override
            public int compare(Stock o1, Stock o2) {
                return o2.getOverBought().getMass().compareTo(o1.getOverBought().getMass());
            }
        });
    }

    public static void sortByOverbought(List<Stock> source, boolean isDescendingOrder) {
        if (!isDescendingOrder) {
            source.sort(Comparator.comparing(s -> Double.valueOf(s.getOverBought().getMass()) * s.getOverBought().getValue(), Comparator.nullsLast(Comparator.naturalOrder())));
            return;
        }
        source.sort(Comparator.comparing(s -> Double.valueOf(s.getOverBought().getMass()) * s.getOverBought().getValue(), Comparator.nullsLast(Comparator.reverseOrder())));
    }

    public static void sortByMassAndValue(List<Stock> source, boolean isDescendingOrder) {
        if (!isDescendingOrder) {
            source.sort((s1, s2) -> {
                if (!s1.getMatchOrder().getMass().equals(s2.getMatchOrder().getMass())) {
                    return s1.getMatchOrder().getMass() - s2.getMatchOrder().getMass();
                }
                return (int) (s1.getMatchOrder().getValue() - s2.getMatchOrder().getValue());
            });
        }
        source.sort((s1, s2) -> {
            if (!s1.getMatchOrder().getMass().equals(s2.getMatchOrder().getMass())) {
                return s1.getMatchOrder().getMass() - s2.getMatchOrder().getMass();
            }
            return (int) (s1.getMatchOrder().getValue() - s2.getMatchOrder().getValue());
        });
    }
}
