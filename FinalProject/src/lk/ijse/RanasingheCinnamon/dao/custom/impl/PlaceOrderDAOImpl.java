package lk.ijse.RanasingheCinnamon.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.RanasingheCinnamon.db.DBConnection;
import lk.ijse.RanasingheCinnamon.dto.PlaceOrderDTO;
import lk.ijse.RanasingheCinnamon.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceOrderDAOImpl { //transaction (Updates orders,payment,customer tables)
    public static boolean orderPlace(PlaceOrderDTO placeOrder) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean add = PlaceOrderDAOImpl.addCustomer(placeOrder);
            if (add) {
                boolean isadd = OrdersDAOImpl.addOrder(placeOrder);
                if (isadd) {
                    boolean pay = PaymentsDAOImpl.addTotal(placeOrder);
                    if (pay) {
                        boolean Details = OrderDetailDAOImpl.detail(placeOrder);
                        if (Details) {
                            DBConnection.getInstance().getConnection().commit();
                            return true;
                        }
                    }
                    DBConnection.getInstance().getConnection().rollback();
                    return false;
                }

            }

        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
        return false;
    }

    public static boolean addCustomer(PlaceOrderDTO placeOrder) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO customer VALUES (?,?,?,?)",
                placeOrder.getCId(),
                placeOrder.getName(),
                placeOrder.getAddress(),
                placeOrder.getContact()
                );
    }

    public static int customerCount() throws SQLException, ClassNotFoundException {
        String sql = "SELECT COUNT(*) FROM customer";
        ResultSet execute = CrudUtil.execute(sql);
        int count = 0;
        if (execute.next()){
            count = execute.getInt(1);
        }
        return count;
    }

    public static ObservableList<PlaceOrderDTO> searchAllCustomer() throws SQLException, ClassNotFoundException {
        ObservableList<PlaceOrderDTO> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM customer";
        ResultSet result = CrudUtil.execute(sql);
        while (result.next()){
            PlaceOrderDTO customer = new PlaceOrderDTO(result.getString(1), result.getString("name"), result.getString("address"), result.getString("contactNo"));
            list.add(customer);
        }
        return list;
    }

    public static PlaceOrderDTO searchCustomer(String ID) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM customer WHERE cusId = '" +ID+ "'";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return new PlaceOrderDTO(result.getString("cusId"), result.getString("name"), result.getString("address"), result.getString("contactNo"));
        }
        return null;
    }
}
