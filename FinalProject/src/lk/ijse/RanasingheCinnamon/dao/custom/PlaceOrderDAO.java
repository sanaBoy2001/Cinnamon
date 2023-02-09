package lk.ijse.RanasingheCinnamon.dao.custom;

import lk.ijse.RanasingheCinnamon.dao.SuperDAO;
import lk.ijse.RanasingheCinnamon.dto.PlaceOrderDTO;

import java.sql.SQLException;

public interface PlaceOrderDAO extends SuperDAO {

    boolean addCustomer(PlaceOrderDTO placeOrder) throws SQLException, ClassNotFoundException;

    int customerCount() throws SQLException, ClassNotFoundException;
}
