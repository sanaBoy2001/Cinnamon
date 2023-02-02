package lk.ijse.RanasingheCinnamon.dto;

public class PlaceOrderDTO {
    private String CId;
    private String Name;
    private String Address;
    private String Contact;

    private String oId;
    private String Date;
    private String Details;
    private String Qty;

    private Double total;

    public PlaceOrderDTO(String string, String name, String address, String contactNo) {
    }

    public PlaceOrderDTO(String CId, String name, String address, String contact, String oId, String date, String details, String qty, Double total) {
        this.CId = CId;
        this.Name = name;
        this.Address = address;
        this.Contact = contact;
        this.oId = oId;
        this.Date = date;
        this.Details = details;
        this.Qty = qty;
        this.total = total;
    }

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        this.Contact = contact;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        this.Details = details;
    }

    public String getQty() {
        return Qty;
    }

    public void setQty(String qty) {
        this.Qty = qty;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
