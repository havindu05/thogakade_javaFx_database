package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class SignUpPageController {

    @FXML
    private TextField txtEmailAddress;

    @FXML
    private TextField txtName;

    @FXML
    private PasswordField txtPassword;

    private final String URL = "jdbc:mysql://localhost:3306/Thogakadejavafx";
    private final String USER = "root";
    private final String PASSWORD_DB = "12345678";

    @FXML
    void btnSingUp(ActionEvent event) {
        String name = txtName.getText();
        String email = txtEmailAddress.getText();
        String pass = txtPassword.getText();

        if (name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Please fill all fields!").show();
            return;
        }

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD_DB)) {
            String sql = "INSERT INTO User (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, pass);

            int rows = pst.executeUpdate();
            if (rows > 0) {
                new Alert(Alert.AlertType.INFORMATION, "Sign Up Successful! You can now login.").show();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MainPage.fxml"));
                Scene scene = new Scene(loader.load());
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            new Alert(Alert.AlertType.ERROR, "Email already exists! Use a different email.").show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Database Error: " + e.getMessage()).show();
        }
    }

    @FXML
    void btnLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MainPage.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
