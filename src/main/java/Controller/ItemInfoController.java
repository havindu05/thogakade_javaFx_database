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
import model.DTO.ItemDTO;

import java.io.IOException;
import java.sql.*;

public class ItemInfoController {

    @FXML
    private TableColumn<ItemDTO, String> colItemCode;

    @FXML
    private TableColumn<ItemDTO, String> colDescription;

    @FXML
    private TableColumn<ItemDTO, String> colCategory;

    @FXML
    private TableColumn<ItemDTO, Integer> colQtyOnHand;

    @FXML
    private TableColumn<ItemDTO, Double> colUnitPrice;

    @FXML
    private TableView<ItemDTO> tblItemInfo;

    @FXML
    void btnLoadInfo(ActionEvent event) {
        ObservableList<ItemDTO> itemList = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Thogakadejavafx", "root", "12345678");

             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Item");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                ItemDTO item = new ItemDTO(
                        resultSet.getString("itemCode"),
                        resultSet.getString("description"),
                        resultSet.getString("category"),
                        resultSet.getInt("qtyOnHand"),
                        resultSet.getDouble("unitPrice")
                );
                itemList.add(item);
            }

            colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
            colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
            colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
            colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

            tblItemInfo.setItems(itemList);

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
