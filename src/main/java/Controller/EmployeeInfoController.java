package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.DTO.EmployeeDTO;

import java.io.IOException;
import java.sql.*;

public class EmployeeInfoController {

    @FXML
    private TableColumn<EmployeeDTO, String> colEmployeeId;

    @FXML
    private TableColumn<EmployeeDTO, String> colName;

    @FXML
    private TableColumn<EmployeeDTO, String> colNic;

    @FXML
    private TableColumn<EmployeeDTO, String> colDob;

    @FXML
    private TableColumn<EmployeeDTO, String> colPosistion;

    @FXML
    private TableColumn<EmployeeDTO, String> colSalary;

    @FXML
    private TableColumn<EmployeeDTO, String> colNumber;

    @FXML
    private TableColumn<EmployeeDTO, String> colAddress;

    @FXML
    private TableColumn<EmployeeDTO, String> colJoinDate;

    @FXML
    private TableColumn<EmployeeDTO, String> colStatus;

    @FXML
    private TableView<EmployeeDTO> tblEmployeeInfo;

    @FXML
    void btnLoadInfo(ActionEvent event) {
        ObservableList<EmployeeDTO> employeeList = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Thogakadejavafx", "root", "12345678");

             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Employee");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                EmployeeDTO employee = new EmployeeDTO(
                        resultSet.getString("employeeId"),
                        resultSet.getString("name"),
                        resultSet.getString("nic"),
                        resultSet.getString("dob"),
                        resultSet.getString("position"),
                        resultSet.getString("salary"),
                        resultSet.getString("contactNumber"),
                        resultSet.getString("address"),
                        resultSet.getString("joinDate"),
                        resultSet.getString("status")
                );

                employeeList.add(employee);
            }

            colEmployeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
            colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
            colPosistion.setCellValueFactory(new PropertyValueFactory<>("position"));
            colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
            colNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            colJoinDate.setCellValueFactory(new PropertyValueFactory<>("joinDate"));
            colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

            tblEmployeeInfo.setItems(employeeList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnCustomerInfo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CustomerInfo.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnEmployeeInfo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/EmployeeInfo.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnHomePage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MainPage.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnItemInfo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ItemInfo.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnSupplierInfo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/SupplierInfo.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
