package lk.ijse.RanasingheCinnamon.dto;

public class OrdersDTO {
    private String oId;
    private String Id;
    private String date;
    private String details;
    private String quantity;
    public OrdersDTO(String id, String date, String details, String quantity) {
        this.Id = id;
        this.date = date;
        this.details = details;
        this.quantity = quantity;
    }


    public String getId() {
        return Id;
    }

    public void setId(String id) { this.Id = id; }

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
