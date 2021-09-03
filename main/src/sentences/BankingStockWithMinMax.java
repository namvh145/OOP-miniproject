package sentences;

import functions.CheckingBankingStock;
import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class BankingStockWithMinMax extends CheckingBankingStock {
    public BankingStockWithMinMax(List<Stock> listOfObjects) {
        super(listOfObjects);
    }

    @Override
    public String print() {
        List<Stock> bankStocks = this.getListOfBankStocks();
        if (bankStocks.size() >= 3) {
            final Stock[] minStock1 = {new Stock()};
            final Stock[] minStock2 = {new Stock()};
            final Stock[] maxStock = {new Stock()};
            FindingMinMax<Stock> findingMin = new FindingMinMax<Stock>(bankStocks, "Mass", false) {
                public void getMins() {
                    minStock1[0] = this.findMin();
                    minStock2[0] = this.find_Nth_Min(1);
                }

                @Override
                public String print() {
                    getMins();
                    return null;
                }
            };
            FindingMinMax<Stock> findingMax = new FindingMinMax<Stock>(bankStocks, "Mass", true) {
                public void getMax() {
                    maxStock[0] = this.findMax();
                }

                @Override
                public String print() {
                    getMax();
                    return null;
                }
            };
            findingMin.print();
            findingMax.print();
            String strInput = "Ngoại trừ %s chỉ mua bán %d chứng khoán, các mã còn lại trong rổ ngân hàng đều có lượng giao dịch từ %d đến %d đơn vị";
            String strOutput = String.format(strInput, minStock1[0].getName(), minStock1[0].getMatchOrder().getMass(),
                    maxStock[0].getMatchOrder().getMass(), minStock2[0].getMatchOrder().getMass());
            System.out.println(strOutput);
            return strOutput;
        } else {
            System.out.println("Not enough bank stocks (Min = 3) to start!!");
            return "Không đủ cổ phiếu ngân hàng trong danh sách (Min = 3)";
        }
    }
}
