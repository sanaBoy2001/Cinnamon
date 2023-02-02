package lk.ijse.RanasingheCinnamon.dao.custom.impl;

import lk.ijse.RanasingheCinnamon.dto.RegisterDTO;
import lk.ijse.RanasingheCinnamon.utill.CrudUtil;

import java.sql.SQLException;

public class RegisterDAOImpl {
    public static boolean save(RegisterDTO register) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO user VALUES (?,?,?,?,?,?,?)";
        return CrudUtil.execute(sql,register.getUId(),register.getUname(),register.getUemail(),register.getUaddress(),register.getUtelNo(),register.getUserName(),register.getPassword());

    }

    /*public static boolean updatePassword(RegisterDTO register){
        String sql = "UPDATE user SET password = ? WHERE userName = ?";
        return CrudUtil.execute(sql,register.getnewPassword(),register.getConfirmPassword(),register.getuserName());
    }*/
}
