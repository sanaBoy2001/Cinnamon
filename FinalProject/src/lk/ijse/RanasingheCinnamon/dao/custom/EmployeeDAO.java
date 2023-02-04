package lk.ijse.RanasingheCinnamon.dao.custom;

import lk.ijse.RanasingheCinnamon.dao.CrudDAO;
import lk.ijse.RanasingheCinnamon.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO extends CrudDAO<Employee, String> {

    ArrayList<String> loadEmployeeId() throws SQLException, ClassNotFoundException;

}
