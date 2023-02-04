package lk.ijse.RanasingheCinnamon.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.RanasingheCinnamon.bo.SuperBO;
import lk.ijse.RanasingheCinnamon.dto.EmployeeDTO;
import lk.ijse.RanasingheCinnamon.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

public interface EmployeeBO extends SuperBO {

    boolean addEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;

    EmployeeDTO searchEmployee(String s) throws SQLException, ClassNotFoundException;

    boolean deleteEmployee(String Id) throws SQLException, ClassNotFoundException;

    boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException;

    ObservableList<EmployeeDTO> allEmployee() throws SQLException, ClassNotFoundException;

}
