package lk.ijse.RanasingheCinnamon.model;


import lk.ijse.RanasingheCinnamon.to.PlaceOrder;
import lk.ijse.RanasingheCinnamon.utill.CrudUtil;

import java.sql.SQLException;

public class OrderDetailModel {
    public static boolean detail(PlaceOrder placeOrder) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO orderdetail VALUES (?,?)",
                placeOrder.getCId(),
                placeOrder.getoId()
        );

    }
}
