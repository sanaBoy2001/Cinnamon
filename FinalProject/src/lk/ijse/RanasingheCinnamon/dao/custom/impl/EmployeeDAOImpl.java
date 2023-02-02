package lk.ijse.RanasingheCinnamon.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.RanasingheCinnamon.to.Employee;
import lk.ijse.RanasingheCinnamon.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl {
    public static boolean save(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO employee VALUES (?,?,?,?,?,?)";
        return CrudUtil.execute(sql, employee.getId(), employee.getRole(), employee.getName(), employee.getNicNo(),employee.getAddress(),employee.getContactNo());
    }

    public static Employee searchEmployee(String ID) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM employee WHERE employeeId = '" +ID+ "'";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return new Employee(result.getString("employeeId"), result.getString("role"), result.getString("name"), result.getString("nicNo"), result.getString("address"),result.getString("contactNo"));
        }
        return null;

    }

    public static boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE employee SET role = ? , name = ? , nicNo = ? , address = ? ,contactNo = ? WHERE employeeId = ?";
        return CrudUtil.execute(sql, employee.getRole(), employee.getName(),employee.getNicNo(),employee.getAddress(),employee.getContactNo(),employee.getId());
    }

    public static boolean delete(String ID) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM employee WHERE employeeId = '"+ID+"'";
        return CrudUtil.execute(sql);
    }

    public static ArrayList<String> loadEmployeeId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT employeeId FROM employee";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();
        while (result.next()){
            idList.add(result.getString(1));
        }
        return idList;

    }

    public static ObservableList<Employee> searchAllEmployee() throws SQLException, ClassNotFoundException {

        ObservableList<Employee> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM employee";
        ResultSet result = CrudUtil.execute(sql);
        while (result.next()){
            Employee employee = new Employee(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6));
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
}