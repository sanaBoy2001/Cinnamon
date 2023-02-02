package lk.ijse.RanasingheCinnamon.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import lk.ijse.RanasingheCinnamon.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.RanasingheCinnamon.dto.SupplierDTO;

import java.sql.SQLException;

public class SupplierFormController {
    public JFXTextField txtSupplierId;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public TableView tblManageSupplier;
    public JFXTextField txtContactNo;
    public JFXTextField txtQty;
    public JFXTextField txtCost;
    public Text txtBuyRate;

    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String Id = txtSupplierId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contactNo = txtContactNo.getText();
        String suppliedQty = txtQty.getText();
        Double cost = Double.valueOf(txtCost.getText());

        SupplierDTO supplier = new SupplierDTO(Id,name,address,contactNo,suppliedQty,cost);

        boolean isAdded = SupplierDAOImpl.save(supplier);

        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "SupplierDTO Added").show();
        }
        else {
            new Alert(Alert.AlertType.CONFIRMATION,"Unsuccessful");
        }
        clearTxt();
    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        SupplierDTO supplier= SupplierDAOImpl.search(txtSupplierId.getText());
        if(supplier!=null) {
            txtName.setText(supplier.getName());
            txtAddress.setText(supplier.getAddress());
            txtContactNo.setText(supplier.getContactNo());
            txtQty.setText(supplier.getSuppliedQty());
            txtCost.setText(String.valueOf(supplier.getCost()));
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String Id = txtSupplierId.getText();
        String Name = txtName.getText();
        String Address = txtAddress.getText();
        String contactNo = txtContactNo.getText();
        String suppliedQty = txtQty.getText();
        Double cost = Double.valueOf(txtCost.getText());


        SupplierDTO supplier = new SupplierDTO(Id,Name,Address,contactNo,suppliedQty,cost);

        boolean isUpdate = SupplierDAOImpl.update(supplier);

        if(isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION,"Details Updated").show();
        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Something Was Wrong").show();
        }
        clearTxt();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDelete =  SupplierDAOImpl.delete(txtSupplierId.getText());

        if(isDelete){
            new Alert(Alert.AlertType.CONFIRMATION,"SupplierDTO Delete Successful").show();
        }
        clearTxt();
    }

    private void clearTxt() {
        txtSupplierId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtContactNo.setText("");
        txtQty.setText("");
        txtCost.setText("");
    }
}
