package lk.ijse.RanasingheCinnamon.dao.custom.impl;


import lk.ijse.RanasingheCinnamon.to.PlaceOrder;
import lk.ijse.RanasingheCinnamon.utill.CrudUtil;

import java.sql.SQLException;

public class OrderDetailDAOImpl {
    public static boolean detail(PlaceOrder placeOrder) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO orderdetail VALUES (?,?)",
                placeOrder.getCId(),
                placeOrder.getoId()
        );

    }
}