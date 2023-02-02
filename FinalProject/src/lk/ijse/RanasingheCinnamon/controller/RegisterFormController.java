package lk.ijse.RanasingheCinnamon.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.RanasingheCinnamon.dao.custom.impl.RegisterDAOImpl;
import lk.ijse.RanasingheCinnamon.dto.RegisterDTO;
import lk.ijse.RanasingheCinnamon.utill.Navigation;
import lk.ijse.RanasingheCinnamon.utill.Routes;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterFormController {
    public TextField txtAddress;
    public TextField txtName;
    public TextField txtTelNo;
    public TextField txtEmail;
    public TextField txtUserId;
    public TextField txtUserName;
    public TextField txtPassword;
    public AnchorPane pane;

    public void btnRegisterOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {

        String UId = txtUserId.getText();
        String Uname = txtName.getText();
        String Uemail = txtEmail.getText();
        String Uaddress = txtAddress.getText();
        String UtelNo = txtTelNo.getText();
        String UserName = txtUserName.getText();
        String password = txtPassword.getText();

        RegisterDTO register = new RegisterDTO(UId,Uname,Uemail,Uaddress,UtelNo,UserName,password);

        boolean isAdded = RegisterDAOImpl.save(register);

        if(isAdded){
            new Alert(Alert.AlertType.CONFIRMATION,"RegisterDTO Completed").show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION,"Please try again").show();
        }
        Navigation.navigate(Routes.LOGIN,pane);
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }
}
