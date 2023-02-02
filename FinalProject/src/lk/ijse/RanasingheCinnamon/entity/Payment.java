package lk.ijse.RanasingheCinnamon.entity;

public class Payment {
    private String orderId;
    private String date;
    private String amount;

    public Payment(String orderId, String date, String amount) {
        this.orderId = orderId;
        this.date = date;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
