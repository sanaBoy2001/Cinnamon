package lk.ijse.RanasingheCinnamon.entity;

public class Orders {
    private String orderId;
    private String cusId;
    private String date;
    private String details;
    private String quantity;

    public Orders(String orderId, String cusId, String date, String details, String quantity) {
        this.orderId = orderId;
        this.cusId = cusId;
        this.date = date;
        this.details = details;
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
