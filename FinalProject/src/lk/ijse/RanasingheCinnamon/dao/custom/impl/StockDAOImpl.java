package lk.ijse.RanasingheCinnamon.dao.custom.impl;

import lk.ijse.RanasingheCinnamon.dto.StocksDTO;
import lk.ijse.RanasingheCinnamon.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StockDAOImpl {
    public static boolean save(StocksDTO stocks) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO stock VALUES (?,?,?,?)";
        return CrudUtil.execute(sql,stocks.getId(),stocks.getDate(),stocks.getCost(),stocks.getQuantity());
    }

    public static StocksDTO search(String ID) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM stock WHERE stockId = '"+ID+"'";
        ResultSet result = CrudUtil.execute(sql);

        if(result.next()){
            return new StocksDTO(result.getString("stockId"),result.getString("date"), result.getString("cost"),result.getString("quantity"));
        }
        return null;
    }

    public static boolean delete(String ID) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM stock WHERE stockId = '"+ID+"'";
        return CrudUtil.execute(sql);
    }

    public static boolean update(StocksDTO stocks) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE stock SET date = ? , cost = ? , quantity = ? WHERE stockId = ?";
        return CrudUtil.execute(sql, stocks.getDate(), stocks.getCost(), stocks.getQuantity(), stocks.getId());
    }

    public static ArrayList<String> loadstockId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT stockId FROM stock";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();
        while (result.next()){
            idList.add(result.getString(1));
        }
        return idList;
    }


}


