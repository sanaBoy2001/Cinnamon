package lk.ijse.RanasingheCinnamon.dao.custom.impl;

import lk.ijse.RanasingheCinnamon.to.PlaceOrder;
import lk.ijse.RanasingheCinnamon.utill.CrudUtil;

import java.sql.SQLException;

public class PaymentsDAOImpl {

    public static boolean addTotal(PlaceOrder placeOrder) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO payment VALUES (?,?,?)",
                placeOrder.getoId(),
                placeOrder.getDate(),
                placeOrder.getTotal()
        );
    }
}
