package lk.ijse.RanasingheCinnamon.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import lk.ijse.RanasingheCinnamon.model.*;
import lk.ijse.RanasingheCinnamon.to.Deliveries;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DeliveriesFormController implements Initializable {
    public JFXTextField txtDeliverId;
    public JFXTextField txtDistance;
    public JFXTextField txtRoute;
    public TableView tblManageDeliveries;
    public ComboBox cmbEmployeeId;
    public ComboBox cmbVehicleId;
    public ComboBox cmbOrderId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadOrderId();
        loadEmployeeId();
        loadVehicleId();
    }


    private void loadOrderId() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = OrdersModel.loadOrderId();

            for (String id : idList) {
                observableList.add(id);
            }
            cmbOrderId.setItems(observableList);
        } catch (Exception e) {
        }
    }

    private void loadEmployeeId() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = EmployeeModel.loadEmployeeId();

            for (String id : idList) {
                observableList.add(id);
            }
            cmbEmployeeId.setItems(observableList);
        } catch (Exception e) {
        }
    }

    private void loadVehicleId() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = VehiclesModel.loadVehicleId();

            for (String id : idList) {
                observableList.add(id);
            }
            cmbVehicleId.setItems(observableList);
        } catch (Exception e) {
        }
    }

    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String Id = txtDeliverId.getText();
        String orderId = String.valueOf(cmbOrderId.getValue());
        String employeeId = String.valueOf(cmbEmployeeId.getValue());
        String vehicleId = String.valueOf(cmbVehicleId.getValue());
        String distance = txtDistance.getText();
        String route = txtRoute.getText();


        Deliveries deliveries = new Deliveries(Id,orderId,employeeId,vehicleId,distance,route);

        boolean isAdded = DeliveriesModel.save(deliveries);

        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "Deliverie Added").show();
        }
        else {
            new Alert(Alert.AlertType.CONFIRMATION,"Unsuccessful");
        }
        clearTxt();
    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Deliveries deliveries= DeliveriesModel.search(txtDeliverId.getText());
        if(deliveries!=null) {
            cmbOrderId.setValue(deliveries.getOrderId());
            cmbEmployeeId.setValue(deliveries.getEmployeeId());
            cmbVehicleId.setValue(deliveries.getVehicleId());
            txtDistance.setText(deliveries.getDistance());
            txtRoute.setText(deliveries.getRoute());
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDelete =  DeliveriesModel.delete(txtDeliverId.getText());

        if(isDelete){
            new Alert(Alert.AlertType.CONFIRMATION,"Deliver Delete Successful").show();
        }
        clearTxt();
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String Id = txtDeliverId.getText();
        String orderId = String.valueOf(cmbOrderId.getValue());
        String employeeId = String.valueOf(cmbEmployeeId.getValue());
        String vehicleId = String.valueOf(cmbVehicleId.getValue());
        String distance = txtDistance.getText();
        String route = txtRoute.getText();

        Deliveries deliveries = new Deliveries(Id,orderId,employeeId,vehicleId, distance, route);

        boolean isUpdate = DeliveriesModel.update(deliveries);

        if(isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION,"Details Updated").show();
        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Something Was Wrong").show();
        }
        clearTxt();
    }
    private void clearTxt() {
        txtDeliverId.setText("");
        txtDistance.setText("");
        txtRoute.setText("");
        cmbOrderId.setValue("");
        cmbEmployeeId.setValue("");
        cmbVehicleId.setValue("");

    }


}
