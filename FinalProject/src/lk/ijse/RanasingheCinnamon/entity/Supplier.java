package lk.ijse.RanasingheCinnamon.entity;

public class Supplier {
    private String supplierId;
    private String name;
    private String address;
    private String contactNo;
    private String suppliedQty;
    private String Cost;

    public Supplier(String supplierId, String name, String address, String contactNo, String suppliedQty, String cost) {
        this.supplierId = supplierId;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.suppliedQty = suppliedQty;
        Cost = cost;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getSuppliedQty() {
        return suppliedQty;
    }

    public void setSuppliedQty(String suppliedQty) {
        this.suppliedQty = suppliedQty;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }
}
