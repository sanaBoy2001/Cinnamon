package lk.ijse.RanasingheCinnamon.to;

public class Export {
    private String id;
    private String date;
    private String location;
    private String status;

    public Export(String id, String date, String country, String status) {
        this.id = id;
        this.date = date;
        this.location = country;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

}
