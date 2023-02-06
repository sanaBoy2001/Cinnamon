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
import lk.ijse.RanasingheCinnamon.dao.custom.impl.DeliveriesDAOImpl;
import lk.ijse.RanasingheCinnamon.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.RanasingheCinnamon.dao.custom.impl.OrdersDAOImpl;
import lk.ijse.RanasingheCinnamon.dao.custom.impl.VehiclesDAOImpl;
import lk.ijse.RanasingheCinnamon.dto.DeliveriesDTO;
import lk.ijse.RanasingheCinnamon.entity.Transport;

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

    private final DeliveriesBO deliveriesBO = (DeliveriesBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.DELIVERIES);

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        loadOrderId();
        loadEmployeeId();
        loadVehicleId();
    }


    private void loadOrderId() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            //ArrayList<String> idList = OrdersDAOImpl.loadOrderId();
            ArrayList<String> idList = deliveriesBO.loadOrderId();
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
            //ArrayList<String> idList = EmployeeDAOImpl.loadEmployeeId();
            ArrayList<String> idList = deliveriesBO.loadEmployeeId();
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
            //ArrayList<String> idList = VehiclesDAOImpl.loadVehicleId();
            ArrayList<String> idList = deliveriesBO.loadVehicleId();

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


        //DeliveriesDTO deliveries = new DeliveriesDTO(Id,orderId,employeeId,vehicleId,distance,route);

        //boolean isAdded = DeliveriesDAOImpl.save(deliveries);

        boolean isAdded = deliveriesBO.addDeliver(new DeliveriesDTO(Id, orderId, employeeId, vehicleId, distance, route));

        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "Deliverie Added").show();
        }
        else {
            new Alert(Alert.AlertType.CONFIRMATION,"Unsuccessful");
        }
        clearTxt();
    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        DeliveriesDTO deliveries = deliveriesBO.seacrhDeliver(txtDeliverId.getText());

        //DeliveriesDTO deliveries= DeliveriesDAOImpl.search(txtDeliverId.getText());
        if(deliveries!=null) {
            cmbOrderId.setValue(deliveries.getOrderId());
            cmbEmployeeId.setValue(deliveries.getEmployeeId());
            cmbVehicleId.setValue(deliveries.getVehicleId());
            txtDistance.setText(deliveries.getDistance());
            txtRoute.setText(deliveries.getRoute());
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        //boolean isDelete =  DeliveriesDAOImpl.delete(txtDeliverId.getText());

        boolean isDelete = deliveriesBO.deleteDeliver(txtDeliverId.getText());

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

        //DeliveriesDTO deliveries = new DeliveriesDTO(Id,orderId,employeeId,vehicleId, distance, route);

        //boolean isUpdate = DeliveriesDAOImpl.update(deliveries);

        boolean isUpdate = deliveriesBO.updateDeliver(new DeliveriesDTO(Id, orderId, employeeId, vehicleId, distance, route));

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
