package lk.ijse.RanasingheCinnamon.entity;

public class Customer {
    private String cusId;
    private String name;
    private String address;
    private String contactNo;

    public Customer(String cusId, String name, String address, String contactNo) {
        this.cusId = cusId;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
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
}
