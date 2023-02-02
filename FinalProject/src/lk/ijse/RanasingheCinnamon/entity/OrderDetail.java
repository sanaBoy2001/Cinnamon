package lk.ijse.RanasingheCinnamon.entity;

public class OrderDetail {
    private String cusId;

    private String orderId;

    public OrderDetail(String cusId, String orderId) {
        this.cusId = cusId;
        this.orderId = orderId;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
