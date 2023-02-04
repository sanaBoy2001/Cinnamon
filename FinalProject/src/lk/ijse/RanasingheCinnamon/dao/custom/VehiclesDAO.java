package lk.ijse.RanasingheCinnamon.dao.custom;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehiclesDAO {
    ArrayList<String> loadVehicleId() throws SQLException, ClassNotFoundException;
}
