package lk.ijse.RanasingheCinnamon.entity;

public class Export {

    private String employeeId;

    private String date;

    private String country;

    private String status;

    public Export(String employeeId, String date, String country, String status) {
        this.employeeId = employeeId;
        this.date = date;
        this.country = country;
        this.status = status;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
