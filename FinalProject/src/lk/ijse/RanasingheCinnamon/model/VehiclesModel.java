package lk.ijse.RanasingheCinnamon.model;

import lk.ijse.RanasingheCinnamon.to.Supplier;
import lk.ijse.RanasingheCinnamon.to.Vehicles;
import lk.ijse.RanasingheCinnamon.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehiclesModel {
    public static boolean save(Vehicles vehicles) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO vehicle VALUES (?,?,?,?)";
        return CrudUtil.execute(sql,vehicles.getId(),vehicles.getBrand(),vehicles.getFuelCapacity(),vehicles.getCapacity());

    }

    public static Vehicles search(String ID) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM vehicle WHERE vehicleId = '"+ID+"'";
        ResultSet result = CrudUtil.execute(sql);

        if(result.next()){
            return new Vehicles(result.getString("vehicleId"),result.getString("brand"), result.getString("fuelCapacity"),result.getString("capacity"));
        }
        return null;
    }

    public static boolean update(Vehicles vehicles) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE vehicle SET brand = ? , fuelCapacity = ? , capacity = ? WHERE vehicleId = ?";
        return CrudUtil.execute(sql, vehicles.getBrand(), vehicles.getFuelCapacity(), vehicles.getCapacity(), vehicles.getId());
    }

    public static boolean delete(String ID) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM vehicle WHERE vehicleId = '"+ID+"'";
        return CrudUtil.execute(sql);
    }

    public static int VehicleCount() throws SQLException, ClassNotFoundException {
        String sql = "SELECT COUNT(*) FROM vehicle";
        ResultSet execute = CrudUtil.execute(sql);
        int vehicleCount = 0;
        if (execute.next()){
            vehicleCount = execute.getInt(1);
        }
        return vehicleCount;
    }

    public static ArrayList<String> loadVehicleId() throws SQLException, ClassNotFoundException {
        String sql ="SELECT vehicleId FROM vehicle";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();
        while (result.next()){
            idList.add(result.getString(1));
        }
        return idList;
    }
    }

