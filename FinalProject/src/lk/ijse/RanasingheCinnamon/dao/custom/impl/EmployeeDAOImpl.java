package lk.ijse.RanasingheCinnamon.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.RanasingheCinnamon.dao.custom.EmployeeDAO;
import lk.ijse.RanasingheCinnamon.dto.EmployeeDTO;
import lk.ijse.RanasingheCinnamon.entity.Employee;
import lk.ijse.RanasingheCinnamon.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean save(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO employee VALUES (?,?,?,?,?,?)";
        return CrudUtil.execute(sql, employee.getEmployeeId(), employee.getRole(), employee.getName(), employee.getNicNo(),employee.getAddress(),employee.getContactNo());
    }

    @Override
    public Employee search(String ID) throws SQLException, ClassNotFoundException { String sql = "SELECT * FROM employee WHERE employeeId = '" +ID+ "'";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
             new EmployeeDTO(result.getString("employeeId"), result.getString("role"), result.getString("name"), result.getString("nicNo"), result.getString("address"),result.getString("contactNo"));
        }
        return null;
    }

    @Override
    public boolean delete(String Id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM employee WHERE employeeId = '"+Id+"'";
        CrudUtil.execute(sql);

        return false;
    }

    @Override
    public boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE employee SET role = ? , name = ? , nicNo = ? , address = ? ,contactNo = ? WHERE employeeId = ?";
        return CrudUtil.execute(sql, employee.getRole(), employee.getName(),employee.getNicNo(),employee.getAddress(),employee.getContactNo(),employee.getEmployeeId());


    }
   /* public static boolean save(EmployeeDTO employee) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO employee VALUES (?,?,?,?,?,?)";
        return CrudUtil.execute(sql, employee.getId(), employee.getRole(), employee.getName(), employee.getNicNo(),employee.getAddress(),employee.getContactNo());
    }

    public static EmployeeDTO searchEmployee(String ID) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM employee WHERE employeeId = '" +ID+ "'";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return new EmployeeDTO(result.getString("employeeId"), result.getString("role"), result.getString("name"), result.getString("nicNo"), result.getString("address"),result.getString("contactNo"));
        }
        return null;

    }

    public static boolean update(EmployeeDTO employee) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE employee SET role = ? , name = ? , nicNo = ? , address = ? ,contactNo = ? WHERE employeeId = ?";
        return CrudUtil.execute(sql, employee.getRole(), employee.getName(),employee.getNicNo(),employee.getAddress(),employee.getContactNo(),employee.getId());
    }

    public static boolean delete(String ID) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM employee WHERE employeeId = '"+ID+"'";
        return CrudUtil.execute(sql);
    }*/

    /*public static ArrayList<String> loadEmployeeId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT employeeId FROM employee";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();
        while (result.next()){
            idList.add(result.getString(1));
        }
        return idList;

    }*/

    @Override
    public ObservableList<EmployeeDTO> searchAllEmployee() throws SQLException, ClassNotFoundException {

        ObservableList<EmployeeDTO> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM employee";
        ResultSet result = CrudUtil.execute(sql);
        while (result.next()){
            EmployeeDTO employee = new EmployeeDTO(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6));
            list.add(employee);
        }
        return list;

    }

    public static int employeeCount() throws SQLException, ClassNotFoundException {
        String sql = "SELECT COUNT(*) FROM employee";
        ResultSet execute = CrudUtil.execute(sql);
        int empCount = 0;
        if (execute.next()){
            empCount = execute.getInt(1);
        }
        return empCount;
    }

    @Override
    public ArrayList<String> loadEmployeeId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT employeeId FROM employee";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();
        while (result.next()){
            idList.add(result.getString(1));
        }
        return idList;
    }
}
