package lk.ijse.RanasingheCinnamon.model;

import lk.ijse.RanasingheCinnamon.to.Export;
import lk.ijse.RanasingheCinnamon.to.Supplier;
import lk.ijse.RanasingheCinnamon.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExportModel {
    public static boolean save(Export export) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO export VALUES = (?,?,?,?)";
        return CrudUtil.execute(sql,export.getId(),export.getDate(),export.getLocation(),export.getStatus());
    }

    public static Export search(String ID) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM export WHERE exportId = '"+ID+"'";
        ResultSet result = CrudUtil.execute(sql);

        if(result.next()){
            return new Export(result.getString("exportId"),result.getString("date"), result.getString("country"),result.getString("status"));
        }
        return null;
    }

    public static boolean update(Export export) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE export SET date = ? , location = ? , status = ? WHERE exportId = ?";
        return CrudUtil.execute(sql, export.getDate(), export.getLocation(), export.getStatus(), export.getId());
    }

    public static boolean delete(String Id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM export WHERE exportId = '"+Id+"'";
        return CrudUtil.execute(sql);
    }
}
