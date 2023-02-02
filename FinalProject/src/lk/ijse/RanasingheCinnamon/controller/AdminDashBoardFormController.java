package lk.ijse.RanasingheCinnamon.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.ijse.RanasingheCinnamon.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.RanasingheCinnamon.dao.custom.impl.PlaceOrderDAOImpl;
import lk.ijse.RanasingheCinnamon.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.RanasingheCinnamon.dao.custom.impl.VehiclesDAOImpl;
import lk.ijse.RanasingheCinnamon.utill.Navigation;
import lk.ijse.RanasingheCinnamon.utill.Routes;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminDashBoardFormController{
    public AnchorPane contax;
    public AnchorPane pane;
    public Text txtCountOfCustomer;
    public Text txtCountOfEmployees;
    public Text txtCountOfVehicles;
    public Text txtCountOfSuppliers;
    public Text txtTime;
    public Text txtDate;
    public JFXButton btnCusCount;
    public JFXButton btnEmpCount;
    public JFXButton btnSupCount;
    public JFXButton btnVehicleCount;

    public void initialize(){
        setTime();
        setDate();
        loadcustomerCount();
        loadEmployeeCount();
        loadSupplierCount();
        loadVehicleCount();
    }

    public void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        contax.getChildren().clear();
        contax.getChildren().add(node);
    }

    public void loadcustomerCount(){
        try {
            int count = PlaceOrderDAOImpl.customerCount();
            btnCusCount.setText(String.valueOf(count));
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    public void loadEmployeeCount(){
        int empCount = 0;
        try {
            empCount = EmployeeDAOImpl.employeeCount();
        } catch (Exception exception) {

        }
        btnEmpCount.setText(String.valueOf(empCount));
    }

    public void loadSupplierCount(){
        try {
            int count = SupplierDAOImpl.supplierCount();
            btnSupCount.setText(String.valueOf(count));
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    public void loadVehicleCount(){
        try {
            int count = VehiclesDAOImpl.VehicleCount();
            btnVehicleCount.setText(String.valueOf(count));
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    private void setTime(){
        Thread clock = new Thread(){
            public void run(){
                while (true){
                    DateFormat hour = new SimpleDateFormat("hh:mm:ss");
                    txtTime.setText(hour.format(new Date()));

                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {

                    }
                }
            }
        };
        clock.start();
    }

    private void setDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        txtDate.setText(dateFormat.format(new Date()));
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/RanasingheCinnamon/view/PlaceOrderForm");
    }


    public void btnEmployeeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/RanasingheCinnamon/view/ManageEmployeeForm");
    }

    public void btnSupplierOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/RanasingheCinnamon/view/SupplierForm");
    }

    public void btnStockOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/RanasingheCinnamon/view/StocksForm");
    }


    public void btnVehicleOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/RanasingheCinnamon/view/VehiclesForm");
    }

    public void btnPaymentOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/RanasingheCinnamon/view/PaymentsForm");
    }

    public void btnDeliveryOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/RanasingheCinnamon/view/DeliveriesForm");
    }

    public void btnExportOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/RanasingheCinnamon/view/ExportForm");
    }

    public void btnReportOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/RanasingheCinnamon/view/ReportForm");

    }

    public void btnDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,pane);
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }


}


