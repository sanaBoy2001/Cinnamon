package lk.ijse.RanasingheCinnamon.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import lk.ijse.RanasingheCinnamon.model.ExportModel;
import lk.ijse.RanasingheCinnamon.model.StockModel;
import lk.ijse.RanasingheCinnamon.model.SupplierModel;
import lk.ijse.RanasingheCinnamon.to.Export;
import lk.ijse.RanasingheCinnamon.to.Supplier;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;

public class ExportFormController implements Initializable {
    public TableView tblManageExports;
   
    public JFXTextField txtExportId;
    public JFXTextField txtDate;
    public ComboBox cmbStockId;
    public ComboBox cmbOrderId;
    public JFXTextField txtCountry;
    public JFXTextField txtStatus;

    public void initialize(URL location, ResourceBundle resources) {

        loadStockIds();
    }
    private void loadStockIds(){ //stocks ids load to export
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = StockModel.loadstockId();

            for(String id : idList){
                observableList.add(id);
            }
            cmbStockId.setItems(observableList);
        }catch (Exception ex){

        }

    }

    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String Id = txtExportId.getText();
        String date = txtDate.getText();
        String country = txtCountry.getText();
        String status = txtStatus.getText();

        Export export = new Export(Id,date,country,status);

        boolean isAdded = ExportModel.save(export);

        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "Added").show();
        }
        else {
            new Alert(Alert.AlertType.CONFIRMATION,"Unsuccessful");
        }
        clearTxt();

    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Export export= ExportModel.search(txtExportId.getText());
        if(export!=null) {
            txtDate.setText(export.getDate());
            txtCountry.setText(export.getLocation());
            txtStatus.setText(export.getStatus());
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDelete =  ExportModel.delete(txtExportId.getText());

        if(isDelete){
            new Alert(Alert.AlertType.CONFIRMATION,"Delete Successful").show();
        }
        clearTxt();
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String Id = txtExportId.getText();
        String date = txtDate.getText();
        String country = txtCountry.getText();
        String status = txtStatus.getText();

        Export export = new Export(Id,date,country,status);

        boolean isUpdate = ExportModel.update(export);

        if(isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION,"Details Updated").show();
        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Something Was Wrong").show();
        }
        clearTxt();
    }
    private void clearTxt() {
        txtExportId.setText("");
        txtDate.setText("");
        txtCountry.setText("");
        txtStatus.setText("");
    }
}
