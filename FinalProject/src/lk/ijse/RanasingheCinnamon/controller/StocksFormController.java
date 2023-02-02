package lk.ijse.RanasingheCinnamon.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import lk.ijse.RanasingheCinnamon.model.StockModel;
import lk.ijse.RanasingheCinnamon.model.SupplierModel;
import lk.ijse.RanasingheCinnamon.to.Stocks;
import lk.ijse.RanasingheCinnamon.to.Supplier;

import java.sql.SQLException;

public class StocksFormController {

    public JFXTextField txtStockId;
    public JFXTextField txtDate;
    public JFXTextField txtCost;
    public JFXTextField txtQuantity;

    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id = txtStockId.getText();
        String date = txtDate.getText();
        String cost = txtCost.getText();
        String Quantity = txtQuantity.getText();

        Stocks stocks = new Stocks(id, date, cost, Quantity);

        boolean isAdded = StockModel.save(stocks);

        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "Stock Added").show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "Unsuccessful");
        }
        clearTxt();
    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Stocks stocks= StockModel.search(txtStockId.getText());
        if(stocks!=null) {
            txtDate.setText(stocks.getDate());
            txtCost.setText(stocks.getCost());
            txtQuantity.setText(stocks.getQuantity());
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDelete =  StockModel.delete(txtStockId.getText());

        if(isDelete){
            new Alert(Alert.AlertType.CONFIRMATION,"Stock Delete Successful").show();
        }
        clearTxt();

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id = txtStockId.getText();
        String date = txtDate.getText();
        String cost = txtCost.getText();
        String quantity = txtQuantity.getText();

        Stocks stocks = new Stocks(id,date,cost,quantity);

        boolean isUpdate = StockModel.update(stocks);

        if(isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION,"Details Updated").show();
        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Something Was Wrong").show();
        }
        clearTxt();
    }

    private void clearTxt() {
        txtStockId.setText("");
        txtDate.setText("");
        txtCost.setText("");
        txtQuantity.setText("");
    }
}
