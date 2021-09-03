package sentences;

import functions.FindingMinMax;
import objects.Stock;

import java.util.List;

public class ThreeLargestMassAndValue extends FindingMinMax<Stock> {
    public ThreeLargestMassAndValue(List<Stock> listOfObjects) {
        super(listOfObjects, "MassAndValue", true);
    }

    @Override
    public String print() {
        String str = "Những cổ phiếu dẫn đầu thị trường cả về khối lượng và giá trị khớp lệnh vẫn là các tên tuổi lớn như %s, %s và %s";
        List<Stock> source = this.find_N_Max(3);

        String formattedStr = String.format(str, source.get(0).getName(), source.get(1).getName(), source.get(2).getName());

        System.out.println(formattedStr);

        return formattedStr;
    }
}
