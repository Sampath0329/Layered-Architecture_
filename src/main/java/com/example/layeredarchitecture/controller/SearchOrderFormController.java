package com.example.layeredarchitecture.controller;

import com.example.layeredarchitecture.BO.Custom.CustomerBO;
import com.example.layeredarchitecture.BO.Custom.Impl.CustomerBOImpl;
import com.example.layeredarchitecture.BO.Custom.Impl.SearchOrderBOImpl;
import com.example.layeredarchitecture.BO.Custom.OrderBO;
import com.example.layeredarchitecture.BO.Custom.Impl.OrderBOImpl;
import com.example.layeredarchitecture.BO.Custom.SearchOrderBO;
import com.example.layeredarchitecture.dao.Custome.Impl.ItemDAOImpl;
import com.example.layeredarchitecture.dao.Custome.ItemDAO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;
import com.example.layeredarchitecture.view.tdm.SearchOrderTM;
import com.jfoenix.controls.JFXComboBox;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchOrderFormController {

    @FXML
    private JFXComboBox<String> cmbOrderId;

    @FXML
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colDesc;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<SearchOrderTM> tblOrderDetails;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtTotal;

    ItemDAO itemDAO = new ItemDAOImpl();

    SearchOrderBO searchOrderBO = new SearchOrderBOImpl();

    public void initialize(){
        tblOrderDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("code"));
        tblOrderDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblOrderDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblOrderDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblOrderDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("total"));

        cmbOrderId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {


            if (newValue != null) {
                try {
                    try {
                        if (!searchOrderBO.existOrder(newValue + "")) {
                            new Alert(Alert.AlertType.ERROR, "There is no such Order associated with the id " + newValue + "").show();
                        }

                        OrderDTO order = searchOrderBO.getOrder(newValue);

                        txtCustomerId.setText(order.getCustomerId());
                        txtCustomerName.setText(searchOrderBO.getCustomer(order.getCustomerId()).getName());
                        txtDate.setText(String.valueOf(order.getOrderDate()));
                        loadAllOrderDetail(newValue);
                    } catch (SQLException e) {
                        new Alert(Alert.AlertType.ERROR, "Failed to find the Orders " + newValue + "" + e).show();
                    }

                }  catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                txtCustomerName.clear();
            }
        });


        initUI();
        loadAllOrderId();

    }

    private void loadAllOrderDetail(String newValue) {
        tblOrderDetails.getItems().clear();
        Double totalDue =0.0;
        try {
            ArrayList<OrderDetailDTO> orderDetails = searchOrderBO.getAllOderDetails(newValue);

            for (OrderDetailDTO orderDetail : orderDetails){

                ItemDTO item = searchOrderBO.getItem(orderDetail.getItemCode());

                BigDecimal total = orderDetail.getUnitPrice().multiply(new BigDecimal(orderDetail.getQty()));

                tblOrderDetails.getItems().add(
                        new SearchOrderTM(orderDetail.getItemCode(),
                        item.getDescription(),
                        orderDetail.getQty(),
                        orderDetail.getUnitPrice(),
                        total
                ));


                totalDue +=  total.doubleValue();

                txtTotal.setText("Rs : "+ totalDue);
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()+"1").show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void loadAllOrderId() {
        try {
            ArrayList<OrderDTO> allOrders = searchOrderBO.getAllOrders();
            for (OrderDTO order : allOrders){
                cmbOrderId.getItems().add(order.getOrderId());
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to load Order ids").show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }

    private void initUI() {
        txtCustomerId.setFocusTraversable(false);
        txtCustomerId.setEditable(false);
        txtDate.setFocusTraversable(false);
        txtDate.setEditable(false);
        txtTotal.setFocusTraversable(false);
        txtTotal.setEditable(false);
        txtCustomerName.setFocusTraversable(false);
        txtCustomerName.setEditable(false);
    }

    @FXML
    void navigateToHome(MouseEvent event) throws  IOException {
        URL resource = this.getClass().getResource("/com/example/layeredarchitecture/main-form.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }

}
