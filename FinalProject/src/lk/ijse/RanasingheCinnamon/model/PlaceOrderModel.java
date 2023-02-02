package lk.ijse.RanasingheCinnamon.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.RanasingheCinnamon.db.DBConnection;
import lk.ijse.RanasingheCinnamon.to.PlaceOrder;
import lk.ijse.RanasingheCinnamon.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceOrderModel { //transaction (Updates orders,payment,customer tables)
    public static boolean orderPlace(PlaceOrder placeOrder) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean add = PlaceOrderModel.addCustomer(placeOrder);
            if (add) {
                boolean isadd = OrdersModel.addOrder(placeOrder);
                if (isadd) {
                    boolean pay = PaymentsModel.addTotal(placeOrder);
                    if (pay) {
                        boolean Details = OrderDetailModel.detail(placeOrder);
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

    public static boolean addCustomer(PlaceOrder placeOrder) throws SQLException, ClassNotFoundException {
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

    public static ObservableList<PlaceOrder> searchAllCustomer() throws SQLException, ClassNotFoundException {
        ObservableList<PlaceOrder> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM customer";
        ResultSet result = CrudUtil.execute(sql);
        while (result.next()){
            PlaceOrder customer = new PlaceOrder(result.getString(1), result.getString("name"), result.getString("address"), result.getString("contactNo"));
            list.add(customer);
        }
        return list;
    }

    public static PlaceOrder searchCustomer(String ID) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM customer WHERE cusId = '" +ID+ "'";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return new PlaceOrder(result.getString("cusId"), result.getString("name"), result.getString("address"), result.getString("contactNo"));
        }
        return null;
    }
}
