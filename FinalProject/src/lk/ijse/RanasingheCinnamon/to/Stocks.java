package lk.ijse.RanasingheCinnamon.to;

public class Stocks {
    private String Id;
    private String date;
    private String cost;
    private String quantity;

    public Stocks(String id, String date, String cost, String quantity) {
        this.Id= id;
        this.date = date;
        this.cost = cost;
        this.quantity = quantity;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
