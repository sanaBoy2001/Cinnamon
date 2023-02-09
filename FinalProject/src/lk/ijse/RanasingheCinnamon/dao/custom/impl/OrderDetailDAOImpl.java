package lk.ijse.RanasingheCinnamon.dao.custom.impl;


import lk.ijse.RanasingheCinnamon.dao.custom.OrderDetailDAO;
import lk.ijse.RanasingheCinnamon.dto.PlaceOrderDTO;
import lk.ijse.RanasingheCinnamon.utill.CrudUtil;

import java.sql.SQLException;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean detail(PlaceOrderDTO placeOrder) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO orderdetail VALUES (?,?)",
                placeOrder.getCId(),
                placeOrder.getoId()
        );
    }
    /*public boolean detail(PlaceOrderDTO placeOrder) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO orderdetail VALUES (?,?)",
                placeOrder.getCId(),
                placeOrder.getoId()
        );

    }*/
}
