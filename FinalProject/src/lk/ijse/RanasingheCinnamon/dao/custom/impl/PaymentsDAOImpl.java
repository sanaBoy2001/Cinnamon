package lk.ijse.RanasingheCinnamon.dao.custom.impl;

import lk.ijse.RanasingheCinnamon.dto.PlaceOrderDTO;
import lk.ijse.RanasingheCinnamon.utill.CrudUtil;

import java.sql.SQLException;

public class PaymentsDAOImpl {

    public static boolean addTotal(PlaceOrderDTO placeOrder) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO payment VALUES (?,?,?)",
                placeOrder.getoId(),
                placeOrder.getDate(),
                placeOrder.getTotal()
        );
    }
}
