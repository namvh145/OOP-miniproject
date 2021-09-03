package exception;


public class ChangingStockException extends Exception {
    private String msg;
    public ChangingStockException(String str, String stockName) {
        this.setMsg(str, stockName);
    }

    @Override
    public String getMessage() {
        return msg;
    }

    public void setMsg(String msg, String stockName) {
        this.msg = String.format(msg, stockName);
    }
}
