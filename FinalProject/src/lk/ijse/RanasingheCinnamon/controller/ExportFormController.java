package lk.ijse.RanasingheCinnamon.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import lk.ijse.RanasingheCinnamon.bo.BOFactory;
import lk.ijse.RanasingheCinnamon.bo.SuperBO;
import lk.ijse.RanasingheCinnamon.bo.custom.DeliveriesBO;
import lk.ijse.RanasingheCinnamon.bo.custom.EmployeeBO;
import lk.ijse.RanasingheCinnamon.bo.custom.ExportBO;
import lk.ijse.RanasingheCinnamon.dao.custom.impl.ExportDAOImpl;
import lk.ijse.RanasingheCinnamon.dao.custom.impl.StockDAOImpl;
import lk.ijse.RanasingheCinnamon.dto.DeliveriesDTO;
import lk.ijse.RanasingheCinnamon.dto.ExportDTO;
import lk.ijse.RanasingheCinnamon.entity.Export;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ExportFormController implements Initializable {
    public TableView tblManageExports;
   
    public JFXTextField txtExportId;
    public JFXTextField txtDate;
    public ComboBox cmbStockId;
    public ComboBox cmbOrderId;
    public JFXTextField txtCountry;
    public JFXTextField txtStatus;

    private final ExportBO exportBO = (ExportBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EXPORT);

    public void initialize(URL location, ResourceBundle resources) {

        loadStockIds();
    }
    private void loadStockIds(){ //stocks ids load dto export
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            //ArrayList<String> idList = StockDAOImpl.loadstockId();
            ArrayList<String> idList = exportBO.loadStockIds();

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

        //ExportDTO export = new ExportDTO(Id,date,country,status);

//        boolean isAdded = ExportDAOImpl.save(export);
        boolean isAdded = exportBO.saveExport(new ExportDTO(Id,date, country, status));

        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "Added").show();
        }
        else {
            new Alert(Alert.AlertType.CONFIRMATION,"Unsuccessful");
        }
        clearTxt();

    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        //ExportDTO export= ExportDAOImpl.search(txtExportId.getText());
        
        ExportDTO export = exportBO.searchExport(txtExportId.getText());
                
        if(export!=null) {
            txtDate.setText(export.getDate());
            txtCountry.setText(export.getLocation());
            txtStatus.setText(export.getStatus());
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        //boolean isDelete =  ExportDAOImpl.delete(txtExportId.getText());

        boolean isDelete = exportBO.deleteExport(txtExportId.getText());

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

        //ExportDTO export = new ExportDTO(Id,date,country,status);

        //boolean isUpdate = ExportDAOImpl.update(export);

        boolean isUpdate = exportBO.updateExport(new ExportDTO(Id, date, country, status));

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
