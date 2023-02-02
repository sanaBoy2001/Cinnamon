package lk.ijse.RanasingheCinnamon.model;

import lk.ijse.RanasingheCinnamon.to.Payments;
import lk.ijse.RanasingheCinnamon.to.PlaceOrder;
import lk.ijse.RanasingheCinnamon.to.Supplier;
import lk.ijse.RanasingheCinnamon.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentsModel {

    public static boolean addTotal(PlaceOrder placeOrder) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO payment VALUES (?,?,?)",
                placeOrder.getoId(),
                placeOrder.getDate(),
                placeOrder.getTotal()
        );
    }
}
