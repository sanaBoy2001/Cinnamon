package lk.ijse.RanasingheCinnamon.model;

import lk.ijse.RanasingheCinnamon.to.Register;
import lk.ijse.RanasingheCinnamon.utill.CrudUtil;

import java.sql.SQLException;

public class RegisterModel {
    public static boolean save(Register register) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO user VALUES (?,?,?,?,?,?,?)";
        return CrudUtil.execute(sql,register.getUId(),register.getUname(),register.getUemail(),register.getUaddress(),register.getUtelNo(),register.getUserName(),register.getPassword());

    }

    /*public static boolean updatePassword(Register register){
        String sql = "UPDATE user SET password = ? WHERE userName = ?";
        return CrudUtil.execute(sql,register.getnewPassword(),register.getConfirmPassword(),register.getuserName());
    }*/
}
