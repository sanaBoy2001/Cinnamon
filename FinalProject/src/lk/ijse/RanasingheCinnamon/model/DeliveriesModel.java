package lk.ijse.RanasingheCinnamon.model;

import lk.ijse.RanasingheCinnamon.to.Deliveries;
import lk.ijse.RanasingheCinnamon.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveriesModel {
    public static boolean save(Deliveries deliveries) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO transport VALUES (?,?,?,?,?,?)";
        return CrudUtil.execute(sql,deliveries.getId(),deliveries.getOrderId(),deliveries.getEmployeeId(),deliveries.getVehicleId(),deliveries.getDistance(),deliveries.getRoute());

    }

    public static Deliveries search(String ID) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM transport WHERE transportId = '"+ID+"'";
        ResultSet result = CrudUtil.execute(sql);

        if(result.next()){
            return new Deliveries(result.getString("transportId"),result.getString("orderId"), result.getString("employeeId"),result.getString("vehicleId"),result.getString("distance"),result.getString("route"));
        }
        return null;
    }

    public static boolean delete(String Id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM transport WHERE transportId = '"+Id+"'";
        return CrudUtil.execute(sql);
    }

    public static boolean update(Deliveries deliveries) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE transport SET orderId = ? , employeeId = ? , vehicleId = ? , distance = ? , route = ? WHERE transportId = ?";
        return CrudUtil.execute(sql, deliveries.getOrderId(), deliveries.getEmployeeId(), deliveries.getVehicleId() ,deliveries.getDistance(), deliveries.getRoute(), deliveries.getId());
    }
}
