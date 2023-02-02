package lk.ijse.RanasingheCinnamon.dto;

public class SupplierDTO {
    private String id;
    private String name;
    private String address;
    private String contactNo;

    private String suppliedQty;
    private Double cost;

    public SupplierDTO(String id, String name, String address, String contactNo, String suppliedQty, Double cost) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.suppliedQty = suppliedQty;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = Double.valueOf(cost);
    }
}
