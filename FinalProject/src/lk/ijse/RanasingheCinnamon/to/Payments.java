package lk.ijse.RanasingheCinnamon.to;

public class Payments {
    private String Id;
    private String Date;
    private String Amount;

    public Payments(String id, String date, String Amount) {
        this.Id = id;
        this.Date = date;
        this.Amount = Amount;

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }
}
