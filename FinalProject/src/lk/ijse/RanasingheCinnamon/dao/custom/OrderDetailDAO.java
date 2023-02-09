package lk.ijse.RanasingheCinnamon.dao.custom;

import lk.ijse.RanasingheCinnamon.dao.SuperDAO;
import lk.ijse.RanasingheCinnamon.dto.PlaceOrderDTO;

import java.sql.SQLException;


public interface OrderDetailDAO extends SuperDAO{
    boolean detail(PlaceOrderDTO placeOrder) throws SQLException, ClassNotFoundException;
}
