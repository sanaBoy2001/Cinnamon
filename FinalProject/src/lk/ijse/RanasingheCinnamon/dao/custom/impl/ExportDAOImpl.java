package lk.ijse.RanasingheCinnamon.dao.custom.impl;

import lk.ijse.RanasingheCinnamon.dao.custom.ExportDAO;
import lk.ijse.RanasingheCinnamon.entity.Export;

import java.sql.SQLException;
import java.util.ArrayList;

public class ExportDAOImpl implements ExportDAO {
    @Override
    public boolean save(Export export) throws SQLException, ClassNotFoundException {
        /*String sql = "INSERT INTO export VALUES = (?,?,?,?)";
        return CrudUtil.execute(sql,export.getId(),export.getDate(),export.getLocation(),export.getStatus());*/
        return false;
    }

    @Override
    public Export search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String Id) throws SQLException, ClassNotFoundException {

        return false;
    }

    @Override
    public boolean update(Export deliveries) throws SQLException, ClassNotFoundException {

        return false;
    }

    @Override
    public ArrayList<String> loadStockIds() throws SQLException, ClassNotFoundException {
        return null;
    }
    /*public static boolean save(ExportDTO export) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO export VALUES = (?,?,?,?)";
        return CrudUtil.execute(sql,export.getId(),export.getDate(),export.getLocation(),export.getStatus());
    }

    public static ExportDTO search(String ID) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM export WHERE exportId = '"+ID+"'";
        ResultSet result = CrudUtil.execute(sql);

        if(result.next()){
            return new ExportDTO(result.getString("exportId"),result.getString("date"), result.getString("country"),result.getString("status"));
        }
        return null;
    }

    public static boolean update(ExportDTO export) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE export SET date = ? , location = ? , status = ? WHERE exportId = ?";
        return CrudUtil.execute(sql, export.getDate(), export.getLocation(), export.getStatus(), export.getId());
    }

    public static boolean delete(String Id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM export WHERE exportId = '"+Id+"'";
        return CrudUtil.execute(sql);
    }*/
}
