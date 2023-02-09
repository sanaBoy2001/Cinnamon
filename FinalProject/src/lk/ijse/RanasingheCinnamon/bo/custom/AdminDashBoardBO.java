package lk.ijse.RanasingheCinnamon.bo.custom;

import lk.ijse.RanasingheCinnamon.bo.SuperBO;

import java.sql.SQLException;

public interface AdminDashBoardBO extends SuperBO {

    int allCustomers() throws SQLException, ClassNotFoundException;
}
