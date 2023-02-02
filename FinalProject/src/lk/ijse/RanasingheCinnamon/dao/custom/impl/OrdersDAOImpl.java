package lk.ijse.RanasingheCinnamon.dao.custom.impl;


import lk.ijse.RanasingheCinnamon.to.PlaceOrder;
import lk.ijse.RanasingheCinnamon.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class OrdersDAOImpl {

    public static boolean addOrder(PlaceOrder placeOrder) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO orders VALUES (?,?,?,?,?)",
                placeOrder.getoId(),
                placeOrder.getCId(),
                placeOrder.getDate(),
                placeOrder.getDetails(),
                placeOrder.getQty()
                );
    }

        public static ArrayList<String> loadOrderId() throws SQLException, ClassNotFoundException {
            String sql ="SELECT orderId FROM orders";
            ResultSet result = CrudUtil.execute(sql);

            ArrayList<String> idList = new ArrayList<>();
            while (result.next()){
                idList.add(result.getString(1));
            }
            return idList;}
    }
