package lk.ijse.RanasingheCinnamon.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.RanasingheCinnamon.bo.custom.EmployeeBO;
import lk.ijse.RanasingheCinnamon.dao.DAOFactory;
import lk.ijse.RanasingheCinnamon.dao.custom.EmployeeDAO;
import lk.ijse.RanasingheCinnamon.dto.EmployeeDTO;
import lk.ijse.RanasingheCinnamon.entity.Employee;

import java.sql.SQLException;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    @Override
    public boolean addEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return employeeDAO.save(new Employee(employeeDTO.getId(),employeeDTO.getRole(),employeeDTO.getName(),employeeDTO.getNicNo(),employeeDTO.getAddress(),employeeDTO.getContactNo()));
    }

    @Override
    public EmployeeDTO searchEmployee(String s) throws SQLException, ClassNotFoundException {
        Employee employee = employeeDAO.search(s);
        return new EmployeeDTO(employee.getEmployeeId(),employee.getRole(),employee.getName(),employee.getNicNo(),employee.getAddress(),employee.getContactNo());
    }

    @Override
    public boolean deleteEmployee(String Id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(Id);
    }

    @Override
    public boolean updateEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(new Employee(employeeDTO.getId(),employeeDTO.getRole(),employeeDTO.getName(),employeeDTO.getNicNo(),employeeDTO.getAddress(),employeeDTO.getContactNo()));
    }

    @Override
    public ObservableList<EmployeeDTO> allEmployee() throws SQLException, ClassNotFoundException {
        return employeeDAO.searchAllEmployee();
    }

}
