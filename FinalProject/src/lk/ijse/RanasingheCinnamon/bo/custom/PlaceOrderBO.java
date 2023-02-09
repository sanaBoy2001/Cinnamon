package lk.ijse.RanasingheCinnamon.bo.custom;

import lk.ijse.RanasingheCinnamon.bo.SuperBO;
import lk.ijse.RanasingheCinnamon.dto.PlaceOrderDTO;

import java.sql.SQLException;

public interface PlaceOrderBO extends SuperBO {

    boolean orderPlace(PlaceOrderDTO placeOrder) throws SQLException, ClassNotFoundException;
}
