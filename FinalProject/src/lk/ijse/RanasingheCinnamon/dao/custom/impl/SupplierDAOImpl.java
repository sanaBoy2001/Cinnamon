package lk.ijse.RanasingheCinnamon.dao.custom.impl;

import lk.ijse.RanasingheCinnamon.dto.SupplierDTO;
import lk.ijse.RanasingheCinnamon.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierDAOImpl {
    public static boolean save(SupplierDTO supplier) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO supplier VALUES (?,?,?,?,?,?)";
        return CrudUtil.execute(sql,supplier.getId(),supplier.getName(),supplier.getAddress(),supplier.getContactNo(),supplier.getSuppliedQty(),supplier.getCost());
    }

    public static SupplierDTO search(String ID) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM supplier WHERE supplierId = '"+ID+"'";
        ResultSet result = CrudUtil.execute(sql);

        if(result.next()){
            return new SupplierDTO(result.getString("supplierId"),result.getString("name"), result.getString("address"),result.getString("contactNo"),result.getString("suppliedQty"),result.getDouble("Cost"));
        }
        return null;
    }

    public static boolean update(SupplierDTO supplier) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE supplier SET name = ? , address = ? , contactNo = ? , suppliedQty = ? , Cost = ? WHERE supplierId = ?";
        return CrudUtil.execute(sql, supplier.getName(), supplier.getAddress(), supplier.getContactNo() , supplier.getSuppliedQty() , supplier.getCost() , supplier.getId());
    }

    public static boolean delete(String Id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM supplier WHERE supplierId = '"+Id+"'";
        return CrudUtil.execute(sql);
    }

    public static int supplierCount() throws SQLException, ClassNotFoundException {
        String sql = "SELECT COUNT(*) FROM supplier";
        ResultSet execute = CrudUtil.execute(sql);
        int supCount = 0;
        if (execute.next()){
            supCount = execute.getInt(1);
        }
        return supCount;
    }
}
