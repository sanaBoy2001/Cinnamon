package lk.ijse.RanasingheCinnamon.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.RanasingheCinnamon.dao.custom.DeliveriesDAO;
import lk.ijse.RanasingheCinnamon.dto.DeliveriesDTO;
import lk.ijse.RanasingheCinnamon.entity.Transport;
import lk.ijse.RanasingheCinnamon.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveriesDAOImpl implements DeliveriesDAO {
    @Override
    public boolean save(Transport deliveries) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Transport VALUES (?,?,?,?,?,?)", deliveries.getTransportId(), deliveries.getOrderId(), deliveries.getEmployeeId(), deliveries.getVehicleId(), deliveries.getDistance(), deliveries.getRoute());

    }

    @Override
    public Transport search(String s) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Transport WHERE transportId = '" + s + "'");

        if (result.next()) {
            new DeliveriesDTO(result.getString("transportId"), result.getString("orderId"), result.getString("employeeId"), result.getString("vehicleId"), result.getString("distance"), result.getString("route"));
        }
        return null;
    }

    @Override
    public boolean delete(String Id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Transport WHERE transportId = '"+Id+"'");

    }

    @Override
    public boolean update(Transport deliveries) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Transport SET orderId = ? , employeeId = ? , vehicleId = ? , distance = ? , route = ? WHERE transportId = ?", deliveries.getOrderId(), deliveries.getEmployeeId(), deliveries.getVehicleId() ,deliveries.getDistance(), deliveries.getRoute(), deliveries.getTransportId());

    }



//    public static boolean save(DeliveriesDTO deliveries) throws SQLException, ClassNotFoundException {
//        String sql = "INSERT INTO Transport VALUES (?,?,?,?,?,?)";
//        return CrudUtil.execute(sql,deliveries.getId(),deliveries.getOrderId(),deliveries.getEmployeeId(),deliveries.getVehicleId(),deliveries.getDistance(),deliveries.getRoute());
//
//    }
//
//    public static DeliveriesDTO search(String ID) throws SQLException, ClassNotFoundException {
//        String sql = "SELECT * FROM Transport WHERE transportId = '"+ID+"'";
//        ResultSet result = CrudUtil.execute(sql);
//
//        if(result.next()){
//            return new DeliveriesDTO(result.getString("transportId"),result.getString("orderId"), result.getString("employeeId"),result.getString("vehicleId"),result.getString("distance"),result.getString("route"));
//        }
//        return null;
//    }
//
//    public static boolean delete(String Id) throws SQLException, ClassNotFoundException {
//        String sql = "DELETE FROM Transport WHERE transportId = '"+Id+"'";
//        return CrudUtil.execute(sql);
//    }
//
//    public static boolean update(DeliveriesDTO deliveries) throws SQLException, ClassNotFoundException {
//        String sql = "UPDATE Transport SET orderId = ? , employeeId = ? , vehicleId = ? , distance = ? , route = ? WHERE transportId = ?";
//        return CrudUtil.execute(sql, deliveries.getOrderId(), deliveries.getEmployeeId(), deliveries.getVehicleId() ,deliveries.getDistance(), deliveries.getRoute(), deliveries.getId());
//    }
}
