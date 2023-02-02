package lk.ijse.RanasingheCinnamon.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.RanasingheCinnamon.dao.custom.impl.VehiclesDAOImpl;
import lk.ijse.RanasingheCinnamon.to.Vehicles;

import java.sql.SQLException;

public class VehiclesFormController {
    public JFXTextField txtVehicleId;
    public JFXTextField txtBrand;
    public JFXTextField txtFuelCapacity;
    public JFXTextField txtWeightLimit;


    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String Id = txtVehicleId.getText();
        String brand = txtBrand.getText();
        String fuelCapacity = txtFuelCapacity.getText();
        String capacity = txtWeightLimit.getText();

        Vehicles vehicles = new Vehicles(Id,brand,fuelCapacity,capacity);

        boolean isAdded = VehiclesDAOImpl.save(vehicles);

        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "Vehicle Added").show();
        }
        else {
            new Alert(Alert.AlertType.CONFIRMATION,"Unsuccessful");
        }
        clearTxt();
    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Vehicles vehicles= VehiclesDAOImpl.search(txtVehicleId.getText());
        if(vehicles!=null) {
            txtBrand.setText(vehicles.getBrand());
            txtFuelCapacity.setText(vehicles.getFuelCapacity());
            txtWeightLimit.setText(vehicles.getCapacity());
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String Id = txtVehicleId.getText();
        String brand = txtBrand.getText();
        String fuelCapacity = txtFuelCapacity.getText();
        String capacity = txtWeightLimit.getText();

        Vehicles vehicles = new Vehicles(Id,brand,fuelCapacity,capacity);

        boolean isUpdate = VehiclesDAOImpl.update(vehicles);

        if(isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION,"Details Updated").show();
        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Something Was Wrong").show();
        }
        clearTxt();
    }


    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDelete =  VehiclesDAOImpl.delete(txtVehicleId.getText());

        if(isDelete){
            new Alert(Alert.AlertType.CONFIRMATION,"Vehicle Delete Successful").show();
        }
        clearTxt();
    }

    private void clearTxt() {
        txtVehicleId.setText("");
        txtBrand.setText("");
        txtFuelCapacity.setText("");
        txtWeightLimit.setText("");
    }
}
