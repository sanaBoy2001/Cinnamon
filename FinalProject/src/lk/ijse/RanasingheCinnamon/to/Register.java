package lk.ijse.RanasingheCinnamon.to;

public class Register {

    private String UId;
    private String Uname;
    private String Uemail;
    private String Uaddress;
    private String UtelNo;
    private String UserName;
    private String password;

    public Register(String uId, String uname, String uemail, String uaddress, String utelNo, String userName, String password) {
        this.UId = uId;
        this.Uname = uname;
        this.Uemail = uemail;
        this.Uaddress = uaddress;
        this.UtelNo = utelNo;
        this.UserName = userName;
        this.password = password;
    }


    public String getUId() {
        return UId;
    }

    public void setUId(String UId) {
        this.UId = UId;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getUemail() {
        return Uemail;
    }

    public void setUemail(String uemail) {
        Uemail = uemail;
    }

    public String getUaddress() {
        return Uaddress;
    }

    public void setUaddress(String uaddress) {
        Uaddress = uaddress;
    }

    public String getUtelNo() {
        return UtelNo;
    }

    public void setUtelNo(String utelNo) {
        UtelNo = utelNo;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
