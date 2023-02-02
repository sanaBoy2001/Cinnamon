package lk.ijse.RanasingheCinnamon.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.RanasingheCinnamon.utill.Navigation;
import lk.ijse.RanasingheCinnamon.utill.Routes;
import rex.utils.S;

import java.io.IOException;

public class ResetPasswordFormController {
    public JFXTextField txtUserName;
    public JFXPasswordField txtNewPassword;
    public JFXPasswordField txtConfirmPassword;
    public AnchorPane pane;

    public void btnResetOnAction(ActionEvent actionEvent) {
        /*String userName = txtUserName.getText();
        String newPassword = txtNewPassword.getText();
        String ConfirmPassword = txtConfirmPassword.getText();

        RegisterDTO register = new RegisterDTO(userName,newPassword,ConfirmPassword);
        boolean isUpdate = RegisterModel.updatePassword(register);
        if (isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION,"Password Reset Success").show();
    }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Something Was Wrong").show();
        }*/
    }
        public void btnBackOnAction (ActionEvent actionEvent) throws IOException {
            Navigation.navigate(Routes.LOGIN, pane);
        }
    }
