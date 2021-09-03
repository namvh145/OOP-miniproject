package gui;

import functional.Functional;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import objects.MatchOrder;
import objects.OverTransaction;
import objects.Stock;
import objects.StockWithTotalValue;
import sentences.*;
import utils.DisplayUtils;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainController {
    private static final List<Stock> fromStocks = new ArrayList<>();
    private static final List<Stock> toStocks = new ArrayList<>();
    private static final List<StockWithTotalValue> fromStocksWithTotalValue = new ArrayList<>();
    private static final List<StockWithTotalValue> toStocksWithTotalValue = new ArrayList<>();
    private static final List<Functional> sentences = new ArrayList<>();
    private final String DEFAULT_YEAR = "-2021";
    public VBox inputDialog;
    private String fromPath;
    private String toPath;
    @FXML
    private TextField fromField;
    @FXML
    private TextField toField;
    @FXML
    private TextArea mainTextArea;

    private Date fromDate;
    private Date toDate;

    public void input() {
        Stage inputStage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Input.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputStage.setTitle("Input Data");
        assert root != null;
        inputStage.setScene(new Scene(root, 600, 300));
        inputStage.show();
    }

    public void fromBrowse() {
        //Setting up file chooser
        FileChooser fc = new FileChooser();
        //Add which type of file can be added
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Excel Files", "*.csv"));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF Files (For testing)", "*.pdf"));
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {
            fromField.setText(selectedFile.getAbsolutePath());
        } else {
            System.out.println("File not valid");
        }
    }

    public void toBrowse() {
        //Setting up file chooser
        FileChooser fc = new FileChooser();
        //Add which type of file can be added
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Excel Files", "*.csv"));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF Files (For testing)", "*.pdf"));
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {
            toField.setText(selectedFile.getAbsolutePath());
        } else {
            System.out.println("File not valid");
        }
    }

    public void addInput() {
        this.toPath = toField.getText();
        this.fromPath = fromField.getText();
        System.out.println("From Path: " + this.fromPath);
        System.out.println("To Path: " + this.toPath);
        try {
            // Refresh data
            if (!fromPath.equals("") && !toPath.equals("")) {
                fromStocks.clear();
                toStocks.clear();
                fromStocksWithTotalValue.clear();
                toStocksWithTotalValue.clear();
                sentences.clear();
            }
            //Processing DATA into arraylist
            getDateData();
            getStockData(fromStocks, fromDate, fromPath);
            getStockData(toStocks, toDate, toPath);
            // Create StocksWithTotalValue list
            for (Stock x : fromStocks) {
                fromStocksWithTotalValue.add(new StockWithTotalValue(x.getName(), x.getDate(), x.getOverBought(), x.getOverSale(), x.getFloor(), x.getRoof(), x.getMatchOrder()));
            }

            for (Stock x : toStocks) {
                toStocksWithTotalValue.add(new StockWithTotalValue(x.getName(), x.getDate(), x.getOverBought(), x.getOverSale(), x.getFloor(), x.getRoof(), x.getMatchOrder()));
            }
            // Create sentences
            createSentences();
        } catch (Exception e) {
            infoBox("Ban chua nhap duong dan", "Thieu duong dan");
            e.printStackTrace();
        }
        //Exit inputDialog
        Stage stage = (Stage) inputDialog.getScene().getWindow();
        System.out.println("Exit Input Dialog!!");
        stage.close();
    }

    public void getDateData() {
        String fromDateStr = this.fromPath.substring(this.fromPath.indexOf("hose"));
        String toDateStr = this.toPath.substring(this.toPath.indexOf("hose"));

        fromDateStr = fromDateStr.substring(fromDateStr.indexOf("e") + 1, fromDateStr.indexOf("."));
        toDateStr = toDateStr.substring(toDateStr.indexOf("e") + 1, toDateStr.indexOf("."));

        fromDateStr += DEFAULT_YEAR;
        toDateStr += DEFAULT_YEAR;

        SimpleDateFormat dateFormater = new SimpleDateFormat("dd-MM-yyyy");

        Date fromDate = null;
        try {
            fromDate = dateFormater.parse(fromDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date toDate = null;
        try {
            toDate = dateFormater.parse(toDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.fromDate = fromDate;
        this.toDate = toDate;

        System.out.println(fromDate);
        System.out.println(toDate);
    }

    public void getStockData(List<Stock> stockList, Date date, String path) {
        //parsing a CSV file into Scanner class constructor
        Scanner sc = null;
        try {
            sc = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Objects.requireNonNull(sc).nextLine();
        while (sc.hasNextLine())  //returns a boolean value
        {
            String[] stockInfoArr = sc.nextLine().split(",", -1);
            //Processing OverTransaction
            OverTransaction otb = new OverTransaction();
            OverTransaction ots = new OverTransaction();

            if (!stockInfoArr[8].isEmpty()) {
                otb.setValue(Double.parseDouble(stockInfoArr[8]));
            } else otb.setValue(0.0);

            if (!stockInfoArr[9].isEmpty()) {
                otb.setMass(Integer.parseInt(stockInfoArr[9]));
            } else otb.setMass(0);

            if (!stockInfoArr[15].isEmpty()) {
                ots.setValue(Double.parseDouble(stockInfoArr[15]));
            } else ots.setValue(0.0);

            if (!stockInfoArr[16].isEmpty()) {
                ots.setMass(Integer.parseInt(stockInfoArr[16]));
            } else ots.setMass(0);

            //Processing MatchOrder
            MatchOrder mo = new MatchOrder();
            if (!stockInfoArr[10].isEmpty()) {
                mo.setFluctuate(Double.parseDouble(stockInfoArr[10]));
            } else mo.setFluctuate(0.0);

            if (!stockInfoArr[11].isEmpty()) {
                mo.setPercentage(Double.parseDouble(stockInfoArr[11]));
            } else mo.setPercentage(0.0);

            if (!stockInfoArr[12].isEmpty()) {
                mo.setValue(Double.parseDouble(stockInfoArr[12]));
            } else continue;

            if (!stockInfoArr[13].isEmpty()) {
                mo.setMass(Integer.parseInt(stockInfoArr[13]));
            } else continue;

            if (!stockInfoArr[14].isEmpty()) {
                mo.setSum(Integer.parseInt(stockInfoArr[14]));
            } else continue;

            //Processing final stock
            Stock tmpStock = new Stock(stockInfoArr[0], date, otb, ots,
                    Double.parseDouble(stockInfoArr[2]), Double.parseDouble(stockInfoArr[1]),
                    mo);
            stockList.add(tmpStock);
            System.out.println("[" + tmpStock.getName() + ", " + tmpStock.getMatchOrder().getMass() + ", " + tmpStock.getMatchOrder().getSum() + "]");  //find and returns the next complete token from this scanner

        }
        sc.close();  //closes the scanner
    }

    public void createSentences() {
        //Getting fromStock and toStock
        Stock[] stockArray = DisplayUtils.SelectFromToStocks(fromStocks, toStocks);
        Stock fromStock = stockArray[0];
        Stock toStock = stockArray[1];
        //Main Sentence AREA
        sentences.add(new BankingStocks(fromStocks));
        sentences.add(new BankingStockWithMinMax(fromStocks));
        sentences.add(new ChangingStockWithDecrease(fromStock, toStock));
        sentences.add(new ChangingStockWithInitialValue(fromStock, toStock));
        sentences.add(new FifteenOverThreshold(fromStocks));
        sentences.add(new FifthStockCompare(fromStocks));
        sentences.add(new FifthStockValueFall(fromStock, toStock));
        sentences.add(new FifthStockWithTotalValue(fromStocksWithTotalValue));
        sentences.add(new FirstLargestMass(fromStocks));
        sentences.add(new FirstLargestTransaction(fromStocks));
        sentences.add(new FirstStockCompare(fromStocks));
        sentences.add(new FirstStockCompareTime(fromStock, toStock));
        sentences.add(new FirstStockRoofRise(fromStock, toStock));
        sentences.add(new FirstStockValueFall(fromStock, toStock));
        sentences.add(new FirstStockWithTotalValue(fromStocksWithTotalValue));
        sentences.add(new FiveHottestTransaction(fromStocks));
        sentences.add(new FiveLargestMass(fromStocks));
        sentences.add(new FiveLargestTransaction(fromStocks));
        sentences.add(new FiveMostConcentration(fromStocks));
        sentences.add(new FourHottestExcludeFirst(fromStocks));
        sentences.add(new FourLargestTotalValue(fromStocksWithTotalValue));
        sentences.add(new FourthStockCompare(fromStocks));
        sentences.add(new FourthStockValueFall(fromStock, toStock));
        sentences.add(new FourthStockWithTotalValue(fromStocksWithTotalValue));
        sentences.add(new GeneralIndicationFinalLargestTransaction(fromStocks));
        sentences.add(new GeneralIndicationWithMass(fromStocks));
        sentences.add(new GeneralIndicationWithMassAndValue(fromStocks));
        sentences.add(new GroupFourLargestTransactions(fromStocksWithTotalValue));
        sentences.add(new HighestMatchOrderMass(fromStocks));
        sentences.add(new HighestOverbought(fromStocks));
        sentences.add(new HighestTotalValue(fromStocksWithTotalValue));
        sentences.add(new HottestBuy(fromStocks));
        sentences.add(new LargestSum(fromStocks));
        sentences.add(new MatchOrderWithFloor(fromStocks));
        sentences.add(new MediumStock(fromStocks));
        sentences.add(new NegativeTwoLowestPrice(fromStocks));
        sentences.add(new NegativeWithMinMax(fromStocks));
        sentences.add(new NegativeWithTwoHighestLiquidity(fromStocksWithTotalValue));
        sentences.add(new OverboughtWithHighestMass(fromStocks));
        sentences.add(new OverboughtWithHighestPercentage(fromStocks));
        sentences.add(new OversaleAboveThreshold(fromStocks));
        sentences.add(new SecondLargestMass(fromStocks));
        sentences.add(new SecondLargestTransaction(fromStocks));
        sentences.add(new SecondStockCompare(fromStocks));
        sentences.add(new SecondStockCompareTime(fromStock, toStock));
        sentences.add(new SecondStockRoofRise(fromStock, toStock));
        sentences.add(new SecondStockValueFall(fromStock, toStock));
        sentences.add(new SecondStockWithTotalValue(fromStocksWithTotalValue));
        sentences.add(new SixHottest(fromStocks));
        sentences.add(new SixHottestExcludeFirst(fromStocks));
        sentences.add(new SmallestLiquidity(fromStocksWithTotalValue));
        sentences.add(new StandPriceWithBound(fromStocks));
        sentences.add(new StandPriceWithCount(fromStocks));
        sentences.add(new StockWithHighestSum(fromStocks));
        sentences.add(new ThirdStockCompare(fromStocks));
        sentences.add(new ThirdStockRoofRise(fromStock, toStock));
        sentences.add(new ThirdStockValueFall(fromStock, toStock));
        sentences.add(new ThirdStockWithTotalValue(fromStocksWithTotalValue));
        sentences.add(new ThreeFirstLiquidity(fromStocks));
        sentences.add(new ThreeFirstThreeSecond(fromStocks));
        sentences.add(new ThreeHottestBuy(fromStocks));
        sentences.add(new ThreeHottestSell(fromStocks));
        sentences.add(new ThreeHottestTransaction(fromStocks));
        sentences.add(new ThreeLargestMass(fromStocks));
        sentences.add(new ThreeLargestMassAndValue(fromStocks));
        sentences.add(new ThreeLargestMassWithPercent(fromStocks));
        sentences.add(new ThreeLargestMassWithPercentage(fromStocks));
        sentences.add(new ThreeMainTransaction(fromStocksWithTotalValue));
        sentences.add(new ThreeSmallestMass(fromStocks));
        sentences.add(new TransactionPercentage(fromStocksWithTotalValue));
        sentences.add(new TwentyTwoOverThreshold(fromStocks));
        sentences.add(new TwoFirstLiquidity(fromStocks));
        sentences.add(new TwoHighestMatchOrder(fromStocks));
        sentences.add(new TwoHottestSell(fromStocks));
        sentences.add(new TwoHottestTransaction(fromStocks));
        sentences.add(new TwoHottestTransfer(fromStocks));
        sentences.add(new TwoLargestMassTransfer(fromStocks));
        sentences.add(new TwoLargestStandPrice(fromStocks));
        sentences.add(new TwoLargestTotalValue(fromStocksWithTotalValue));
        sentences.add(new TwoLargestTransaction(fromStocks));
    }

    public void display_twenty_items() {
        clear();
        display(20);
    }

    public void display_fifty_items() {
        clear();
        display(50);
    }

    public void display_eighty_items() {
        clear();
        display(80);
    }

    public void display(int number) {
        if (toStocks.size() != 0 && fromStocks.size() != 0) {
            boolean[] printOrNot = new boolean[sentences.size()];
            int count = 0;
            int randomNumber = 0;
            Random generator = new Random();
            while (count < number) {
                randomNumber = generator.nextInt(sentences.size());
                while (printOrNot[randomNumber]) {
                    randomNumber = generator.nextInt(sentences.size());
                }
                printOrNot[randomNumber] = true;
                System.out.println(randomNumber);
                Functional s = sentences.get(randomNumber);
                mainTextArea.appendText(s.print());
                mainTextArea.appendText("\n");
                count++;
            }
        } else {
            System.out.println("Ban chua nhap file");
            infoBox("Ban chua nhap file", "File not found");
        }
    }

    public static void infoBox(String infoMessage, String titleBar) {
    /* By specifying a null headerMessage String, we cause the dialog to
       not have a header */
        infoBox(infoMessage, titleBar, null);
    }

    public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

    public void clear() {
        mainTextArea.setText("");
    }

    public void endProgram() {
        Stage stage = (Stage) mainTextArea.getScene().getWindow();
        System.out.println("Program ended successfully! Everybody loves MEGUMIN!!!!");
        stage.close();
    }

}
