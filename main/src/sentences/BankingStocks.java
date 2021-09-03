package sentences;

import functions.CheckingBankingStock;
import functions.FindingMinMax;
import objects.Stock;
import utils.StringUtils;

import java.util.List;

public class BankingStocks extends CheckingBankingStock {
    public BankingStocks(List<Stock> listOfObjects) {
        super(listOfObjects);
    }

    @Override
    public String print() {
        List<Stock> bankStocks = this.getListOfBankStocks();
        if (bankStocks.size() >= 2) {
            final Stock[] minStock = new Stock[1];
            FindingMinMax<Stock> findingMinMax = new FindingMinMax<Stock>(bankStocks, "Mass", false) {
                public void getMinMax() {
                    minStock[0] = this.findMin();
                }

                @Override
                public String print() {
                    getMinMax();
                    return null;
                }
            };
            findingMinMax.print();

            String strInput = "Trong khi đó, cổ phiếu ngân hàng chiếm ưu thế với giao dịch thỏa thuận khi %s liên tục sang tay thành công, khối lượng đều trên %d cổ phiếu";
            String strOutput = String.format(strInput, StringUtils.stringOfNames(bankStocks), minStock[0].getMatchOrder().getMass());
            System.out.println(strOutput);
            return strOutput;
        } else {
            System.out.println("Not enough bank stocks (Min = 2) to start!!");
            return "Không đủ cổ phiếu ngân hàng trong dữ liệu (Min = 2)";
        }
    }
}
