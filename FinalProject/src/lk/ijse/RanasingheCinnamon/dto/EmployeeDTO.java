package lk.ijse.RanasingheCinnamon.dto;

public class EmployeeDTO {

    private String id;
    private String role;
    private String name;
    private String nicNo;
    private String address;
    private String contactNo;
    public EmployeeDTO(String id, String role, String name, String nicNo, String address, String contactNo) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.nicNo = nicNo;
        this.address = address;
        this.contactNo = contactNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
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
