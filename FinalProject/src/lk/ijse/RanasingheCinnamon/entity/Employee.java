package lk.ijse.RanasingheCinnamon.entity;

public class Employee {

    private String employeeId;

    private String role;

    private String name;

    private String nicNo;

    private String address;

    private String contactNo;

    public Employee(String employeeId, String role, String name, String nicNo, String address, String contactNo) {
        this.employeeId = employeeId;
        this.role = role;
        this.name = name;
        this.nicNo = nicNo;
        this.address = address;
        this.contactNo = contactNo;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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
