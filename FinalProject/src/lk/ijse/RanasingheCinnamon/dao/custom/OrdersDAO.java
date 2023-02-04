package lk.ijse.RanasingheCinnamon.dao.custom;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrdersDAO {
    ArrayList<String> loadOrderId() throws SQLException, ClassNotFoundException;
}
