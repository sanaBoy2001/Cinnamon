package lk.ijse.RanasingheCinnamon.bo.custom;

import lk.ijse.RanasingheCinnamon.bo.SuperBO;
import lk.ijse.RanasingheCinnamon.dto.DeliveriesDTO;
import lk.ijse.RanasingheCinnamon.entity.Transport;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DeliveriesBO extends SuperBO {
    boolean addDeliver(DeliveriesDTO deliveriesDTO) throws SQLException, ClassNotFoundException;

    DeliveriesDTO seacrhDeliver(String s) throws SQLException, ClassNotFoundException;

    boolean deleteDeliver(String Id) throws SQLException, ClassNotFoundException;

    boolean updateDeliver(Transport deliveries) throws SQLException, ClassNotFoundException;

    ArrayList<String> loadEmployeeId() throws SQLException, ClassNotFoundException;

    ArrayList<String> loadVehicleId() throws SQLException, ClassNotFoundException;

    ArrayList<String> loadOrderId() throws SQLException, ClassNotFoundException;

}
