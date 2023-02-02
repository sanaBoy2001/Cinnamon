package lk.ijse.RanasingheCinnamon.controller;


import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import lk.ijse.RanasingheCinnamon.model.EmployeeModel;
import lk.ijse.RanasingheCinnamon.model.PlaceOrderModel;
import lk.ijse.RanasingheCinnamon.to.Employee;
import lk.ijse.RanasingheCinnamon.to.PlaceOrder;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PlaceOrderFormController implements Initializable {
    public TextField txtQty;
    public Text txtTotal;
    public Text txtCash;
    public Text txtBalance;
    public JFXTextField txtDetails;
    public JFXTextField txtCash1;
    public Text txtTotal1;
    public Text txtBalance1;
    public JFXTextField txtOrderId;
    public JFXTextField txtDate;

    public JFXTextField txtAddress;
    public JFXTextField txtCustomerId;
    public JFXTextField txtName;
    public JFXTextField txtContactNo;
    public TableColumn tblCusId;
    public TableColumn tblOrderId;
    public TableColumn tblDetails;
    public TableColumn tblQty;
    public TableColumn tblTotal;
    public TableColumn tblCash;
    public TableColumn tblBalance;
    public TableView tblAllData;


    public void initialize(URL location, ResourceBundle resources) {
        setCellValueFactory();
        loadCustomerData();

    }


    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
        try {
        String CId = txtCustomerId.getText();
        String Name = txtName.getText();
        String Address = txtAddress.getText();
        String ContactNo = txtContactNo.getText();

        String OId = txtOrderId.getText();
        String Date = txtDate.getText();
        String Details = txtDetails.getText();
        String Qty = txtQty.getText();

        Double total = Double.valueOf(txtTotal1.getText());

        PlaceOrder placeOrder = new PlaceOrder(CId, Name, Address, ContactNo, OId, Date, Details, Qty, total);


            boolean isAdd = PlaceOrderModel.orderPlace(placeOrder);
            if (isAdd) {
                new Alert(Alert.AlertType.CONFIRMATION, "added Success").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Unsuccessfull").show();
            }
        }catch (Exception throwables){
            System.out.println(throwables);
        }

        try {
            JasperDesign load = JRXmlLoader.load(getClass().getResourceAsStream("/lk/ijse/RanasingheCinnamon/view/Report/Bill.jrxml"));
            JasperReport jasperReport = JasperCompileManager.compileReport(load);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JREmptyDataSource(1));
            JasperViewer.viewReport(jasperPrint,false);
        } catch (JRException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        try {
            PlaceOrder placeOrder = PlaceOrderModel.searchCustomer(txtCustomerId.getText());
            if (placeOrder != null) {
                txtName.setText(placeOrder.getName());
                txtAddress.setText(placeOrder.getAddress());
                txtContactNo.setText(placeOrder.getContact());
            }
        }catch (Exception ex){
            System.out.println(ex);

        }

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }

    public void loadCustomerData(){
        try {
            ObservableList<PlaceOrder> customer = PlaceOrderModel.searchAllCustomer();
            tblAllData.setItems(customer);
        }catch (Exception e){

        }

    }


    public void setCellValueFactory(){
        tblCusId.setCellValueFactory(new PropertyValueFactory("cusId"));
        tblOrderId.setCellValueFactory(new PropertyValueFactory("orderId"));
        tblDetails.setCellValueFactory(new PropertyValueFactory("details"));
        tblQty.setCellValueFactory(new PropertyValueFactory("quantity"));
        tblTotal.setCellValueFactory(new PropertyValueFactory("amount"));
        tblCash.setCellValueFactory(new PropertyValueFactory("cash"));
        tblBalance.setCellValueFactory(new PropertyValueFactory("balance"));
    }



    private void clearTxt() {
        txtOrderId.setText("");
        txtDate.setText("");
        txtDetails.setText("");
        txtQty.setText("");
    }

}
