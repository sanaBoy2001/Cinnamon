package lk.ijse.RanasingheCinnamon.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.RanasingheCinnamon.bo.BOFactory;
import lk.ijse.RanasingheCinnamon.bo.SuperBO;
import lk.ijse.RanasingheCinnamon.bo.custom.EmployeeBO;
import lk.ijse.RanasingheCinnamon.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.RanasingheCinnamon.dto.EmployeeDTO;
import lk.ijse.RanasingheCinnamon.entity.Employee;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ManageEmployeeFormController implements Initializable {
    public JFXTextField txtEmployeeId;
    public JFXTextField txtRole;
    public JFXTextField txtName;
    public JFXTextField txtNicNo;
    public TableView tblManageEmployee;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNo;
    public TableColumn tblEmployeeId;
    public TableColumn tblName;
    public TableColumn tblRole;
    public TableColumn tblNicNo;
    public TableColumn tblAddress;
    public TableColumn tblContactNo;
    
    private final EmployeeBO employeeBO = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);

    public void initialize (URL location, ResourceBundle resources){
        loadEmployeeData();
        setCellValueFactory();
    }

    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String Id = txtEmployeeId.getText();
        String role = txtRole.getText();
        String name = txtName.getText();
        String nicNo = txtNicNo.getText();
        String address = txtAddress.getText();
        String contactNo = txtContactNo.getText();

        EmployeeDTO employee = new EmployeeDTO(Id,role,name,nicNo,address,contactNo);

//        boolean isAdded = EmployeeDAOImpl.save(employee);
        boolean isAdded = employeeBO.addEmployee(new EmployeeDTO(Id, role, name, nicNo, address, contactNo));

        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "EmployeeDTO Added").show();
        }
        else {
            new Alert(Alert.AlertType.CONFIRMATION,"Unsuccessful");
        }
        clearTxt();
    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        
//        EmployeeDTO employee = EmployeeDAOImpl.searchEmployee(txtEmployeeId.getText());

        EmployeeDTO employee = employeeBO.searchEmployee(txtEmployeeId.getText());

        if (employee != null) {
            txtRole.setText(employee.getRole());
            txtName.setText(employee.getName());
            txtNicNo.setText(employee.getNicNo());
            txtAddress.setText(employee.getAddress());
            txtContactNo.setText(employee.getContactNo());
        }
    }

        public void btnUpdateOnAction (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
            String Id = txtEmployeeId.getText();
            String role = txtRole.getText();
            String name = txtName.getText();
            String nicNo = txtNicNo.getText();
            String address = txtAddress.getText();
            String contactNo = txtContactNo.getText();

//            EmployeeDTO employee = new EmployeeDTO(Id,role,name,nicNo,address,contactNo);

//            boolean isUpdate = EmployeeDAOImpl.update(employee);
            boolean isUpdate = employeeBO.updateEmployee(new EmployeeDTO(Id, role, name, nicNo, address, contactNo));

            if(isUpdate){
                new Alert(Alert.AlertType.CONFIRMATION,"Details Updated").show();
            }else {
                new Alert(Alert.AlertType.CONFIRMATION,"Something Was Wrong").show();
            }
            clearTxt();
        }

    public void btnDeleteOnAction (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
//        boolean isDelete =  EmployeeDAOImpl.delete(txtEmployeeId.getText());
        boolean isDelete = employeeBO.deleteEmployee(txtEmployeeId.getText());

        if(isDelete){
            new Alert(Alert.AlertType.CONFIRMATION,"EmployeeDTO Delete Successful").show();
        }
        clearTxt();
    }

    public void loadEmployeeData(){
        try {
//            ObservableList<EmployeeDTO> employee = EmployeeDAOImpl.searchAllEmployee();
            ObservableList<EmployeeDTO> employeeDTOS = employeeBO.allEmployee();
            tblManageEmployee.setItems(employeeDTOS);
        }catch (Exception e){

        }

    }
    public void setCellValueFactory(){
        tblEmployeeId.setCellValueFactory(new PropertyValueFactory("employeeId"));
        tblName.setCellValueFactory(new PropertyValueFactory("name"));
        tblRole.setCellValueFactory(new PropertyValueFactory("role"));
        tblNicNo.setCellValueFactory(new PropertyValueFactory("nicNo"));
        tblAddress.setCellValueFactory(new PropertyValueFactory("address"));
        tblContactNo.setCellValueFactory(new PropertyValueFactory("contactNo"));
    }

        private void clearTxt () {
            txtEmployeeId.setText("");
            txtRole.setText("");
            txtName.setText("");
            txtNicNo.setText("");
            txtAddress.setText("");
            txtContactNo.setText("");
        }

}
