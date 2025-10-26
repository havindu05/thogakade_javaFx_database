package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DTO.CustomerDTO;

import java.sql.*;

public class CustomerInfoController {

    @FXML
    private TableColumn<CustomerDTO, String> colCustId;

    @FXML
    private TableColumn<CustomerDTO, String> colTitle;

    @FXML
    private TableColumn<CustomerDTO, String> colName;

    @FXML
    private TableColumn<CustomerDTO, String> colDob;

    @FXML
    private TableColumn<CustomerDTO, Double> colSalary;

    @FXML
    private TableColumn<CustomerDTO, String> colAddress;

    @FXML
    private TableColumn<CustomerDTO, String> colCity;

    @FXML
    private TableColumn<CustomerDTO, String> colProvince;

    @FXML
    private TableColumn<CustomerDTO, String> colPostalCode;

    @FXML
    private TableView<CustomerDTO> tblCustomerInfo;

    @FXML
    void btnLoadInfo(ActionEvent event) {

        ObservableList<CustomerDTO> customerList = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Thogakadejavafx", "root", "12345678");

             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Customer");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                CustomerDTO customer = new CustomerDTO(
                        resultSet.getString("CustId"),
                        resultSet.getString("title"),
                        resultSet.getString("name"),
                        resultSet.getString("dob"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("province"),
                        resultSet.getString("postalCode")
                );

                customerList.add(customer);
            }

            colCustId.setCellValueFactory(new PropertyValueFactory<>("custId"));
            colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
            colSalary.setCellValueFactory(new PropertyValueFactory<>("salaray"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
            colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
            colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

            tblCustomerInfo.setItems(customerList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnCustomerInfo(ActionEvent event) { }

    @FXML
    void btnEmployeeInfo(ActionEvent event) { }

    @FXML
    void btnHomePage(ActionEvent event) { }

    @FXML
    void btnItemInfo(ActionEvent event) { }

    @FXML
    void btnSupplierInfo(ActionEvent event) { }
}
