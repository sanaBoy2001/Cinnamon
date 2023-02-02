package lk.ijse.RanasingheCinnamon.controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import lk.ijse.RanasingheCinnamon.utill.CrudUtil;
import lk.ijse.RanasingheCinnamon.utill.Navigation;
import lk.ijse.RanasingheCinnamon.utill.Routes;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginFormController {
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public AnchorPane pane;
    public JFXCheckBox cbxShow;
    public JFXTextField txtpwshow1;

    public void initialize(){
        txtpwshow1.setVisible(false);
    }

    public void showPasswordOnAction(){
        if (cbxShow.isSelected()){
            txtpwshow1.setText(txtPassword.getText());
            txtpwshow1.setVisible(true);
            txtPassword.setVisible(false);
        }else {
            txtPassword.setText(txtpwshow1.getText());
            txtPassword.setVisible(true);
            txtpwshow1.setVisible(false);
        }
    }
    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {

        String username = txtUserName.getText();
        String password = txtPassword.getText();

        String sql = "SELECT * FROM user WHERE userName='"+username+"' AND password='"+password+"'";
        ResultSet result = CrudUtil.execute(sql);

        if(result.next()){

            Navigation.navigate(Routes.DASHBOARD,pane);
        }else {
            new Alert(Alert.AlertType.CONFIRMATION, "Please Enter Correct UserName and Password").show();
 }

    }

    public void btnForgotPasswordOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.FORGOT,pane);
    }

    public void btnRegisterOnAction(ActionEvent actionEvent) throws IOException {
            Navigation.navigate(Routes.REGISTER,pane);
    }

    public void userNameOnTyped(KeyEvent keyEvent) {
        Pattern usernamepattern = Pattern.compile("(^[a-zA-Z0-9]{2,}$)");
        Matcher usernamematcher = usernamepattern.matcher(txtUserName.getText());
        boolean isMachedUser = usernamematcher.matches();
        if (!isMachedUser) {
            txtUserName.requestFocus();
            txtUserName.setFocusColor(Paint.valueOf("Red"));

        } else {
            txtUserName.setFocusColor(Paint.valueOf("#4059a9"));
        }
    }

//    public void passwordOnType(KeyEvent keyEvent) {
//        System.out.println(txtpwshow1.getText());
//    }


    public void passwordOnType(KeyEvent keyEvent) {
        System.out.println(txtPassword.getText());
        System.out.println();
        Pattern passwordpattern = Pattern.compile("(^[0-9]{3,}$)");
        Matcher passwordmatcher = passwordpattern.matcher(txtPassword.getText());
        boolean isMachedUser = passwordmatcher.matches();
        System.out.println(isMachedUser);
        if (!isMachedUser) {
            txtPassword.requestFocus();
            txtPassword.setFocusColor(Paint.valueOf("Red"));
            txtpwshow1.setVisible(false);

        } else {
            txtPassword.setFocusColor(Paint.valueOf("#4059a9"));

        }


   }
}
