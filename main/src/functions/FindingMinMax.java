package functions;

import functional.Functional;
import objects.Stock;
import objects.StockWithTotalValue;
import utils.SortingUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class FindingMinMax<T> implements Functional {
    protected List<T> listOfObjects;
    private boolean isDescendingOrder;
    private String sortKey;

    public FindingMinMax(String sortKey) {
        this.setListOfObjects(new ArrayList<>());
        this.setSortKey(sortKey);
        this.setDescendingOrder(false);
    }

    public FindingMinMax(List<T> listOfObjects, String sortKey) {
        this.setListOfObjects(listOfObjects);
        this.setSortKey(sortKey);
        this.setDescendingOrder(false);
    }

    public FindingMinMax(List<T> listOfObjects, String sortKey, boolean isDescendingOrder) {
        this.setListOfObjects(listOfObjects);
        this.setSortKey(sortKey);
        this.setDescendingOrder(isDescendingOrder);
    }

    private void chooseKeySort(String keySort) {
        switch (keySort) {
            case "Values" -> SortingUtils.sortByValues((List<Stock>) listOfObjects, isDescendingOrder);
            case "TotalSum" -> SortingUtils.sortByTotalSum((List<Stock>) listOfObjects, isDescendingOrder);
            case "Mass" -> SortingUtils.sortByMass((List<Stock>) listOfObjects, isDescendingOrder);
            case "OverBoughtMass" -> SortingUtils.sortByOverboughtMass((List<Stock>) listOfObjects, isDescendingOrder);
            case "OverBought" -> SortingUtils.sortByOverbought((List<Stock>) listOfObjects, isDescendingOrder);
            case "TotalValue" -> SortingUtils.sortByTotalValue((List<StockWithTotalValue>) listOfObjects, isDescendingOrder);
            case "MassAndValue" -> SortingUtils.sortByMassAndValue((List<Stock>) listOfObjects, isDescendingOrder);
        }
    }

    public List<T> getListOfObjects() {
        return listOfObjects;
    }

    public void setListOfObjects(List<T> listOfObjects) {
        this.listOfObjects = listOfObjects;
    }

    public boolean isDescendingOrder() {
        return isDescendingOrder;
    }

    public void setDescendingOrder(boolean descendingOrder) {
        this.isDescendingOrder = descendingOrder;
        this.chooseKeySort(this.getSortKey());
    }

    public String getSortKey() {
        return sortKey;
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    public T findMax() {
        int n = this.getListOfObjects().size();
        if (!isDescendingOrder) {
            return this.getListOfObjects().get(n - 1);
        }
        return this.listOfObjects.get(0);
    }

    public T findMin() {
        int n = this.getListOfObjects().size();
        if (!isDescendingOrder) {
            return this.listOfObjects.get(n - 1);
        }
        return this.getListOfObjects().get(0);
    }

    public List<T> find_N_Max(int numberOfRecords) {
        int n = this.getListOfObjects().size();
        if (numberOfRecords > n) {
            numberOfRecords = n;
        }
        List<T> result = new ArrayList<>();
        if (isDescendingOrder) {
            for (int i = 0; i < numberOfRecords; i++) {
                result.add(this.getListOfObjects().get(i));
                System.out.println(this.getListOfObjects().get(i).toString());
            }
        } else {
            for (int i = n - 1; i >= n - numberOfRecords; i--) {
                result.add(this.getListOfObjects().get(i));
                System.out.println(this.getListOfObjects().get(i).toString());
            }
        }
        return result;
    }

    public T find_Nth_Min(int Nth) {
        int n = this.getListOfObjects().size();
        if (isDescendingOrder) {
            return this.listOfObjects.get(n - Nth);
        }
        return this.getListOfObjects().get(Nth);
    }

    public List<T> find_N_Min(int numberOfRecords) {
        int n = this.getListOfObjects().size();
        if (numberOfRecords > n) {
            numberOfRecords = n;
        }
        List<T> result = new ArrayList<>();
        if (!isDescendingOrder) {
            for (int i = 0; i < numberOfRecords; i++) {
                result.add(this.getListOfObjects().get(i));
            }
        } else {
            for (int i = n - 1; i >= n - numberOfRecords; i--) {
                result.add(this.getListOfObjects().get(i));
            }
        }
        return result;
    }

}
