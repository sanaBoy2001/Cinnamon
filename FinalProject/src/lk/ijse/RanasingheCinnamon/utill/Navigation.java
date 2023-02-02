package lk.ijse.RanasingheCinnamon.utill;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;
    public static void navigate(Routes routes , AnchorPane pane) throws IOException {

        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (routes){
            case LOGIN:
                window.setTitle(" Login Form");
                initUI("loginForm.fxml");
                break;
            case DASHBOARD:
                window.setTitle(" Dashboard Form");
                initUI("AdminDashBoardForm.fxml");
                break;
            case REGISTER:
                window.setTitle(" Register Form");
                initUI("RegisterForm.fxml");
                break;
            case FORGOT:
                window.setTitle(" ForgotPassword Form");
                initUI("ResetPasswordForm.fxml");
                break;

            default:
                new Alert(Alert.AlertType.ERROR,"Not Suitbale UI found").show();
        }

    }

    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/RanasingheCinnamon/view/"+location)));

    }
}
