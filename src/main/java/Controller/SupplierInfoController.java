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
import model.DTO.SupplierDTO;

import java.io.IOException;
import java.sql.*;

public class SupplierInfoController {

    @FXML
    private TableColumn<SupplierDTO, String> colId;

    @FXML
    private TableColumn<SupplierDTO, String> colName;

    @FXML
    private TableColumn<SupplierDTO, String> colCompany;

    @FXML
    private TableColumn<SupplierDTO, String> colAddress;

    @FXML
    private TableColumn<SupplierDTO, String> colCity;

    @FXML
    private TableColumn<SupplierDTO, String> colProvince;

    @FXML
    private TableColumn<SupplierDTO, String> colPostalCode;

    @FXML
    private TableColumn<SupplierDTO, String> colPhone;

    @FXML
    private TableColumn<SupplierDTO, String> colEmail;

    @FXML
    private TableView<SupplierDTO> tblSupplierInfo;

    @FXML
    void btnLoadInfo(ActionEvent event) {
        ObservableList<SupplierDTO> supplierList = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Thogakadejavafx", "root", "12345678");

             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Supplier");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                SupplierDTO supplier = new SupplierDTO(
                        resultSet.getString("supplierId"),
                        resultSet.getString("name"),
                        resultSet.getString("companyName"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("province"),
                        resultSet.getString("postalCode"),
                        resultSet.getString("phone"),
                        resultSet.getString("email")
                );

                supplierList.add(supplier);
            }

            colId.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colCompany.setCellValueFactory(new PropertyValueFactory<>("compnayName"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
            colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
            colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
            colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

            tblSupplierInfo.setItems(supplierList);

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
