package lk.ijse.RanasingheCinnamon.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.RanasingheCinnamon.dao.custom.impl.StockDAOImpl;
import lk.ijse.RanasingheCinnamon.dto.StocksDTO;

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

        StocksDTO stocks = new StocksDTO(id, date, cost, Quantity);

        boolean isAdded = StockDAOImpl.save(stocks);

        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "Stock Added").show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "Unsuccessful");
        }
        clearTxt();
    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        StocksDTO stocks= StockDAOImpl.search(txtStockId.getText());
        if(stocks!=null) {
            txtDate.setText(stocks.getDate());
            txtCost.setText(stocks.getCost());
            txtQuantity.setText(stocks.getQuantity());
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDelete =  StockDAOImpl.delete(txtStockId.getText());

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

        StocksDTO stocks = new StocksDTO(id,date,cost,quantity);

        boolean isUpdate = StockDAOImpl.update(stocks);

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
